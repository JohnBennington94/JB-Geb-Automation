package Pages

import Modules.General.CookiesBanner
import Modules.General.SearchContainer
import Utils.DefaultValues
import geb.waiting.WaitTimeoutException

class HomePage extends BasePage {

    static url = DefaultValues.BASE_URL

    static at = {
        logoImage.displayed
    }

    static content = {

        //General Content
        logoImage { $("img.search-logo") }

        //Search Bar Container and Module
        searchContainer { $("form#searchForm") }
        searchContainerModule { searchContainer.module(SearchContainer) }

        //Cookies Banner Module
        cookiesBannerContainer(required: false) { $("div#qcCmpUi") }
        cookiesBannerModule { cookiesBannerContainer.module(CookiesBanner) }
        cookiesWarningShowing(required: false) { $("div.qc-cmp-ui-container.qc-cmp-showing")}

    }

    //Method to handle cookies pop up
    void acceptCookies(){
        try {
            waitFor(2) { cookiesBannerContainer.displayed }
            if(cookiesBannerContainer.displayed){
                cookiesBannerModule.clickAcceptCookiesButton()
            }
        }
        catch (WaitTimeoutException exception) {
            //Nothing to do - cookies banner is not displayed
        }
        waitFor { !cookiesWarningShowing.displayed }
    }

}
