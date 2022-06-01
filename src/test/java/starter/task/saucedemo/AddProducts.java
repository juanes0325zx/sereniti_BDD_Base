package starter.task.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.model.pageObjects.saucedemo_page.saucedemo_login;
import starter.model.pageObjects.saucedemo_page.saucedemo_products;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProducts implements Task {



    private boolean value;

    public AddProducts(boolean value){

        this.value=value;
    }


    public static AddProductToShopingCar with(){
     return new AddProductToShopingCar();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo (
                Click.on (saucedemo_products.Producto_1),
                Click.on (saucedemo_products.Producto_2),
                WaitUntil.the ( saucedemo_products.BTN_buy_card, isVisible ()).forNoMoreThan (20).seconds (),
                Click.on (saucedemo_products.BTN_buy_card),
                WaitUntil.the ( saucedemo_products.Span_products, isVisible ()).forNoMoreThan (20).seconds (),
                Click.on (saucedemo_products.Btn_checkout)

        );

    }






public static class AddProductToShopingCar{

public Performable sendData(boolean value){return new AddProducts(value);}
}
}
