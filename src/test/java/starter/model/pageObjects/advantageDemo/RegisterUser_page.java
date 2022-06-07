package starter.model.pageObjects.advantageDemo;

import org.openqa.selenium.By;

public class RegisterUser_page {

    public static By input_username =By.xpath("//div[@id='form']//input[@name='usernameRegisterPage']");
    public static By input_email =By.xpath("//div[@id='form']//input[@name='emailRegisterPage']");
    public static By input_password =By.xpath("//div[@id='form']//input[@name='passwordRegisterPage']");
    public static By imput_confirm_password =By.xpath("//div[@id='form']//input[@name='confirm_passwordRegisterPage']");
    public static By imput_FirstName =By.xpath("//div[@id='form']//input[@name='first_nameRegisterPage']");
    public static By input_LastaName =By.xpath("//div[@id='form']//input[@name='last_nameRegisterPage']");
    public static By Input_PhoneNumber =By.xpath("//div[@id='form']//input[@name='phone_numberRegisterPage']");
    public static By Input_City =By.xpath("//div[@id='form']//input[@name='cityRegisterPage']");
    public static By Input_Address =By.xpath("//div[@id='form']//input[@name='addressRegisterPage']");
    public static By Input_State =By.xpath("//div[@id='form']//input[@name='state_/_province_/_regionRegisterPage']");
    public static By Input_PostalCode =By.xpath("//div[@id='form']//input[@name='postal_codeRegisterPage']");
    public static By chk_iagreeToConditions =By.xpath("//div[@id='form']//*[@name='i_agree']");
    public static By btn_register =By.xpath("//button[@id='register_btnundefined']");
}
