<img src="https://ih0.redbubble.net/image.121379875.8690/sticker,220x200-bg,ffffff-pad,220x200,ffffff.u3.jpg"/>

### M.A.R.S - A simple Hover Path Finder implementation Algorithm.

----------------------
[![license](https://img.shields.io/github/license/mashape/apistatus.svg)]() [![Github All Releases](https://img.shields.io/github/downloads/ovflowd/mars/total.svg)]() [![GitHub release](https://img.shields.io/github/release/ovflowd/mars.svg)]() 
[![GitHub issues](https://img.shields.io/github/issues/ovflowd/mars.svg)]() [![codecov](https://codecov.io/gh/ovflowd/mars/branch/master/graph/badge.svg)](https://codecov.io/gh/ovflowd/mars) [![Docker Pulls](https://img.shields.io/docker/pulls/ovflowd/mars.svg)]()

#### Build Status

Windows | Linux | Artifacts |
--------|--------------|-----------|
[![Build status](https://ci.appveyor.com/api/projects/status/0w89cdu2wsi8ay0s?svg=true)](https://ci.appveyor.com/project/sant0ro/mars) | [![Build Status](https://travis-ci.org/sant0ro/mars.svg?branch=master)](https://travis-ci.org/sant0ro/mars) | [Artifacts](https://github.com/sant0ro/mars/releases) |

## About

This is a small REST micro service to simulate a **Hover** movement control in Mars. This project was made using the following technologies:

* JEE 8
* Spring Boot 2.0
* jUnit Jupiter
* REST
* TDD
* And other minor specifications.

The project it's following the [IETF RFC 2616](https://tools.ietf.org/html/rfc2616).

## Installation

You can clone this repository, or download the latest binaries.

### From Source

**Note.:** You need Java SDK 1.8 or higher.

Building from the Source it's easy by using the [Gradle Wrapper](htts://gradle.org).

```
gradlew build
```

### From Binaries

**Note.:** You need Java Runtime Environment 1.8 or higher.

```
java -jar mars-VERSION.jar
```

## Testing & Running

### Testing

This application contains Integration and Unit Tests for each Useful Domain and Controller.

**Note.:** We're using the Functional Programming paradigm for the Integration Tests, that means, we're not running a contained web server.

```
gradlew test
```

### Running the Application

You can just follow what explained on [From Binaries](#From-Binaries) or run the following Gradle command:

```
gradlew bootRun
```

## Extras

### Building a Docker Image

You can deploy a Docker Image from this project by running

```
gradlew prepareDockerImage

docker build -t vendor/name build/docker
```

### Coverage Reports

Coverage Reports are automatically generated in XML and HTML format after the `build` or the `test` commands.

## Contributing

You can easily contribute to this project, just follow our [Contributing Guidelines](.github/CONTRIBUTING.md)

## License

This software followsthe [MIT License](LICENSE), and was made for the test and development purpose for the applying of [ContaAzul](https://contaazul.com/) as Software Engineer.

Feel free to edit, update and do whatever you want.

