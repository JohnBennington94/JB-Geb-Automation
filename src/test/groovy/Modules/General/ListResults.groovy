package Modules.General

import geb.Module

class ListResults extends Module {

    static content = {

        //Body and List
        searchResultsBody(required: false) { $("div.sr-body") }
        searchResultsList(required: false) { searchResultsBody.find("ul.boxlist") }

        //Property Results Cards - To Let
        resultPropToLetInList(required: false) { searchResultsList.find("div.box.propbox--tolet") }
        propToLetBoxDetails(required: false) { resultPropToLetInList.find("div.propbox-details") }
        propToLetTitleInDetails(required: false) { propToLetBoxDetails.find("h2") }

        //Property Results Cards - For Sale
        resultPropForSaleInList(required: false) { searchResultsList.find("div.box.propbox--forsale") }
        propForSaleBoxDetails(required: false) { resultPropForSaleInList.find("div.propbox-details") }
        propForSaleTitleInDetails(required: false) { propForSaleBoxDetails.find("h2") }

        //No Results
        noResultsSuggestions(required: false) { $("div.noresults-suggestions") }
        noResultsExplanationText(required: false) { $("p.noresults-intro") }

    }

}
