package Modules.General

import geb.Module

class CookiesBanner extends Module {

    //String to uniquely identify the accept button against others
    public static final String ACCEPT_BUTTON_TEXT = "I ACCEPT"

    static content = {

        //Buttons
        cookieButtonsSection(required: false) { $("div#qcCmpButtons") }
        acceptCookiesButton(required: false) { cookieButtonsSection.find("button.qc-cmp-button", text: ACCEPT_BUTTON_TEXT) }

    }

    void clickAcceptCookiesButton(){
        waitFor { acceptCookiesButton.displayed }
        waitFor { acceptCookiesButton.click() }
        waitFor { !acceptCookiesButton.displayed }
    }

}
