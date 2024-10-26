## Change log
----------------------

Version 5.2-SNAPSHOT
-------------


Version 5.1
-------------

ADDED:

- new libs.versions.toml file for new automatic catalog versions update

CHANGED:

- rename of module to new name 'io.github.astrapisixtynine.ent.core'
- update gradle version to 8.10.2
- update of dependency lombok version to 1.18.34
- update of gradle-plugin dependency with id 'com.github.ben-manes.versions' to new patch version 0.51.0
- update of gradle-plugin dependency with id 'org.ajoberstar.grgit' to new patch version 5.3.0
- update of gradle-plugin dependency with id 'io.freefair.lombok' to new patch version 8.10.2
- update of gradle-plugin dependency with id 'com.diffplug.spotless' to new beta version 7.0.0.BETA4
- update of gradle-plugin dependency with id 'nl.littlerobots.version-catalog-update' to new minor version 0.8.5
- update of dependency data-api to new major version 5
- update of dependency jakarta.persistence-api to new minor version 3.2.0
- update of test dependency junit-jupiter to new version 5.11.3
- dependencies are managed now over bundles

Version 5
-------------

CHANGED:

- update jdk version to 17
- upgrade dependency javax.persistence with new jakarta.persistence in version 3.1.0

Version 4.1
-------------

CHANGED:

- update gradle version to 8.5
- update of dependency lombok version to 1.18.30
- update of gradle-plugin dependency io.freefair.gradle:lombok-plugin to new patch version 8.4
- update of gradle-plugin dependency com.github.ben-manes.versions.gradle.plugin to new minor version 0.50.0
- update of gradle-plugin dependency grgit-gradle to new minor version 5.2.1
- update of gradle-plugin dependency spotless-plugin-gradle to new minor version 6.23.3
- update of dependency data-api to new minor version 4.1
- update of test dependency junit-jupiter version to new patch version 5.10.1
- update of test dependency meanbean version to new milestone version 3.0.0-M9

Version 4
-------------

ADDED:

- new module-info.java file for module information

CHANGED:

- update jdk version to 11
- update gradle version to 7.5.1
- update of dependency lombok version to 1.18.24
- update of data-api dependency to new major version 4
- update of gradle-plugin dependency spotless-plugin-gradle to new minor version 6.11.0
- update of gradle-plugin dependency grgit-gradle to new minor version 5.0.0
- moved all base classes from package 'io.github.astrapi69.entity.base.*' to 'io.github.astrapi69.entity.identifiable.*'
- removed all classes that are tagged as deprecated

Version 3.2
-------------

ADDED:

- new lombok annotations for @EqualsAndHashCode and @ToString to all subclasses that call super

CHANGED:

- tagged all classes IdGenerator as deprecated, classes are moved to own module id-generate

Version 3.1
-------------

ADDED:

- new class AtomicBigInteger for generator class BigIntegerIdGenerator
- new generator class BigIntegerIdGenerator for id generation of type BigInteger
- new generator class IntegerIdGenerator for id generation of type Integer
- new generator class LongIdGenerator for id generation of type Long

CHANGED:

- update gradle to new version 7.4.1
- update of gradle-plugin dependency com.diffplug.spotless:spotless-plugin-gradle to new minor version 6.3.0
- update of gradle-plugin dependency io.freefair.gradle:lombok-plugin to new patch version 6.4.1
- update of data-api dependency to new patch version 3.2.1
- tagged class IdGenerator as deprecated, class is moved to module data-api

Version 3
-------------

ADDED:

- new dependency io.github.astrapi69:data-api in major version 3 that replace the dependency ent-api
- new workflow for build with gradle with github-actions
- new gradle-plugin dependency com.diffplug.spotless:spotless-plugin-gradle in version 6.2.2

CHANGED:

- update gradle version to 7.4
- removed dependency io.github.astrapi69:ent-api
- update of gradle-plugin dependency com.github.ben-manes.versions.gradle.plugin to new version 0.42.0
- update of gradle-plugin dependency io.freefair.gradle:lombok-plugin to new version 6.4.0

Version 2.3
-------------

ADDED:

- new class TreeableUUIDEntity that extends UUIDEntity and implements Treeable
- new class TreeWithChildrenUUIDEntity that holds also a collection of children

CHANGED:

- update of ent-api dependency to new minor version 2.3
- renamed entity class TreeableEntity to TreeEntity
- renamed entity class TreeableUUIDEntity to TreeUUIDEntity

Version 2.2
-------------

ADDED:

- new gradle-plugin org.ajoberstar.grgit:grgit-gradle in version 4.1.1 for create git tags
- new gradle options for improve gradle build performance

CHANGED:

- update gradle to new version 7.3.3
- update of dependency lombok version to 1.18.22
- update of ent-api dependency to new minor version 2.2
- update of com.github.ben-manes.versions.gradle.plugin to new version 0.41.0

Version 2.1
-------------

ADDED:

- new class for generate id from system time
- new class for the process info from a verifiable object
- new enum class for the verifaction state
- new junit 5 dependency for unit tests

CHANGED:

- changed to new package io.github.astrapi69
- update gradle to new version 7.3.2
- update of dependency lombok version to 1.18.22
- update of ent-api dependency to new minor version 2.1
- update of com.github.ben-manes.versions.gradle.plugin to new version 0.39.0
- removed deprecated repository jcenter from the repositories

Version 2
-------------

CHANGED:

- update gradle to new version 6.6.1
- update of ent-api dependency to new major version 2
- update of com.github.ben-manes.versions.gradle.plugin to new version 0.31.0
- update of all entities so they dont implement Serializable anymore

Version 1.12
-------------

ADDED:

- new entity class ByCreation that refects the old Creation
- new entity class ByDeletion that refects the old Deletion
- new entity class ByLastModification that refects the old LastModification

CHANGED:

- update of ent-api dependency to version 1.10
- adapted related entities from the update of dependency ent-api
- removed the field createdBy from the class Creation
- removed the field deletedBy from the class Deletion
- removed the field lastModifiedBy from the class LastModification
- update of com.github.ben-manes.versions.gradle.plugin to new version 0.29.0

Version 1.11
-------------

ADDED:

- new entity classes that have to be signed and verified

CHANGED:

- update gradle version to 6.5.1
- update of ent-api dependency to version 1.8
- renamed several packages for clarity

Version 1.10
-------------

CHANGED:

- update gradle version to 6.1.1
- NameUUIDEntity implements now IdentifiableNameable
- removed deprecated entity classes
- moved dependency versions to gradle.properties file
- javadoc extended

Version 1.9
-------------

ADDED:

- new idea run configurations for gradle builds created
- new jacoco plugin added for code coverage

CHANGED:

- update of ent-api dependency to version 1.6
- update of testng test dependency version to 7.1.0
- update of junit test dependency version to 4.13-rc-2
- update of mockito-core test dependency version to 3.2.4

Version 1.8.1
-------------

CHANGED:

- build errors fixed
- obsolete maven build scripts deleted

Version 1.8
-------------

ADDED:

- new base entities with different generation types of the id

CHANGED:

- moved column constants from the entity classes to the appropriate interfaces
- tagged BaseEntity as deprecated

Version 1.7.1
-------------

ADDED:

- new versionable entity that derives from UUIDEntity created

CHANGED:

- removed deprecated class VersionableBaseEntity

Version 1.7
-------------

ADDED:

- new name entities that extends from the UUIDEntity

CHANGED:

- entities UniqueableEntity and UUIDEntity are with the lombok annotation SuperBuilder annotated

Version 1.6
-------------

ADDED:

- new constants for all relevant columns created
- created new class VersionableEntity that replaces the class VersionableBaseEntity

CHANGED:

- VersionableBaseEntity tagged as deprecated

Version 1.5
-------------

ADDED:

- new class DatabaseAttribute created that holds constants for annotation attributes for an entity class

CHANGED:

- update of ent-api dependency to version 1.4.1
- changed strategy to sequence for the id field

Version 1.4
-------------

ADDED:

- new entity class TreeableEntity that provides keeping data with in a tree structure

CHANGED:

- update of ent-api dependency to version 1.3.1
- gradle as build system

Version 1.3.2
-------------

ADDED:

- new abstract entities created for store a variable length of name values

Version 1.3.1
-------------

ADDED:

- new abstract entity for store a variable length of unique text values
- new versionable abstract entity for store a variable length of text values
- new versionable abstract entity for store a variable length of unique text values

Version 1.3
-------------

ADDED:

- new abstract entity for store a variable length of text values

CHANGED:

- update of ent-api dependency to version 1.2

Version 1.2.1
-------------

CHANGED:

- added new constants for prefixes in the BaseEntity class

Version 1.2
-------------

CHANGED:

- update of parent version to 5
- added new prefixes for unique constraints and foreign keys in enum DatabasePrefix
- update of ent-api dependency to version 1.1
- replaced hibernate with javax.persistence-api dependency

Version 1.1
-------------

CHANGED:

- update of parent version to 4.5
- update of hibernate version to 5.4.0.Final

Version 1
-------------

ADDED:

- this changelog file
