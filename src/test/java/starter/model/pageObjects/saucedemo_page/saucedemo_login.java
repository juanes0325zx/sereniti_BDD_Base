package starter.model.pageObjects.saucedemo_page;

import org.openqa.selenium.By;

import starter.utils.Xpath_element;
public class saucedemo_login {

    public static By txt_user_login = By.xpath("//input[ @id='user-name']");
    public static By txt_user_pass = By.xpath("//input[ @id='password']");
    public static By btn_login = By.xpath("//input[@class='submit-button btn_action' and @id='login-button']");

    public static By Span_products = By.xpath(Xpath_element.getByTextSpan("Products"));

}
