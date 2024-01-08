package Tests.StepDefinitions;

import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStepsDefinitions {

    @Given("^Type the (.*) in the textbox$")
    public void searchCity (String city){
        HomePage.click_type_place(city);
    }
    @And("Select the date (check in and check out).")
    public void selectDate (){
        HomePage.open_calendar();
        HomePage.select_date_ckeckOut();
    }
    @When("Selects the 'Search button'.")
    public void selectSearchButton (){
        HomePage.search_button();
    }
    @Then("The results should shown.")
    public void checkResults (){

    }
}
