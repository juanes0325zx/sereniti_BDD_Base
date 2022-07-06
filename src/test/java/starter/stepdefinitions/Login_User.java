package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import org.junit.Before;
import starter.navigation.Navigate;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.pageObjects.saucedemo_login;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.task.saucedemo.Login;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import starter.model.ReadDataForLoginAndCheckout;


public class Login_User {

String User;
String pass;
String FirstName;
String LastName;
String code;

ReadDataForLoginAndCheckout read = new ReadDataForLoginAndCheckout();


    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("login whit  valid user {string} {string}")
    public void login_user(String row,String Actor) {

        this.User = read.getUser(row);
        this.pass =  read.getPass(row);
        setTheStage();
        getDriver();
        Actor actor = theActorCalled(Actor);
        actor.attemptsTo(
                Navigate.saucedemo (),
                Login
                        .with()
                        .mailLogin((this.User))
                        .passLogin(this.pass)
                        .sendData(false)
                ,Ensure.that(saucedemo_login.Span_products).isDisplayed()
        );
    }
     @When("Load data for validate")
    public void loadData(){



     }


     @Then("Validate login with valid user")
    public  void  validateLogin(){


     }
}