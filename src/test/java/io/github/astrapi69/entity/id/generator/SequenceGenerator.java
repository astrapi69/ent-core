package io.github.astrapi69.entity.id.generator;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.prefs.Preferences;

/**
 * Example of stackoverflow.com
 * see 'https://stackoverflow.com/questions/22416826/sequence-generator-in-java-for-unique-id'
 */
public final class SequenceGenerator {

    private static final Preferences PREFS = Preferences.userNodeForPackage(SequenceGenerator.class);
    private static final AtomicLong SEQ_ID = new AtomicLong(Integer.parseInt(PREFS.get("seq_id", "1")));
    private static final Map<Long, SoftReference<SequenceGenerator>> GENERATORS = new ConcurrentHashMap<>();
    private static final SequenceGenerator DEF_GENERATOR = new SequenceGenerator(0L, Long.parseLong(PREFS.get("seq_0", "1")));

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            GENERATORS.values().stream()
                    .map(SoftReference::get)
                    .filter(seq -> seq != null && seq.isPersistOnExit())
                    .forEach(SequenceGenerator::persist);
            if (DEF_GENERATOR.isPersistOnExit()) {
                DEF_GENERATOR.persist();
            }
            PREFS.put("seq_id", SEQ_ID.toString());
        }));
    }

    private final long sequenceId;
    private final AtomicLong counter;
    private final AtomicBoolean persistOnExit = new AtomicBoolean();

    private SequenceGenerator(long sequenceId, long initialValue) {
        this.sequenceId = sequenceId;
        counter = new AtomicLong(initialValue);
    }

    public long nextId() {
        return counter.getAndIncrement();
    }

    public long currentId() {
        return counter.get();
    }

    public long getSequenceId() {
        return sequenceId;
    }

    public boolean isPersistOnExit() {
        return persistOnExit.get();
    }

    public void setPersistOnExit(boolean persistOnExit) {
        this.persistOnExit.set(persistOnExit);
    }

    public void persist() {
        PREFS.put("seq_" + sequenceId, counter.toString());
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        GENERATORS.remove(sequenceId);
        if (persistOnExit.get()) {
            persist();
        }
    }

    @Override
    public int hashCode() {
        return Long.hashCode(sequenceId);
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this || obj != null && obj instanceof SequenceGenerator && sequenceId == ((SequenceGenerator) obj).sequenceId;
    }

    @Override
    public String toString() {
        return "{" +
                "counter=" + counter +
                ", seq=" + sequenceId +
                '}';
    }

    public static SequenceGenerator getDefault() {
        return DEF_GENERATOR;
    }

    public static SequenceGenerator get(long sequenceId) {
        if (sequenceId < 0) {
            throw new IllegalArgumentException("(sequenceId = " + sequenceId + ") < 0");
        }
        if (sequenceId == 0) {
            return DEF_GENERATOR;
        }
        SoftReference<SequenceGenerator> r = GENERATORS.computeIfAbsent(sequenceId, sid -> {
            try {
                return new SoftReference<>(new SequenceGenerator(sid, Long.parseLong(PREFS.get("seq_" + sid, null))));
            } catch (Throwable t) {
                return null;
            }
        });
        return r == null ? null : r.get();
    }

    public static SequenceGenerator create() {
        return create(1);
    }

    public static SequenceGenerator create(long initialValue) {
        long sequenceId = SEQ_ID.getAndIncrement();
        SequenceGenerator seq = new SequenceGenerator(sequenceId, Long.parseLong(PREFS.get("seq_" + sequenceId, "" + initialValue)));
        GENERATORS.put(sequenceId, new SoftReference<>(seq));
        return seq;
    }

}
