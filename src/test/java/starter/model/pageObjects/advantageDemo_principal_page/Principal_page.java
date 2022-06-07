package starter.model.pageObjects.advantageDemo_principal_page;

import org.openqa.selenium.By;

public class Principal_page {
    public static By Btn_Menu_Login = By.xpath("//*[@id='menuUserLink' and @aria-label='UserMenu']");

    public static By Link_img_LaptopCategory = By.xpath("//div[@id='laptopsImg']");
    public static By Btn_Menu_ShopingCar = By.xpath("//*[@id='shoppingCartLink' and @aria-label='ShoppingCart']");

}
