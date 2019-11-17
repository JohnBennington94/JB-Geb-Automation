package Specs

import Pages.HomePage
import static Utils.DefaultValues.*
import geb.spock.GebReportingSpec
import org.openqa.selenium.Dimension

class BaseSpec extends GebReportingSpec {

    def setup() {
        driver.manage().window().size = new Dimension(DEFAULT_BROWSER_SCREEN_WIDTH, DEFAULT_BROWSER_SCREEN_HEIGHT)
        def homePage = to HomePage
        homePage.acceptCookies()
    }

}
