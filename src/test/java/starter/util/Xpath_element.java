package starter.util;

public class Xpath_element {



        public static String getElementOfTableWithTbody(String tableclass,String tbodyRow,String trRow,String tdRow){
        String tem ="//table[@class='"+tableclass+"']//tbody["+tbodyRow+"]//tr["+trRow+"]//td["+tdRow+"]";
        return tem;
    }
    public static String getListByclassRow(String class_object,String row){
        String tem ="//div[@class='"+class_object+"']//li["+row+"]";
        return tem;
    }
    public static String getObjectToListByclassRow(String class_object,String row, String class_object2){
        String tem ="//div[@class='"+class_object+"']//li["+row+"]//div[@class='"+class_object2+"']";
        return tem;
    }


    public static String getByTextSpan(String span){
        String tem ="//span[contains(text(),'"+span+"')]";
        return tem;
    }

    public static String getByText(String span){
        String tem ="//*[contains(text(),'"+span+"')]";
        return tem;
    }

    public static String getByText_div_Class_Span(String class_object,String span){
        String tem ="//div[@class='"+class_object+"']//span[contains(text(),'"+span+"')]";
        return tem;
    }
    public static String getByText_li_Class_Span(String class_object,String span){
        String tem ="//li[@class='"+class_object+"']//span[contains(text(),'"+span+"')]";
        return tem;
    }
    public static String getByClassInputPlaceHolder(String class_object,String span){
        String tem ="//div[@class='"+class_object+"']//input[@placeholder='"+span+"']')]";
        return tem;
    }


}
