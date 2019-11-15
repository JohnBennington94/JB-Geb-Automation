package Pages

import Modules.General.SearchContainer
import Utils.DefaultValues

class HomePage extends BasePage {

    static url = DefaultValues.BASE_URL

    static at = {

        logoImage.displayed

    }

    static content = {

        //General Content
        logoImage { $("img.search-logo") }

        //Search Bar Container and Module
        searchContainer { $("form#searchForm") }
        searchContainerModule { searchContainer.module(SearchContainer) }

    }



}
