# Testing Property Pal

## Description

This is an example of incorporating Geb into a Gradle build. It shows the use of Spock and JUnit 4 tests.

The build is setup to work with Firefox and Chrome. Have a look at the `build.gradle` and the `src/test/resources/GebConfig.groovy` files.

##Pre-requisites

Gradle build has been tested with and works with jdk version 1.8 - higher versions may not be supported without updating dependencies

## Usage

The following commands will launch the tests with the individual browsers:

    ./gradlew chromeTest
    ./gradlew firefoxTest

To run with all, you can run:

    ./gradlew test

Replace `./gradlew` with `gradlew.bat` in the above examples if you're on Windows.

##Test Results

HTML results files are written to are stored in:

`build/reports/tests/`
    
