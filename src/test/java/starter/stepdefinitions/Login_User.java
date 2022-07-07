package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Before;
import starter.ReadDataModel.ReadExcelDataForLoginAndCheckout;
import starter.UserIterface.saucedemo_products;
import starter.navigation.Navigate;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import starter.UserIterface.saucedemo_login;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.task.saucedemo.Login;
import starter.task.saucedemo.ValidLogin;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;


import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class Login_User {

String User;
String pass;
String title;
String objet_1;
String objet_2;

    ReadExcelDataForLoginAndCheckout read = new ReadExcelDataForLoginAndCheckout();


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
     @When("Load data for validate {string}")
    public void loadData(String row){
         this.title = read.getTitle(row) ;
         this.objet_1 = read.getItem_1(row);
         this.objet_2= read.getItem_2(row);

     }


     @Then("Validate login with valid user")
    public  void  validateLogin(){
         withCurrentActor(
                 ValidLogin
                         .with()
                         .titlePage(this.title)
                         .item1(this.objet_1)
                         .item2(this.objet_2)
                         .sendData(true)
         );
     }
}