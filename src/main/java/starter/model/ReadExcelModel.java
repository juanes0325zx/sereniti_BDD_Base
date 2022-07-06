package starter.model;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import starter.util.ExcelReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReadExcelModel {
    String User;
    String pass;
    String FirstName;
    String LastName;
    String code;
    String ExcelPath = "src/test/resources/features/DataDriven/DataLogin.xlsx";
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

    public String getFirstName(String row) {
        Initial();
        this.FirstName =TestData.get(Integer.parseInt(row)).get("firstname");
        return this.FirstName;
    }

    public String getLastName(String row) {
        Initial();
        this.LastName =TestData.get(Integer.parseInt(row)).get("lastname");
        return this.LastName;
    }

    public String getCode(String row) {
        Initial();
        this.code =TestData.get(Integer.parseInt(row)).get("code");
        return this.code;
    }



}
