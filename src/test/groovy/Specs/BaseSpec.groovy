package Specs

import Pages.HomePage
import geb.spock.GebReportingSpec

class BaseSpec extends GebReportingSpec {

    def setup() {
        def homePage = to HomePage
        homePage.acceptCookies()
    }

}
