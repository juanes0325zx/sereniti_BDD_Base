package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.Actor;

import org.junit.Before;
import starter.navigation.Navigate;
import starter.state.ClearApplication;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.model.pageObjects.saucedemo_page.saucedemo_login;
import starter.model.pageObjects.saucedemo_page.saucedemo_products;
import starter.task.saucedemo.AddProducts;
import starter.task.saucedemo.Login;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Reto_todo1 {

String User;
String pass;
String FirstName;
String LastName;
String code;
String Product;
Actor actor;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("{string} login whit old user {string}")
    public void login_user(String User, String pass) {
       this.User = User;
       this.pass = pass;
        //this.actor = user;
        setTheStage();
        getDriver();
      theActorCalled(this.User).attemptsTo(
                Navigate.saucedemo (),
              WaitUntil.the (saucedemo_login.txt_user_login, isVisible ()).forNoMoreThan (10).seconds (),
              Enter.keyValues (User).into (saucedemo_login.txt_user_login),
              WaitUntil.the (saucedemo_login.txt_user_pass, isVisible ()).forNoMoreThan (10).seconds (),
              Enter.keyValues (pass).into (saucedemo_login.txt_user_pass),
              Click.on (saucedemo_login.btn_login)
          //    ,WaitUntil.the ( saucedemo_login.Span_products, isVisible ()).forNoMoreThan (20).seconds ()
        );


    }

    @When("{string} select product, user {string} {string} region code {string}")
    public void Select_product(String Product, String FirstName, String LastName, String code) {
    this.Product =Product;
        this.FirstName =FirstName;
        this.LastName =LastName;
        this.code =code;
        theActorCalled(this.Product).attemptsTo(
                AddProducts
                        .with()
                        .FirstName(this.FirstName)
                        .LastName(this.LastName)
                        .code(this.code)
                        .sendData(true)


        );

    }

    @Then("pendiente validar")
    public void Pendiente_validar() {
        // Write code here that turns the phrase above into concrete actions
       // throw new cucumber.api.PendingException();
    }


}
