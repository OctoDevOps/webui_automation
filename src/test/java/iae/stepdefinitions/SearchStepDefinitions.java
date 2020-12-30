package iae.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import iae.navigation.NavigateTo;
import iae.search.LookForInformation;
import iae.search.AwardsResult;

public class SearchStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{actor} is searching for government awards")
    public void researchingThings(Actor actor) {
        actor.wasAbleTo(NavigateTo.theBetaSAMHomePage());
    }

    @When("{actor} looks up {string} keyword")
    public void searchesFor(Actor actor, String term) {
        actor.attemptsTo(
                LookForInformation.about(term)
        );
    }

    @Then("{actor} should see all {string} related awards")
    public void should_see_information_about(Actor actor, String term) {
        actor.attemptsTo(
                Ensure.that(AwardsResult.HEADING)
                .text()
                .containsIgnoringCase(term)
        );
    }
}
