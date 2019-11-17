package Pages.Base

import Modules.General.CookiesBanner
import geb.Page
import geb.waiting.WaitTimeoutException

class BasePage extends Page {

    static content = {

        headerNavBar(required: false) { $("header#header") }

        //Cookies Banner Module
        cookiesBannerContainer(required: false) { $("div#qcCmpUi") }
        cookiesBannerModule { cookiesBannerContainer.module(CookiesBanner) }
        cookiesWarningShowing(required: false) { $("div.qc-cmp-ui-container.qc-cmp-showing") }

    }

    //Method to handle cookies pop up
    void acceptCookies(){
        try {
            waitFor(5) { cookiesBannerContainer.displayed }
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
