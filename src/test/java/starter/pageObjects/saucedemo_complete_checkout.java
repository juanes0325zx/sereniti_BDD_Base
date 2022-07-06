package starter.pageObjects;

import org.openqa.selenium.By;
import starter.util.Xpath_element;

public class saucedemo_complete_checkout {
    public static By Span_complete = By.xpath(Xpath_element.getByTextSpan("Checkout: Complete!"));

    public static By Title_thaks_for_order = By.xpath(Xpath_element.getByText("THANK YOU FOR YOUR ORDER"));

    public  static  By Info_text  = By.xpath("//div[@class='complete-text']");

    public  static  By btn_backToHome  = By.xpath("//button[@class='btn btn_primary btn_small']");

    public  static  By img_pony  = By.xpath(" //*[@class='pony_express']");


}
