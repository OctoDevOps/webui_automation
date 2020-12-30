package iae.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theBetaSAMHomePage() {
        return Task.where("{0} opens the Beta.SAM home page",
                Open.browserOn().the(BetaSAMHomePage.class));
    }
}
