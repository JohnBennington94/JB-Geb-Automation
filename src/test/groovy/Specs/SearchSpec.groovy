package Specs

import Pages.HomePage
import Pages.SearchResultsPage
import Utils.DefaultValues
import spock.lang.Shared
import spock.lang.Unroll

class SearchSpec extends BaseSpec {

    @Shared
    def postCodeBT6 = "BT6"

    def "User can search using 'my location' option - results are accurate"(){
        given: "At the home page"
            def homePage = to HomePage
        when: ""
            homePage.searchContainerModule.clickSearchBarFollowMyLocationLink()
        then: ""
    }

    @Unroll
    def "User can search #postCode in the search bar - results are accurate"(String postCode){
        given: "I am at the home page"
            def homePage = to HomePage
        when: "I input my chosen post code into the search bar and search for properties to rent"
            homePage.searchContainerModule.searchTermAndSelectOption(postCode, DefaultValues.SEARCH_FOR_RENT)
        then: "I am brought to the search results page for properties to rent in post code"
            def searchResults = at SearchResultsPage
            waitFor { searchResults.searchResultsTitle.text() == "PROPERTY TO RENT IN ${postCode}" }
        then: "The results returned are accurate for the searched post code"
            waitFor { searchResults.listResultsModule.resultPropBoxInList.size() == searchResults.DEFAULT_NUMBER_RESULTS_PER_PAGE }
            searchResults.listResultsModule.propTitleInDetails.eachWithIndex { propTitle, index ->
                assert propTitle.text().contains(postCode) : "Property result ${index}: ${propTitle} did not contain ${postCode} text"
            }
        where:
            postCode << [postCodeBT6]

    }

    def "User can search - no results are returned"(){

    }

}
