package starter.util;

public class Xpath_element {

    public static String getByTestAndClass(String Text, String Class){
        String tem="//div[contains(text(), '"+Text+"')]/following-sibling::div[@class='"+Class+"']";
        return tem;
    }
    public static String getByDynamicTableWithClass(String class_element,String cord1,String cord2){
        String tem="";
        if ((cord2!=null)){ tem = "//div[@class='"+class_element+"']//table//tr["+cord1+"]//td["+cord2+"]";
        }else{ tem = "//div[@class='"+class_element+"']//table//tr["+cord1+"]";}
        return tem;
    }
    public static String getByDynamicTableWithId(String id_element,String cord1,String cord2){
        String tem="";
        if ((cord2!=null)){ tem = "//div[@class='"+id_element+"']//table//tr["+cord1+"]//td["+cord2+"]";
        }else{ tem = "//div[@class='"+id_element+"']//table//tr["+cord1+"]";}
        return tem;
    }
    public static String getByTextSpan(String span){
        String tem ="//span[contains(text(),'"+span+"')]";
        return tem;
    }

    public static String getByText(String TEXT){
        String tem ="//*[contains(text(),'"+TEXT+"')]";
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
