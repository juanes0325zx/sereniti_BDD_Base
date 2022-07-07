package starter.ReadDataModel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import starter.util.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReadExcelDataForLogin {
    String User;
    String pass;
    String Title;
    String Item_1;
    String Item_2;
    String ExcelPath = "src/test/resources/features/DataSet/DataLogin.xlsx";
    ExcelReader reader = new ExcelReader();
    List<Map<String,String>> TestData = null;





    public void  Initial(){
        try {
            this.TestData = reader.getData(ExcelPath,0);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUser(String row) {
        Initial();
        this.User = TestData.get(Integer.parseInt(row)).get("User");
        return this.User;
    }

    public String getPass(String row) {
        Initial();
        this.pass =  TestData.get(Integer.parseInt(row)).get("password");
        return this.pass;
    }

    public String getTitle(String row) {
        Initial();
        this.Title =TestData.get(Integer.parseInt(row)).get("Title");
        return this.Title;
    }

    public String getItem_1(String row) {
        Initial();
        this.Item_1 =TestData.get(Integer.parseInt(row)).get("Item_1");
        return this.Item_1;
    }

    public String getItem_2(String row) {
        Initial();
        this.Item_2 =TestData.get(Integer.parseInt(row)).get("Item_2");
        return this.Item_2;
    }



}
