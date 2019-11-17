package Modules.General

import geb.Module

class CookiesBanner extends Module {

    public static final String ACCEPT_BUTTON_TEXT = "I ACCEPT"

    static content = {

        cookieButtonsSection(required: false) { $("div#qcCmpButtons") }
        acceptCookiesButton(required: false) { cookieButtonsSection.find("button.qc-cmp-button", text: ACCEPT_BUTTON_TEXT) }

        genericButton { $("button.qc-cmp-button")}

    }

    void clickAcceptCookiesButton(){
        waitFor { acceptCookiesButton.displayed }
        waitFor { acceptCookiesButton.click() }
        waitFor { !acceptCookiesButton.displayed }
    }
}
