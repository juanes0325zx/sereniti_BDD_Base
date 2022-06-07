package starter.task.advantageDemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.model.pageObjects.advantageDemo.*;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login_register implements Task {

    private  String User;
    private String pass;
    private String url;
    private boolean value;
    private int num;

    public Login_register(String User, String pass, String url, boolean value){
        this.User =User;
        this.pass =pass;
        this.url=url;
        this.value=value;
    }

    public static LoginWithUser_register with(){
     return new LoginWithUser_register();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(value==true){
        actor.attemptsTo (
                WaitUntil.the ( Login.Link_Create_New_User, isClickable()).forNoMoreThan (5).seconds (),
                Enter.keyValues (User).into (Login.input_user_name),
                Enter.keyValues (pass).into (Login.input_password),
                Click.on (Login.BTN_Sing_In)
        );
        } else{
            actor.attemptsTo (
                    WaitUntil.the ( Login.Link_Create_New_User, isVisible ()).forNoMoreThan (5).seconds (),
                    Click.on (Login.Link_Create_New_User)
            );
        }

    }





public static class LoginWithUser_register{
    private  String User;
    private String pass;
    private String url;



    public LoginWithUser_register mailLogin(String User){
        this.User=User;
        return this;
    }

    public LoginWithUser_register passLogin(String pass){
        this.pass=pass;
        return this;
    }


    public LoginWithUser_register urlLogin(String url){
        this.url=url;
        return this;
    }
public Performable sendData(boolean value){
        return new Login_register(User,pass,url,value);
}
}
}
