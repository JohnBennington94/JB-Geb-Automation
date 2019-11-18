package Pages

import Modules.SearchComponents.ListResults
import Modules.SearchComponents.SearchContainer
import Pages.Base.BasePage

class SearchResultsPage extends BasePage {

    public static final int DEFAULT_NUMBER_RESULTS_PER_PAGE = 10
    public static final String TITLE_TEXT_MY_LOCATION_SEARCH = "NEAR MY LOCATION"

    static at = {
        resultsBodySection.displayed
        searchContainer.displayed
    }

    static content = {

        //Generic results body
        resultsBodySection { $("article#body" ) }

        //Title describing search criteria
        searchResultsTitleContainer { $("div.maxwidth") }
        searchResultsTitle(required: false) { searchResultsTitleContainer.find("h1") }
        noResultsHeading(required: false) { $("h1.noresults-heading") }

        //Search bar container and module
        searchContainer { $("div.search-wrapper") }
        searchContainerModule { searchContainer.module(SearchContainer) }

        //List of Results
        listResultsModule { module(ListResults) }

    }

}
