# Testing Property Pal

## Description

The build is setup to work with Chrome 

Have a look at the `build.gradle` and the `src/test/resources/GebConfig.groovy` files.

## Pre-requisites

Gradle build has been tested with and works with jdk version 1.8 - higher versions may not be supported without updating dependencies

A path to an Android sdk will need to be specified in the 'local.properties' file at line 8 - version 29.0.2 has been tested to run the build successfully

## Running all Tests with Gradle

Running the 'build' task on Gradle will initialise the project and run all tests in chrome - as per the setting in the build.gradle file

All tests can also be run via the following command: 

`./gradlew test`

## Debugging Tests with JUnit

To run single tests or specs outside of the gradle build to debug, add the following as VM options on Junit debug configuration in your chosen IDE:

`-Dgeb.env=chrome`

`-Dwebdriver.chrome.driver='PATH_TO_CHROMEDRIVER'`

## Test Results

HTML results files from the Gradle build task are written to are stored in:

`build/reports/tests/chromeTest`

Open index.html in a browser to view all package results
    
