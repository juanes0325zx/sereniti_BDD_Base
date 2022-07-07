package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Before;
import starter.ReadDataModel.ReadExcelDataForLoginAndCheckout;
import starter.navigation.Navigate;
import starter.UserIterface.saucedemo_complete_checkout;
import starter.UserIterface.saucedemo_login;
import starter.task.saucedemo.AddProducts;
import starter.task.saucedemo.FillFomAndCheout;
import starter.task.saucedemo.Login;
import starter.task.saucedemo.ValidCheckout;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.withCurrentActor;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class checkoutItems {

String User;
String pass;
String FirstName;
String LastName;
String code;

ReadExcelDataForLoginAndCheckout read = new ReadExcelDataForLoginAndCheckout();


    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }



    @Given("login whit user {string} {string}")
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

   @And("Add Product to shopin car")
   public void Select_product(){
               withCurrentActor(
               Navigate.toTheShoppingCart (),
               AddProducts
                       .with()
                       .sendData(true)
       );
   }

    @When("Fill from with FirstName LastName and region code {string}")
    public void fill_from_and_checkout( String row) {
        this.FirstName =read.getFirstName(row);
        this.LastName =read.getLastName(row);
        this.code =read.getCode(row);

                withCurrentActor(
                Navigate.toFrom (),
                FillFomAndCheout
                        .with()
                        .FirstName(this.FirstName)
                        .LastName(this.LastName)
                        .code(this.code)
                        .sendData(true)
        );
    }

    @Then("Validate complete checkout")
    public void Pendiente_validar() {


       withCurrentActor(
               ValidCheckout
                       .with()
                       .sendData(true)
       );
    }


}