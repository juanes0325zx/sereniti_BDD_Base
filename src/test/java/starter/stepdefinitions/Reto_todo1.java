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
import starter.task.saucedemo.FillFomAndCheout;

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
        Actor actor = theActorCalled("Casual user");
        actor.attemptsTo(
                Navigate.saucedemo (),
             Login
                     .with()
                     .mailLogin((this.User))
                     .passLogin(this.pass)
                     .sendData(false)
        );


    }

   @And("Add Product to shopin car")
   public void Select_product(){
       Actor actor = theActorCalled("Casual user");
       actor.attemptsTo(
               Navigate.toTheShoppingCart (),
               AddProducts
                       .with()
                       .sendData(true)

       );
   }

    @When("Fill from with FirstName {string}, LastName {string} and region code {string}")
    public void fill_from_and_checkout(String Product, String FirstName, String LastName, String code) {
    this.Product =Product;
        this.FirstName =FirstName;
        this.LastName =LastName;
        this.code =code;
        Actor actor = theActorCalled("Casual user");
        actor.attemptsTo(
                Navigate.toFrom (),
                FillFomAndCheout
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
