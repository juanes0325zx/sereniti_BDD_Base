package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Before;
import starter.navigation.Navigate;
import starter.state.ClearApplication;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.model.pageObjects.saucedemo_page.saucedemo_login;
import starter.model.questions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.task.saucedemo.AddProducts;
import starter.task.saucedemo.Login;
import starter.model.pageObjects.saucedemo_page.saucedemo_complete_checkout;
import starter.task.saucedemo.FillFomAndCheout;
import starter.util.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.*;


import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Reto_todo1 {

String User;
String pass;
String FirstName;
String LastName;
String code;
String ExcelPath = "C:/bdd-serenity/src/test/resources/features/DataDriven/DataLogin.xlsx";
ExcelReader reader = new ExcelReader();
List<Map<String,String>> TestData = null;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }



    @Given("{string} login whit old user {string}")
    public void login_user(String User, String pass) {
        try {
            TestData = reader.getData(ExcelPath,0);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.User = TestData.get(0).get("User");
        this.pass =  TestData.get(0).get("password");

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
                     .sendData(false),
                WaitUntil.the ( saucedemo_login.Span_products, isVisible ()).forNoMoreThan (20).seconds ()
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

    @When("Fill from with FirstName {string}, LastName {string} and region code {string}")
    public void fill_from_and_checkout( String FirstName, String LastName, String code) {
        try {
            TestData = reader.getData(ExcelPath,0);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.FirstName =TestData.get(0).get("firstname");
        this.LastName =TestData.get(0).get("lastname");
        this.code =TestData.get(0).get("code");
       // Actor actor = theActorCalled("Casual user");
      //  actor.attemptsTo(
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

    @Then("pendiente validar")
    public void Pendiente_validar() {
        /*theActorInTheSpotlight().should(
                seeThat ("prueba de visualizacion credito", Complete_checkout.Span_complete (),equalTo ("$350%7")),
                seeThat ("prueba de visualizacion balance", Complete_checkout.btn_backToHome (),equalTo ("$350%7")),
                seeThat ("prueba de visualizacion credito", Complete_checkout.Info_text (),equalTo ("$350%7"))
                ,seeThat ("prueba de visualizacion opción del menu loans",Complete_checkout.Title_thaks_for_order (),equalTo ("Loans"))
        );*/
        //  Actor actor = theActorCalled("Validate data");
        //  actor.attemptsTo(
       withCurrentActor(
                 // Navigate.img_pony ()
               WaitUntil.the ( saucedemo_complete_checkout.img_pony, isVisible ()).forNoMoreThan (20).seconds (),
                Ensure.that(saucedemo_complete_checkout.img_pony).isDisabled()
                //Ensure.that(saucedemo_complete_checkout.Info_text).text().isEqualTo("Your order has been dispatched, and will arrive just as fast as the pony can get there!")
                //  ,Ensure.that(saucedemo_complete_checkout.btn_backToHome).textValues().contains("Back Home")
                 // ,Ensure.that(saucedemo_complete_checkout.btn_backToHome).text().isEqualTo("Back Home")
                );

    }


}