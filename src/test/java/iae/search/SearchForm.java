package iae.search;

import net.serenitybdd.screenplay.targets.Target;

class SearchForm {
    static Target SEARCH_FIELD = Target.the("search field")
                                       .locatedBy("#undefined-container > input");
    
    static Target SEARCH_FIELD_FILTER = Target.the("search field")
                                       .locatedBy("#top-search-filter");
                                       
                                      

}
