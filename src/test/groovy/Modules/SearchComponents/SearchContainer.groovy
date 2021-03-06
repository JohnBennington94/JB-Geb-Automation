package Modules.SearchComponents

import Utils.DefaultValues
import geb.Module

class SearchContainer extends Module {

    public static final String MY_LOCATION_PLACEHOLDER = "My Location"

    static content = {

        //Search bar and suggestion drop downs
        searchBarInput { $("input.search-form-textbox#query") }
        suggestedSearchDropDown(required: false) { $("div.suggestions-scroll") }
        myLocationSuggestionLink(required: false) { suggestedSearchDropDown.find("a.suggestions-location") }

        //Searching buttons
        searchButtonsSection { $("div.search-btns")}
        forSaleButton(required: false) { searchButtonsSection.find("button.btn-buy") }
        forRentButton(required: false) { searchButtonsSection.find("button.btn-rent") }

        //Mile radius select
        searchRadiusSelect(required: false) { $("select.nice-select#searchForm_radius") }
        searchRadiusSelectedOption(required: false) { searchRadiusSelect.find("option", selected:"selected") }

    }

    void clearSearchBar(){
        waitFor { searchBarInput.displayed }
        searchBarInput.firstElement().clear()
        waitFor { searchBarInput.value() == "" }
    }

    void clickSearchBarFollowMyLocationLink(String option){
        clearSearchBar()
        waitFor { searchBarInput.click() }
        waitFor { suggestedSearchDropDown.displayed }
        waitFor { myLocationSuggestionLink.displayed }
        waitFor { myLocationSuggestionLink.click() }
        waitFor { !suggestedSearchDropDown.displayed }
        waitFor { searchBarInput.value() == MY_LOCATION_PLACEHOLDER }
        clickOnButtonToSubmitSearch(option)
    }

    void setSearchInputTo(String inputString){
        clearSearchBar()
        waitFor { searchBarInput << inputString }
        waitFor { searchBarInput.value() == inputString }
    }

    void searchTermAndSelectOption(String searchTerm, String option){
        setSearchInputTo(searchTerm)
        clickOnButtonToSubmitSearch(option)
    }

    void clickOnButtonToSubmitSearch(String option){
        switch(option) {
            case DefaultValues.SEARCH_FOR_SALE:
                waitFor { forSaleButton.displayed }
                waitFor { forSaleButton.click() }
                break
            case DefaultValues.SEARCH_FOR_RENT:
                waitFor { forRentButton.displayed }
                waitFor { forRentButton.click() }
                break
            default:
                throw new Exception("Option provided exceeds valid implementations for method")
                break
        }
    }

}
