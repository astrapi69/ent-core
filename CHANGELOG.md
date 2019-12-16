## Change log
----------------------

Version 1.10-SNAPSHOT
-------------



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
