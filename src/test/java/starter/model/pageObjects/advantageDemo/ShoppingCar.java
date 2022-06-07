package starter.model.pageObjects.advantageDemo;
import org.openqa.selenium.By;
import starter.util.Xpath_element;

public class ShoppingCar {
    public static By CardItemName = By.xpath(Xpath_element.getElementOfTableWithTbody("fixedTableEdgeCompatibility","1","1","2"));

    public static By Btn_checkout = By.xpath("//*[@id='checkOutButton']");


    public static  By dinamicItemOfTable(String trRow,String tdRow){
        return By.xpath(Xpath_element.getElementOfTableWithTbody("fixedTableEdgeCompatibility","1",trRow,tdRow));
    }
}
