package reprocess;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ParseException {

//        long start = System.currentTimeMillis();
//        int i = 0;
//        while(i <100) {
//            String s = ;
//            String s1 = s.replaceAll("<", "((((((");
//            i++;
//        }
//        long end = System.currentTimeMillis();
//
//        System.out.println("start: " + start);
//        System.out.println("end: " + end);
//        System.out.println(end - start);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = format.parse("2019-05-03");
//        Calendar instance = Calendar.getInstance();
//        instance.setTime(date);
//        Calendar instance1 = Calendar.getInstance();
//        System.out.println((instance1.getTime().getTime() - instance.getTime().getTime())/(1000*60*60*24)*12.5/200000*50000);
//        System.out.println(188*3.1);

//        String config = "[{\"module\":\"BR\", \"needFilter\":true,\"enableScac\":[\"OOLU\",\"COSU\"]},{\"module\":\"BC\", \"needFilter\":false,\"enableScac\":[]},{\"module\":\"BL\", \"needFilter\":false,\"enableScac\":[]},{\"module\":\"SI\", \"needFilter\":false,\"enableScac\":[]},{\"module\":\"IN\", \"needFilter\":true,\"enableScac\":[\"OOLU\",\"COSU\"]},{\"module\":\"CT\", \"needFilter\":true,\"enableScac\":[]}]";
//        String messageType = "BC";
//        String scac = "OOLU";
//        String[] splitArr = config.split("},");
//        boolean isEnable = false;
//        if(splitArr.length > 0){
//            for (String subStr:
//                 splitArr) {
//                if(subStr.contains("\"module\":\"" + messageType + "\"")) {
//                    if(subStr.contains("\"needFilter\":false")) {
//                        isEnable = true;
//                    } else if(subStr.contains("\"needFilter\":true") && subStr.contains(scac)){
//                        isEnable = true;
//                    }
//                }
//            }
//        }
//        System.out.println(isEnable);
        String reg = "<\\|>";
        String string = "BC-OOCL-OOLU-201912120011-BC_OOCL_20191205_720721-TXN000000000000001<|>PKL-Received<|>1576120126365<|>true<|>201912120011<|>NULL<|>BC<|>NULL<|>NULL BC-OOCL-OOLU-201912120012-BC_OOCL_20191205_720721-TXN000000000000002<|>PKL-Received<|>1576120126365<|>true<|>201912120012<|>NULL<|>BC<|>NULL<|>NULL";
        for (String s : string.split(reg)){
            System.out.println(s.trim());
        }
    }
}
