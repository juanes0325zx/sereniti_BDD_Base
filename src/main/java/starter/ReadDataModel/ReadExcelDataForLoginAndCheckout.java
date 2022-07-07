package starter.ReadDataModel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import starter.util.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReadExcelDataForLoginAndCheckout {
    String User;
    String pass;
    String FirstName;
    String LastName;
    String code;
    String Title;
    String Item_1;
    String Item_2;
    String ExcelPath_1 = "src/test/resources/features/DataSet/DataLogin.xlsx";

    String ExcelPath_2 = "src/test/resources/features/DataSet/DataLoginAndCheckout.xlsx";
    ExcelReader reader = new ExcelReader();
    List<Map<String,String>> TestData = null;





    public void  Initial(String ExcelPath){
        try {
            this.TestData = reader.getData(ExcelPath,0);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUser(String row) {
        Initial(ExcelPath_1);
        this.User = TestData.get(Integer.parseInt(row)).get("User");
        return this.User;
    }

    public String getPass(String row) {
        Initial(ExcelPath_1);
        this.pass =  TestData.get(Integer.parseInt(row)).get("password");
        return this.pass;
    }

    public String getFirstName(String row) {
        Initial(ExcelPath_2);
        this.FirstName =TestData.get(Integer.parseInt(row)).get("firstname");
        return this.FirstName;
    }

    public String getLastName(String row) {
        Initial(ExcelPath_2);
        this.LastName =TestData.get(Integer.parseInt(row)).get("lastname");
        return this.LastName;
    }

    public String getCode(String row) {
        Initial(ExcelPath_2);
        this.code =TestData.get(Integer.parseInt(row)).get("code");
        return this.code;
    }

    public String getTitle(String row) {
        Initial(ExcelPath_1);
        this.Title =TestData.get(Integer.parseInt(row)).get("Title");
        return this.Title;
    }

    public String getItem_1(String row) {
        Initial(ExcelPath_1);
        this.Item_1 =TestData.get(Integer.parseInt(row)).get("Item_1");
        return this.Item_1;
    }

    public String getItem_2(String row) {
        Initial(ExcelPath_1);
        this.Item_2 =TestData.get(Integer.parseInt(row)).get("Item_2");
        return this.Item_2;
    }




}
