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
import starter.UserIterface.saucedemo_products;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidLogin implements Task {

    private String title;
    private String obj_1;
    private String obj_2;
    private boolean value;


    public ValidLogin(String title, String obj_1, String obj_2, boolean value){
        this.title =title;
        this.obj_1 =obj_1;
        this.obj_2=obj_2;
        this.value=value;
    }

    public static ItemForValid with(){
     return new ItemForValid();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo (
                WaitUntil.the ( saucedemo_login.Span_products, isVisible ()).forNoMoreThan (20).seconds ()
                ,Ensure.that(saucedemo_login.Span_products).isDisplayed()
                ,Ensure.that(saucedemo_products.MapWithText(this.title)).isDisplayed()
                ,Ensure.that(saucedemo_products.MapWithText(this.obj_1)).isDisplayed()
                ,Ensure.that(saucedemo_products.MapWithText(this.obj_2)).isDisplayed()
        );

    }





public static class ItemForValid{
    private  String title;
    private String obj_1;
    private String obj_2;



    public ItemForValid titlePage(String title){
        this.title=title;
        return this;
    }

    public ItemForValid item1(String obj_1){
        this.obj_1=obj_1;
        return this;
    }


    public ItemForValid item2(String obj_2){
        this.obj_2=obj_2;
        return this;
    }
public Performable sendData(boolean value){
        return new ValidLogin(title,obj_1,obj_2,value);
}
}
}
