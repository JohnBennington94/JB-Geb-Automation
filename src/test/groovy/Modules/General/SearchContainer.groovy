package Modules.General

import geb.Module

class SearchContainer extends Module {

    static content = {

        //General Content
        searchBarInput { $("input.search-form-textbox#query") }
        suggestedSearchDropDown(required: false) { $("div.suggestions-scroll") }
        myLocationSuggestionLink(required: false) { suggestedSearchDropDown.find("a.suggestions-location") }

    }

    void clearSearchBar(){
        waitFor { searchBarInput.displayed }
        searchBarInput.firstElement().clear()
        waitFor { searchBarInput.value() == "" }
    }

    void clickSearchBarFollowMyLocationLink(){
        clearSearchBar()
        waitFor { searchBarInput.click() }
        waitFor { suggestedSearchDropDown.displayed }
        waitFor { myLocationSuggestionLink.click() }
    }

}
