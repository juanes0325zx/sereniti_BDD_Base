package starter.task.advantageDemo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.model.pageObjects.advantageDemo.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateToLaptopCategory implements Task {

    private boolean value;
    public NavigateToLaptopCategory( boolean value){

        this.value=value;
    }

    public static LoginWithrow_register with(){
     return new LoginWithrow_register();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo (
              WaitUntil.the ( Principal_page.Btn_Menu_Login, isVisible ()).forNoMoreThan (5).seconds (),
                Click.on (Principal_page.Link_img_LaptopCategory)
        );
    }

public static class LoginWithrow_register{

public Performable sendData(boolean value){
        return new NavigateToLaptopCategory(value);
}
}
}
