package starter.model.pageObjects.advantageDemo_principal_page;

import org.openqa.selenium.By;

public class Login {

    public static By input_user_name = By.xpath("//input[@name='username' and @type='text']");
    public static By input_password = By.xpath("//input[@name='password' and @type='password']");
    public static By Link_Create_New_User = By.xpath("//a[@role='link' and @class='create-new-account ng-scope']");
    public static By BTN_Sing_In =By.xpath("//button[@id='sign_in_btnundefined' and @class='sec-sender-a ng-scope']");
    public static By Label_msg_Error_user =By.xpath("//*[@id='signInResultMessage' and contains(text(),'Incorrect user name or password.')]");

}
