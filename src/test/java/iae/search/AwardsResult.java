package iae.search;

import net.serenitybdd.screenplay.targets.Target;

public class AwardsResult {

    public static final Target HEADING =  Target.the("article heading").locatedBy("#search-results > div:nth-child(2) > opportunities-result > div > div > div.eight.wide.column > h3 > a");
}