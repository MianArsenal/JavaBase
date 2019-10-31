package reprocess;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        B b = new B();
//        Map<String, Integer> map1 = new HashMap<>();
//        Map<String, Integer> map2 = new HashMap<>();
//        Map<String, Integer> map3 = new HashMap<>();
//        map2.put("Mian", 100);
//        map3.put("Henry", 99999);
//        map3.put("Henry1", 99998);
//        b.setMap1(map1);
//        b.setMap2(map2);
//        b.setMap3(map3);
//        BeanUtils.describe(b);
        Set<String> strings = new HashSet<>();
        strings.add("MiAn");
        System.out.println(strings);
        strings.clear();
        System.out.println(strings);
        System.out.println(strings.size());
        strings.clear();
        System.out.println(strings.size());
    }
}
