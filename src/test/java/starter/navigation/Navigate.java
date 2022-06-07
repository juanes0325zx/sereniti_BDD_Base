package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ui.PageElement;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.model.pageObjects.advantageDemo_principal_page.Principal_page;
import starter.model.pageObjects.saucedemo_page.saucedemo_complete_checkout;
import starter.model.pageObjects.saucedemo_page.saucedemo_login;
import starter.model.pageObjects.saucedemo_page.saucedemo_form;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Navigate {
    public static Performable toTheCatalogPage() {
        return Task.where("{0} goes to the catalog page",
                Open.url("https://www.saucedemo.com/inventory.html"));
    }

    public static Performable saucedemo() {
        return Task.where("{0} goes to the catalog page",
                Open.url("https://www.saucedemo.com/"));
    }


    public static Performable advantageonDemo() {
        return Task.where("{0} goes to the principal page and open menu login",
                Open.url("https://www.advantageonlineshopping.com/#/")
                ,WaitUntil.the ( Principal_page.Btn_Menu_Login, isVisible ()).forNoMoreThan (5).seconds (),
                Click.on(Principal_page.Btn_Menu_Login)
        );


    }


    public static Performable toTheShoppingCart() {
        return Task.where("{0} opens the shopping cart",
                WaitUntil.the ( saucedemo_login.Span_products, isVisible ()).forNoMoreThan (20).seconds ()
        );
    }

    public static Performable toFrom() {
        return Task.where("{0} opens the form",
                WaitUntil.the ( saucedemo_form.Txt_firstName, isVisible ()).forNoMoreThan (20).seconds ()

        );

    }
    public static Performable img_pony() {
        return Task.where("{0} opens the finish checkout",
                WaitUntil.the ( saucedemo_complete_checkout.img_pony, isVisible ()).forNoMoreThan (20).seconds ()

        );}

}
