package starter.task.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.UserIterface.saucedemo_complete_checkout;
import starter.UserIterface.saucedemo_login;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidCheckout implements Task {

    private boolean value;

    public ValidCheckout( boolean value){

        this.value=value;
    }

    public static CheckoutUser with(){
     return new CheckoutUser();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo (
                WaitUntil.the ( saucedemo_complete_checkout.img_pony, isVisible ()).forNoMoreThan (20).seconds (),
                Ensure.that(saucedemo_complete_checkout.img_pony).isDisplayed()
                ,Ensure.that(saucedemo_complete_checkout.Info_text).text().isEqualTo("Your order has been dispatched, and will arrive just as fast as the pony can get there!")
                ,Ensure.that(saucedemo_complete_checkout.btn_backToHome).isDisplayed()
                ,Ensure.that(saucedemo_complete_checkout.Title_thaks_for_order).isDisplayed()
                ,Ensure.that(saucedemo_complete_checkout.Title_thaks_for_order).text().isEqualTo("THANK YOU FOR YOUR ORDER")
        );

    }





public static class CheckoutUser{

public Performable sendData(boolean value){
        return new ValidCheckout(value);
}
}
}
