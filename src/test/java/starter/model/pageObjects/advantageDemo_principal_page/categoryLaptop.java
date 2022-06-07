package starter.model.pageObjects.advantageDemo_principal_page;

import org.openqa.selenium.By;

import  starter.util.Xpath_element;

public class categoryLaptop {

    public static By ListItems_3 = By.xpath(Xpath_element.getListByclassRow("cell categoryRight","3"));

    public static By Btn_AddToCarItem3 = By.xpath(Xpath_element.getObjectToListByclassRow("cell categoryRight","3","AddToCard"));


    //este metodo es para hacer dinamigo el path del tagert del objeto de la lista de item que es el mismo para todas las categorias de productos
   public  By dinamickItem(String row){
       return By.xpath(Xpath_element.getListByclassRow("cell categoryRight",row));
   }
}
