# Overview

<div align="center">

[![Build Status](https://travis-ci.org/astrapi69/ent-core.svg?branch=develop)](https://travis-ci.org/astrapi69/ent-core) 
[![Open Issues](https://img.shields.io/github/issues/astrapi69/ent-core.svg?style=flat)](https://github.com/astrapi69/ent-core/issues) 
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/ent-core/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/ent-core)
[![Javadocs](http://www.javadoc.io/badge/de.alpharogroup/ent-core.svg)](http://www.javadoc.io/doc/de.alpharogroup/ent-core)
[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

</div>

This project holds base and abstract entities.

If you like this project put a ⭐ and donate

## Note

No animals were harmed in the making of this library.

# Donations

If you like this library, please consider a donation through bitcoin or over bitcoin-cash with:

36JxRRDfRazLNqUV6NsywCw1q7TK38ukpC

or over ether with:

0x588Aa02De98B1Ef70afeDC3ec5290130a3E5e273

or over donate buttons at the top

## License

The source code comes under the liberal MIT License, making ent-core great for all types of applications.

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~de.alpharogroup~ent-core~~~) for latest snapshots and releases.

Add the following maven dependency to your project `pom.xml` if you want to import the core functionality of ent-core:

Than you can add the dependency to your dependencies:

	<properties>
			...
		<!-- ENT-CORE version -->
		<ent-core.version>2</ent-core.version>
			...
	</properties>
			...
		<dependencies>
			...
			<!-- ENT-CORE DEPENDENCY -->
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>ent-core</artifactId>
				<version>${ent-core.version}</version>
			</dependency>
			...
		</dependencies>

	
## gradle dependency

Add the following gradle dependency to your project `build.gradle` in the dependencies section if you want to import the core functionality of ent-core:

```
ext {
			...
    entCoreVersion = "2"
			...
}
dependencies {
			...
	implementation("de.alpharogroup:ent-core:$entCoreVersion")
			...
}
```

## Semantic Versioning

The versions of ent-core are maintained with the Simplified Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning for this project you can visit this [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Simplified-Semantic-Versioning).

## Want to Help and improve it? ###

The source code for ent-core are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/ent-core/fork](https://github.com/astrapi69/ent-core/fork)

To share your changes, [submit a pull request](https://github.com/astrapi69/ent-core/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developers

Do not hesitate to contact the ent-core developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/astrapi69/ent-core/issues).

## Credits

|**Travis CI**|
|     :---:      |
|[![Travis CI](https://travis-ci.com/images/logos/TravisCI-Full-Color.png)](https://coveralls.io/github/astrapi69/ent-core?branch=develop)|
|Special thanks to [Travis CI](https://travis-ci.org) for providing a free continuous integration service for open source projects|
|     <img width=1000/>     |

|**Nexus Sonatype repositories**|
|     :---:      |
|[![sonatype repository](https://img.shields.io/nexus/r/https/oss.sonatype.org/de.alpharogroup/ent-core.svg?style=for-the-badge)](https://oss.sonatype.org/index.html#nexus-search;gav~de.alpharogroup~ent-core~~~)|
|Special thanks to [sonatype repository](https://www.sonatype.com) for providing a free maven repository service for open source projects|
|     <img width=1000/>     |

|**javadoc.io**|
|     :---:      |
|[![Javadocs](http://www.javadoc.io/badge/de.alpharogroup/ent-core.svg)](http://www.javadoc.io/doc/de.alpharogroup/ent-core)|
|Special thanks to [javadoc.io](http://www.javadoc.io) for providing a free javadoc documentation for open source projects|
|     <img width=1000/>     |
