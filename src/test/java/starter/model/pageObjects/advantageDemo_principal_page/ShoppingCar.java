package starter.model.pageObjects.advantageDemo_principal_page;
import org.openqa.selenium.By;
import starter.util.Xpath_element;

public class ShoppingCar {
    public By CardItemName = By.xpath(Xpath_element.getElementOfTableWithTbody("fixedTableEdgeCompatibility","1","1","2"));

    public By Btn_checkout = By.xpath("//*[@id='checkOutButton']");


    public  By dinamicItemOfTable(String trRow,String tdRow){
        return By.xpath(Xpath_element.getElementOfTableWithTbody("fixedTableEdgeCompatibility","row",trRow,tdRow));
    }
}
