package starter.task.saucedemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.model.pageObjects.saucedemo_page.saucedemo_form;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillFomAndCheout implements Task {

    private final String FirstName;
    private final String LastName;
    private final String code;

    private final boolean value;

    public FillFomAndCheout( String FirstName, String LastName, String code, boolean value){

        this.FirstName =FirstName;
        this.LastName =LastName;
        this.code=code;
        this.value=value;
    }


    public static FillForm with(){
     return new FillForm();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo (
                WaitUntil.the (saucedemo_form.Txt_firstName, isVisible ()).forNoMoreThan (10).seconds (),
                Enter.keyValues (FirstName).into (saucedemo_form.Txt_firstName),
                WaitUntil.the (saucedemo_form.Txt_LastName, isVisible ()).forNoMoreThan (10).seconds (),
                Enter.keyValues (LastName).into (saucedemo_form.Txt_LastName),
                WaitUntil.the (saucedemo_form.Txt_ZipCode, isVisible ()).forNoMoreThan (10).seconds (),
                Enter.keyValues (code).into (saucedemo_form.Txt_ZipCode),
                Click.on (saucedemo_form.Btn_Continue),
                Click.on (saucedemo_form.Btn_finish)
        );

    }






public static class FillForm{
    private  String Product;
    private  String FirstName;
    private  String LastName;
    private  String code;






    public FillForm FirstName(String FirstName){
        this.FirstName=FirstName;
        return this;
    }

    public FillForm LastName(String LastName){
        this.LastName=LastName;
        return this;
    }
    public FillForm code(String code){
        this.code=code;
        return this;
    }


public Performable sendData(boolean value){return new FillFomAndCheout(FirstName,LastName,code,value);}
}
}
