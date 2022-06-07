package starter.task.advantageDemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.model.pageObjects.advantageDemo.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class AddItemsToshoppingCarAndCheckout implements Task {

    private  String row;
    private boolean value;
    public AddItemsToshoppingCarAndCheckout(String row, boolean value){
        this.row =row;
        this.value=value;
    }

    public static LoginWithrow_register with(){
     return new LoginWithrow_register();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo (
                WaitUntil.the (categoryLaptop.dinamickItem(this.row) , isClickable()).forNoMoreThan (5).seconds (),
                Click.on (categoryLaptop.dinamickItem(this.row)),
                WaitUntil.the (ItemDetail.Btn_AddToCar , isClickable()).forNoMoreThan (5).seconds (),
                Click.on (ItemDetail.Btn_AddToCar),
                WaitUntil.the (Principal_page.Btn_Menu_ShopingCar , isClickable()).forNoMoreThan (5).seconds (),
                Click.on (Principal_page.Btn_Menu_ShopingCar),
                WaitUntil.the (ShoppingCar.Btn_checkout , isVisible ()).forNoMoreThan (5).seconds (),
                Click.on (ShoppingCar.Btn_checkout)
         );
    }

public static class LoginWithrow_register{
    private  String row;
    public LoginWithrow_register row_1(String row){
        this.row=row;
        return this;
    }

public Performable sendData(boolean value){
        return new AddItemsToshoppingCarAndCheckout(row,value);
}
}
}
