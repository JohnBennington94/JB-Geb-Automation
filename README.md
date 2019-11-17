# Testing Property Pal

## Description

The build is setup to work with Firefox and Chrome. 

Have a look at the `build.gradle` and the `src/test/resources/GebConfig.groovy` files.

## Pre-requisites

Gradle build has been tested with and works with jdk version 1.8 - higher versions may not be supported without updating dependencies

## Usage

The following commands will launch the tests with the individual browsers:

    ./gradlew chromeTest
    ./gradlew firefoxTest

To run with all, you can run:

    ./gradlew test

Replace `./gradlew` with `gradlew.bat` in the above examples if you're on Windows.

## Debugging with JUnit

To run single tests or specs outside of the gradle build to debug, add the following as VM options on Junit debug configuration in your chosen IDE:

`-Dgeb.env=chrome`

`-Dwebdriver.chrome.driver='PATH_TO_CHROMEDRIVER'`

## Test Results

HTML results files are written to are stored in:

`build/reports/tests/`

Open index.html in a browser to view results
    
