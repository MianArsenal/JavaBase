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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2019-05-03");
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        Calendar instance1 = Calendar.getInstance();
        System.out.println((instance1.getTime().getTime() - instance.getTime().getTime())/(1000*60*60*24)*12.5/200000*50000);
        System.out.println(188*3.1);
    }
}
