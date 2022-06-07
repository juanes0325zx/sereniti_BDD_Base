package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.model.pageObjects.advantageDemo.Principal_page;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Navigate {


    public static Performable advantageonDemo() {
        return Task.where("{0} goes to the principal page and open menu login",
                Open.url("https://www.advantageonlineshopping.com/#/")
                ,WaitUntil.the ( Principal_page.Btn_Menu_Login, isVisible ()).forNoMoreThan (5).seconds (),
                Click.on(Principal_page.Btn_Menu_Login)
        );


    }



}
