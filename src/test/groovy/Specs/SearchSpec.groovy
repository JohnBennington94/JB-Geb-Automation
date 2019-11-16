package Specs

import Pages.HomePage

class SearchSpec extends BaseSpec {

    def "User can search using 'my location' option - results are accurate"(){
        given: ""
            def homePage = to HomePage
            homePage.searchContainerModule.clickSearchBarFollowMyLocationLink()
            //thread.sleep(10000)
        when: ""

        then: ""
    }

    def "User can search #postCode in the search bar - results are accurate"(){

    }

    def "User can search - no results are returned"(){

    }

}
