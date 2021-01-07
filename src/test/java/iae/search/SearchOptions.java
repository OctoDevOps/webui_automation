package iae.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.openqa.selenium.Keys;

public class SearchOptions {
    public static Performable about(String optionLabel) {
        return Task.where("{0} selected '" + optionLabel + "' option",
                        SelectFromOptions.byVisibleText(optionLabel).from(SearchForm.SEARCH_FIELD_FILTER)
/*
                Enter.theValue(optionLabel)
                        .into(SearchForm.SEARCH_FIELD_FILTER)
                        .SelectFromOptions.byVisibleText("Paris").from(SELECT_CITY)

                        */
        );
    }
}
