package starter.model.authentication;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import starter.domain.SwagUser;

import static starter.model.authentication.LoginForm.*;

public class Login {

    public static Performable withCredentials(String username, String password) {
        return Task.where("{0} logins in with username " + username,
                Open.url("https://www.saucedemo.com/"),
                Enter.theValue(username).into(USERNAME_FIELD),
                Enter.theValue(password).into(PASSWORD_FIELD),
                Click.on(LOGIN_BUTTON)
        );
    }

    public static Performable as(SwagUser swagUser) {
        return Task.where("{0} logins in as " + swagUser,
                withCredentials(swagUser.username, swagUser.password)
        );
    }
}
