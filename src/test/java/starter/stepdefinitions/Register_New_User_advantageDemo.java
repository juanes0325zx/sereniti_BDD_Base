package starter.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import net.serenitybdd.screenplay.Actor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Before;
import starter.model.pageObjects.advantageDemo_principal_page.Principal_page;
import starter.navigation.Navigate;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.model.pageObjects.saucedemo_page.saucedemo_login;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.task.saucedemo.AddProducts;
import starter.task.advantageDemo.*;
import starter.model.pageObjects.saucedemo_page.saucedemo_complete_checkout;
import starter.task.saucedemo.FillFomAndCheout;
import starter.util.ExcelReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;



public class Register_New_User_advantageDemo {

    private  String User;
    private String pass;
    private String email;
    private String FisrtName;
    private String LastaName;
    private String PhoneNumber;
    private String City;
    private String Address;
    private String State;
    private String PostalCode;
    String ExcelPath = "src/test/resources/features/DataDriven/DataRegister.xlsx";
    ExcelReader reader = new ExcelReader();
    List<Map<String,String>> TestData = null;
    Random random = new Random();

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }


    @Given("I register whit new user. i user row data {string} Actor {string}")
    public void NavigateToRegister(String row,String Actor) {
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
                        .sendData(false)
        );
    }


    @When("I fill data of new user and register {string}")
    public void RegisterUser(String row){
        try {
            TestData = reader.getData(ExcelPath,0);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.User = TestData.get(Integer.parseInt(row)).get("User");
        this.pass =  TestData.get(Integer.parseInt(row)).get("password");
        this.User = User+Integer.toString(random.nextInt(1 + 100));
        this.email = TestData.get(Integer.parseInt(row)).get("email");
        this.FisrtName = TestData.get(Integer.parseInt(row)).get("FisrtName");
        this.LastaName = TestData.get(Integer.parseInt(row)).get("LastaName");
        this.PhoneNumber = TestData.get(Integer.parseInt(row)).get("PhoneNumber");
        this.City = TestData.get(Integer.parseInt(row)).get("City");
        this.Address = TestData.get(Integer.parseInt(row)).get("Address");
        this.State = TestData.get(Integer.parseInt(row)).get("State");
        this.PostalCode = TestData.get(Integer.parseInt(row)).get("PostalCode");

        withCurrentActor(
                Fill_Register
                        .with()
                        .UserReg(this.User)
                        .passReg(this.pass)
                        .emailReg(this.email)
                        .FisrtNameReg(this.FisrtName)
                        .LastaNameReg(this.LastaName)
                        .PhoneNumberReg(this.PhoneNumber)
                        .CityReg(this.City)
                        .AddressReg(this.Address)
                        .StateReg(this.State)
                        .PostalCodeReg(this.PostalCode)
                        .sendData(true)


        );

    }

    @Then("Validate complete register")
    public void validateRegisater(){

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        withCurrentActor(
        Ensure.that(Principal_page.Btn_Menu_Login).isDisplayed()
        , Ensure.that(Principal_page.Btn_Menu_Login).text().contains(this.User)

);
    }

}
