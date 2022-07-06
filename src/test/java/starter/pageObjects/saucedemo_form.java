package starter.pageObjects;

import org.openqa.selenium.By;

public class saucedemo_form {

    public static By Txt_firstName = By.xpath("//input[ @id='first-name']");
    public static By Txt_LastName = By.xpath("//input[ @id='last-name']");
    public static By Txt_ZipCode = By.xpath("//input[ @id='postal-code']");
    public static By Btn_Continue = By.xpath("//*[ @id='continue']");
    public static By Btn_finish = By.xpath("//*[ @id='finish']");

}
