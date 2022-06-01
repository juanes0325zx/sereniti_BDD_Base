package starter.task.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;
import starter.model.pageObjects.saucedemo_page.saucedemo_login;
import starter.model.pageObjects.saucedemo_page.saucedemo_products;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    private  String User;
    private String pass;
    private String url;
    private boolean value;
    private int num;

    public Login(String User, String pass, String url, boolean value){
        this.User =User;
        this.pass =pass;
        this.url=url;
        this.value=value;
    }

    public static LoginWithUser with(){
     return new LoginWithUser();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo (
                WaitUntil.the (saucedemo_login.txt_user_login, isVisible ()).forNoMoreThan (10).seconds (),
                Enter.keyValues (User).into (saucedemo_login.txt_user_login),
                WaitUntil.the (saucedemo_login.txt_user_pass, isVisible ()).forNoMoreThan (10).seconds (),
                Enter.keyValues (pass).into (saucedemo_login.txt_user_pass),
                Click.on (saucedemo_login.btn_login),
                WaitUntil.the ( saucedemo_login.Span_products, isVisible ()).forNoMoreThan (20).seconds ()

        );

    }





public static class LoginWithUser{
    private  String User;
    private String pass;
    private String url;



    public LoginWithUser mailLogin(String User){
        this.User=User;
        return this;
    }

    public LoginWithUser passLogin(String pass){
        this.pass=pass;
        return this;
    }


    public LoginWithUser urlLogin(String url){
        this.url=url;
        return this;
    }
public Performable sendData(boolean value){
        return new Login(User,pass,url,value);
}
}
}
