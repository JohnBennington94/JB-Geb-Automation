package Pages

import Modules.SearchComponents.SearchContainer
import Pages.Base.BasePage
import Utils.DefaultValues

class HomePage extends BasePage {

    static url = DefaultValues.BASE_URL

    static at = {
        logoImage.displayed
        homePageBody.displayed
        searchContainer.displayed
    }

    static content = {

        //General content
        logoImage { $("img.search-logo") }
        homePageBody { $("article#body" ) }

        //Search bar container and module
        searchContainer(required: false) { $("form#searchForm") }
        searchContainerModule { searchContainer.module(SearchContainer) }

    }

}
