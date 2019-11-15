package Specs

import Pages.HomePage

class SearchSpec extends BaseSpec {

    def "User can search using 'my location' option - results are correct"(){
        given: ""
            def homePage = to HomePage
            homePage.searchContainerModule.clickSearchBarFollowMyLocationLink()
            //thread.sleep(10000)
        when: ""

        then: ""
    }

}
