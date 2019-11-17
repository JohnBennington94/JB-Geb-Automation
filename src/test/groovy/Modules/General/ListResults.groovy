package Modules.General

import geb.Module

class ListResults extends Module {

    static content = {

        //Body and List
        searchResultsBody { $("div.sr-body") }
        searchResultsList(required: false) { searchResultsBody.find("ul.boxlist") }

        //Property Results Cards
        resultPropBoxInList(required: false) { searchResultsList.find("div.box.propbox") }
        propBoxDetails(required: false) { resultPropBoxInList.find("div.propbox-details") }
        propTitleInDetails(required: false) { propBoxDetails.find("h2") }

        //No Results
        noResultsSuggestions(required: false) { $("div.noresults-suggestions") }
        noResultsExplanationText(required: false) { $("p.noresults-intro") }

    }

}
