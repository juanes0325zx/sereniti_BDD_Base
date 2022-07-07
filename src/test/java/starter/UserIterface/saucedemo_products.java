package starter.UserIterface;

import org.openqa.selenium.By;
import starter.util.Xpath_element;

public class saucedemo_products {

    public static By Producto_1 = By.xpath("//*[@class='inventory_item'][1]//button[ @class='btn btn_primary btn_small btn_inventory']");
    public static By Producto_2 = By.xpath("//*[@class='inventory_item'][2]//button[ @class='btn btn_primary btn_small btn_inventory']");

    public static By BTN_buy_card = By.xpath("//*[ @class='shopping_cart_link']");

    public static By Span_products = By.xpath(Xpath_element.getByText("DESCRIPTION"));

    public static By Btn_checkout = By.xpath("//*[ @id='checkout']");

    public static  By MapWithText(String text){
        return   By.xpath(Xpath_element.getByText(text));
    }
}
