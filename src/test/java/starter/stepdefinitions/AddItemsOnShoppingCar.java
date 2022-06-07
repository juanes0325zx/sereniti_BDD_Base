package starter.stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Before;
import starter.model.pageObjects.advantageDemo.categoryLaptop;
import starter.model.pageObjects.advantageDemo.checkout;
import starter.navigation.Navigate;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.task.advantageDemo.*;
import starter.util.ExcelReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class AddItemsOnShoppingCar {

    private  String User;
    private String pass;

    private  String producto;

    private  String text;

    String ExcelPath = "src/test/resources/features/DataDriven/DataRegister.xlsx";
    ExcelReader reader = new ExcelReader();
    List<Map<String,String>> TestData = null;
    Random random = new Random();

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }



    @Given("I login with user. i user row data {string} Actor {string}")
    public void IloginWith(String row,String Actor) {
        try {
            TestData = reader.getData(ExcelPath,0);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.User = TestData.get(Integer.parseInt(row)).get("User");
        this.pass =  TestData.get(Integer.parseInt(row)).get("password");
        setTheStage();
        getDriver();

        Actor actor = theActorCalled(Actor);
        actor.attemptsTo(
                Navigate.advantageonDemo ());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        withCurrentActor(
                Login_register
                        .with()
                        .mailLogin((this.User))
                        .passLogin(this.pass)
                        .sendData(true)
        );
    }
    @And("I Navegate To Laptop category")
    public void InavegateToLaptopCategory() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        withCurrentActor(
                NavigateToLaptopCategory
                        .with()
                        .sendData(true)
        );
    }


@When("I select one item of laptop category {string}")
public void IaddProductoToShopoingCar(String row) {

    this.text = (Serenity.getDriver().findElement(categoryLaptop.Txt_Item3).getText()).toUpperCase();
    this.producto = TestData.get(Integer.parseInt(row)).get("producto");
    withCurrentActor(
            AddItemsToshoppingCarAndCheckout
                    .with()
                    .row_1(this.producto)
                    .sendData(true)
    );
}


@Then("I validate Name of item vs checkout")
    public void EnsureNameOfItem(){
    withCurrentActor(
    WaitUntil.the (checkout.txt_NameItem , isVisible ()).forNoMoreThan (5).seconds (),
            Ensure.that(checkout.txt_NameItem).text().isEqualTo(this.text)
    );
}




}
