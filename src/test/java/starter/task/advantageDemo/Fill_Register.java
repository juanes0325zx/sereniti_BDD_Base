package starter.task.advantageDemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.model.pageObjects.advantageDemo_principal_page.Login;
import starter.model.pageObjects.advantageDemo_principal_page.Principal_page;
import starter.model.pageObjects.advantageDemo_principal_page.RegisterUser_page;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Fill_Register implements Task {

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
    private boolean value;


    public Fill_Register(String User,String pass,String email,
                         String FisrtName,String LastaName,String PhoneNumber,
                         String City,String Address,String State,
                         String PostalCode, boolean value){
        this.User=User;
        this.pass=pass;
        this.email=email;
        this.FisrtName=FisrtName;
        this.LastaName=LastaName;
        this.PhoneNumber=PhoneNumber;
        this.City=City;
        this.Address=Address;
        this.State=State;
        this.PostalCode=PostalCode;
        this.value=value;
    }

    public static LoginWithUser_register with(){
     return new LoginWithUser_register();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(value==true){
        actor.attemptsTo (
                WaitUntil.the ( RegisterUser_page.input_username, isVisible ()).forNoMoreThan (5).seconds (),
                Enter.keyValues (User).into (RegisterUser_page.input_username),
                Enter.keyValues (pass).into (RegisterUser_page.input_password),
                Enter.keyValues (pass).into (RegisterUser_page.imput_confirm_password),
                Enter.keyValues (email).into (RegisterUser_page.input_email),
                Enter.keyValues (FisrtName).into (RegisterUser_page.imput_FirstName),
                Enter.keyValues (LastaName).into (RegisterUser_page.input_LastaName),
                Enter.keyValues (PhoneNumber).into (RegisterUser_page.Input_PhoneNumber),
                Enter.keyValues (City).into (RegisterUser_page.Input_City),
                Enter.keyValues (Address).into (RegisterUser_page.Input_Address),
                Enter.keyValues (State).into (RegisterUser_page.Input_State),
                Enter.keyValues (PostalCode).into (RegisterUser_page.Input_PostalCode),
                Click.on (RegisterUser_page.chk_iagreeToConditions),
                Click.on (RegisterUser_page.btn_register)
        );
        } else{
            actor.attemptsTo (
                    WaitUntil.the ( RegisterUser_page.input_username, isVisible ()).forNoMoreThan (5).seconds (),
                    Click.on (RegisterUser_page.chk_iagreeToConditions),
                    Click.on (RegisterUser_page.btn_register)
            );
        }

    }





public static class LoginWithUser_register{
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

    public LoginWithUser_register emailReg(String email){
        this.email=email;
        return this;
    }
    public LoginWithUser_register LastaNameReg(String LastaName){
        this.LastaName=LastaName;
        return this;
    }
    public LoginWithUser_register PhoneNumberReg(String PhoneNumber){
        this.PhoneNumber=PhoneNumber;
        return this;
    }
    public LoginWithUser_register CityReg(String City){
        this.City=City;
        return this;
    }
    public LoginWithUser_register AddressReg(String Address){
        this.Address=Address;
        return this;
    }
    public LoginWithUser_register StateReg(String State){
        this.State=State;
        return this;
    }
    public LoginWithUser_register PostalCodeReg(String PostalCode){
        this.PostalCode=PostalCode;
        return this;
    }

    public LoginWithUser_register UserReg(String User){
        this.User=User;
        return this;
    }

    public LoginWithUser_register passReg(String pass){
        this.pass=pass;
        return this;
    }


    public LoginWithUser_register FisrtNameReg(String FisrtName){
        this.FisrtName=FisrtName;
        return this;
    }
public Performable sendData(boolean value){
        return new Fill_Register(User,pass,email,FisrtName,LastaName,PhoneNumber,City,Address,State,PostalCode,value);
}
}
}
