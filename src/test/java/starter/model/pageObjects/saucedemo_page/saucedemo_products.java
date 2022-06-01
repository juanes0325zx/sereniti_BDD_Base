package starter.model.pageObjects.saucedemo_page;

import org.openqa.selenium.By;
import starter.utils.Xpath_element;

public class saucedemo_products {

    public static By Producto_1 = By.xpath("//*[@class='inventory_item'][1]//button[ @class='btn btn_primary btn_small btn_inventory']");
    public static By Producto_2 = By.xpath("//*[@class='inventory_item'][2]//button[ @class='btn btn_primary btn_small btn_inventory']");

    public static By BTN_buy_card = By.xpath("//*[ @class='shopping_cart_link']");

    public static By Span_products = By.xpath(Xpath_element.getByTextSpan("QTY DESCRIPTION"));

    public static By Btn_Checkout = By.xpath("//*[ @id='checkout']");
    public static By Txt_firstName = By.xpath("//*[ @id='first-name']");
    public static By Txt_LastName = By.xpath("//*[ @id='last-name']");
    public static By Txt_ZipCode = By.xpath("//*[ @id='postal-code']");
    public static By Btn_Continue = By.xpath("//*[ @id='continue']");


}
