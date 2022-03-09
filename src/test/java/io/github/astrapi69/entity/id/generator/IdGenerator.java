package io.github.astrapi69.entity.id.generator;

/**
 * The interface {@link IdGenerator} provides a method for get the next id.
 *
 * @deprecated use instead the same name interface from module data-api
 */
@Deprecated
public interface IdGenerator<T>
{

	/**
	 * Gets the next id
	 * 
	 * @return the next id
	 */
	T getNextId();

}
