package com.regression.main;

import com.regression.modules.IPrepare;
import com.regression.modules.IValidate;
import com.regression.vo.IShipmentDataVo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegressionMain {

    private static final Map<String, String> prepareBeansMap = new HashMap<>();
    static {
        prepareBeansMap.put("bc", "bookingConfirmPrepare");
    }

    private static final Map<String, String> validationBeansMap = new HashMap<>();
    static {
        validationBeansMap.put("bc", "bookingConfirmValidate");
    }

    public static void main(String[] args) {
        System.out.println("--------Hello Regression Test--------");
        System.out.println("Please input the ENV that you are going to do regression test(local/qa1/uat/pp):");
        Scanner scanner = new Scanner(System.in);
        ApplicationContext context = buildApplicationContext(scanner.next(), scanner);
        while (true) {
            try {
                String moduleName = getRegressionModuleName(scanner);
                IShipmentDataVo shipmentDataVo = prepareData(context, moduleName);
                boolean validateResult = validateResult((IValidate) context.getBean(validationBeansMap.get(moduleName)), shipmentDataVo, scanner);
                System.out.println("The regression test of " + moduleName + " module has been done! The result is " + validateResult + " !");
            } catch (Throwable e) {
                System.out.println(e.getMessage());
                System.out.println("occur exception during preparing data and validating result!");
            }
        }
    }

    private static IShipmentDataVo prepareData(ApplicationContext context, String moduleName) {
        System.out.println("Start to prepare data!");
        IPrepare<? extends IShipmentDataVo> prepare = (IPrepare<? extends IShipmentDataVo>) context.getBean(prepareBeansMap.get(moduleName));
        IShipmentDataVo shipmentDataVo = prepare.prepare();
        System.out.println("Data has been prepared!");
        System.out.println("The Shipment Vo is: " + shipmentDataVo);
        return shipmentDataVo;
    }

    private static boolean validateResult(IValidate validate, IShipmentDataVo shipmentDataVo, Scanner scanner) {
        System.out.println("Start to validate it!");
        boolean validateResult = validate.validate(shipmentDataVo);
        System.out.println("The regression test of this module " + (validateResult ? "passed!" : "failed!"));
        System.out.println("Do you want to re-validate?(Y/N):");
        String reValidate = scanner.next();
        if("Y".equalsIgnoreCase(reValidate)) {
            return validateResult(validate, shipmentDataVo, scanner);
        }
        return validateResult;
    }

    private static String getRegressionModuleName(Scanner scanner) {
        System.out.println("please input the module that you want to have regression test(bc):");
        String moduleName = scanner.next();
        if (prepareBeansMap.containsKey(moduleName) && validationBeansMap.containsKey(moduleName)) {
            return moduleName;
        } else {
            System.out.println("Not exist regression test for this module yet!");
            return getRegressionModuleName(scanner);
        }
    }

    private static ApplicationContext buildApplicationContext(String env, Scanner scanner) {
        try {
            return new ClassPathXmlApplicationContext(new String[]{
                    "resource/config/env/spring-config-properties-" + env + ".xml",
                    "resource/config/spring-config-ems.xml",
                    "resource/config/spring-config-jdbc.xml",
                    "resource/config/spring-config-shipment.xml"
            });
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            System.out.println("Built spring application context failed! Please re-input a right ENV name(local/qa1/uat/pp):");
            return buildApplicationContext(scanner.next(), scanner);
        }
    }

}
