package Pages

import Modules.General.ListResults
import Modules.General.SearchContainer

class SearchResultsPage extends BasePage {

    public static final int DEFAULT_NUMBER_RESULTS_PER_PAGE = 10

    static at = {
        resultsBodySection.displayed
    }

    static content = {

        resultsBodySection { $("article#body" ) }

        searchResultsTitleContainer { $("div.maxwidth") }
        searchResultsTitle { searchResultsTitleContainer.find("h1") }

        noResultsHeading(required: false) { $("h1.noresults-heading") }

        //Search Bar Container and Module
        searchContainer { $("div.search-wrapper") }
        searchContainerModule { searchContainer.module(SearchContainer) }

        //List of Results
        listResultsModule { module(ListResults) }

    }

}
