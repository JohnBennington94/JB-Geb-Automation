package Specs

import Pages.HomePage
import Pages.SearchResultsPage
import Utils.DefaultValues
import Utils.GeneralUtils
import spock.lang.Shared
import spock.lang.Unroll

class SearchSpec extends BaseSpec {

    @Shared
    def postCodeBT6 = "BT6"

    def "User can search using 'my location' option - results are accurate"(){
        given: "I am at the home page"
            def homePage = to HomePage
        when: "I click on the search bar and select 'My Location' - search for sale properties"
            homePage.searchContainerModule.clickSearchBarFollowMyLocationLink(DefaultValues.SEARCH_FOR_SALE)
        then: "I am brought to the results page - title indicates a 'My Location' search"
            def searchResults = at SearchResultsPage
            waitFor { searchResults.searchResultsTitle.text().contains("PROPERTY FOR SALE ${SearchResultsPage.TITLE_TEXT_MY_LOCATION_SEARCH}") }
            def numberOfResults = searchResults.listResultsModule.resultPropForSaleInList.size()
            waitFor { numberOfResults == searchResults.DEFAULT_NUMBER_RESULTS_PER_PAGE }
        then: "All results returned are within x miles of my location"
            def milesRadius = searchResults.searchContainerModule.searchRadiusSelectedOption[0].value().toFloat()
            def resultTitlesList = (0..numberOfResults-1).collect {
                index -> searchResults.listResultsModule.propForSaleDistance[index].text().toFloat() }
            assert resultTitlesList.findAll{ it >= milesRadius }.empty
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
            def numberOfResults = searchResults.listResultsModule.resultPropToLetInList.size()
            waitFor { numberOfResults == searchResults.DEFAULT_NUMBER_RESULTS_PER_PAGE }
        then: "The results returned are accurate for the searched post code"
            def resultTitlesList = (0..numberOfResults-1).collect {
                index -> searchResults.listResultsModule.propToLetTitleInDetails[index].text() }
            assert resultTitlesList.findAll { !it.contains(postCode) }.empty
        where: "The searched for post code is..."
            postCode << [postCodeBT6]
    }

    @Unroll
    def "User can search the string: #searchNoResults - no results are returned"(String searchNoResults){
        given: "I am at the home page"
            def homePage = to HomePage
        when: "I input a random string which should not match any for sale properties"
            homePage.searchContainerModule.searchTermAndSelectOption(searchNoResults, DefaultValues.SEARCH_FOR_SALE)
        then: "I am brought to the search results page - no results exist"
            def searchResults = at SearchResultsPage
            def numberOfResults = searchResults.listResultsModule.resultPropForSaleInList.size()
            waitFor { searchResults.noResultsHeading.displayed }
            assert numberOfResults == 0 : "Expected 0 results, got: ${numberOfResults}"
        where: "The searched for random string is..."
            searchNoResults << [GeneralUtils.generateRandomString()]
    }
}
