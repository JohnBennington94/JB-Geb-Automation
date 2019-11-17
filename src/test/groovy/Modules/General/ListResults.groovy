package Modules.General

import geb.Module

class ListResults extends Module {

    static content = {

        searchResultsBody { $("div.sr-body") }
        searchResultsList { searchResultsBody.find("ul.boxlist") }
        resultPropBoxInList { searchResultsList.find("div.box.propbox") }

        propBoxDetails { resultPropBoxInList.find("div.propbox-details") }
        propTitleInDetails { propBoxDetails.find("h2") }

    }

}
