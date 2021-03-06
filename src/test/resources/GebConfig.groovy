/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/#configuration
*/


import Utils.DefaultValues
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver

waiting {
	timeout = 10
}

environments {

	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = {
			ChromeOptions o = new ChromeOptions()
			o.addArguments('--disable-geolocation')
			new ChromeDriver(o)
		}
	}

	// run via “./gradlew chromeHeadlessTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chromeHeadless {
		driver = {
			ChromeOptions o = new ChromeOptions()
			o.addArguments('headless')
			new ChromeDriver(o)
		}
	}
	
	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		atCheckWaiting = 1

		driver = { new FirefoxDriver() }
	}

}

// To run the tests with all browsers just run “./gradlew test”

baseUrl = DefaultValues.BASE_URL
reportsDir = new File("target/junit_debug")
