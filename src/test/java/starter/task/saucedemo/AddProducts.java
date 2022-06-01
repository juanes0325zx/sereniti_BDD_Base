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

    private  String Product;
    private  String FirstName;
    private  String LastName;
    private  String code;

    private int num;

    public AddProducts(String Product){
        this.Product =Product;

    }

    public static AddProductToShopingCar with(){
     return new AddProductToShopingCar();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo (
                WaitUntil.the ( saucedemo_login.Span_products, isVisible ()).forNoMoreThan (20).seconds (),
                Click.on (saucedemo_products.Producto_1),
                Click.on (saucedemo_products.Producto_2),
                WaitUntil.the ( saucedemo_products.BTN_buy_card, isVisible ()).forNoMoreThan (20).seconds (),
                Click.on (saucedemo_products.BTN_buy_card),
                WaitUntil.the ( saucedemo_products.Span_products, isVisible ()).forNoMoreThan (20).seconds (),
                WaitUntil.the (saucedemo_products.Txt_firstName, isVisible ()).forNoMoreThan (10).seconds (),
                Enter.keyValues (FirstName).into (saucedemo_products.Txt_firstName),
                WaitUntil.the (saucedemo_products.Txt_firstName, isVisible ()).forNoMoreThan (10).seconds (),
                Enter.keyValues (LastName).into (saucedemo_products.Txt_firstName),
                WaitUntil.the (saucedemo_products.Txt_firstName, isVisible ()).forNoMoreThan (10).seconds (),
                Enter.keyValues (code).into (saucedemo_products.Txt_firstName),
                Click.on (saucedemo_products.Btn_Continue),
                WaitUntil.the ( saucedemo_products.Span_products, isVisible ()).forNoMoreThan (20).seconds ()
        );

    }





public static class AddProductToShopingCar{
    private  String Product;
    private  String FirstName;
    private  String LastName;
    private  String code;




    public AddProductToShopingCar productToAdd(String Product){
        this.Product=Product;
        return this;
    }

    public AddProductToShopingCar LastName(String LastName){
        this.LastName=LastName;
        return this;
    }
    public AddProductToShopingCar code(String code){
        this.code=code;
        return this;
    }
    public AddProductToShopingCar FirstName(String FirstName){
        this.FirstName=FirstName;
        return this;
    }

public Performable sendData(boolean value){
        return new AddProducts(Product);
}
}
}
