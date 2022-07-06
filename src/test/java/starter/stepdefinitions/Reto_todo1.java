package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.Actor;

import org.junit.Before;
import starter.navigation.Navigate;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.pageObjects.saucedemo_login;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.task.saucedemo.AddProducts;
import starter.task.saucedemo.Login;
import starter.pageObjects.saucedemo_complete_checkout;
import starter.task.saucedemo.FillFomAndCheout;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;


import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import starter.model.ReadExcelModel;


public class Reto_todo1 {

String User;
String pass;
String FirstName;
String LastName;
String code;

ReadExcelModel read = new ReadExcelModel();


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
       //Actor actor = theActorCalled("Casual user");
       //actor.attemptsTo(
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
               WaitUntil.the ( saucedemo_complete_checkout.img_pony, isVisible ()).forNoMoreThan (20).seconds (),
                Ensure.that(saucedemo_complete_checkout.img_pony).isDisplayed()
               ,Ensure.that(saucedemo_complete_checkout.Info_text).text().isEqualTo("Your order has been dispatched, and will arrive just as fast as the pony can get there!")
               ,Ensure.that(saucedemo_complete_checkout.btn_backToHome).isDisplayed()
               ,Ensure.that(saucedemo_complete_checkout.Title_thaks_for_order).isDisplayed()
               ,Ensure.that(saucedemo_complete_checkout.Title_thaks_for_order).text().isEqualTo("THANK YOU FOR YOUR ORDER")
                );

           /*theActorInTheSpotlight().should(
                seeThat ("prueba de visualizacion credito", Complete_checkout.Span_complete (),equalTo ("$350%7")),
                seeThat ("prueba de visualizacion balance", Complete_checkout.btn_backToHome (),equalTo ("$350%7")),
                seeThat ("prueba de visualizacion credito", Complete_checkout.Info_text (),equalTo ("$350%7"))
                ,seeThat ("prueba de visualizacion opción del menu loans",Complete_checkout.Title_thaks_for_order (),equalTo ("Loans"))
        );*/

    }


}