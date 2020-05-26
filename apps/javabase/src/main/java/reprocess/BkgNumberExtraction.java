package reprocess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class BkgNumberExtraction {

    public static final String END_STRING = "')\" length must be at most 3 CHARACTERs   ({com.tibco.xml.validation}SIMPLE_E_LENGTH_TOO_LONG) at /BookingConfirm[1]/Body[1]/DocumentInformation[1]/ReceivedDocument[1]/DocumentReceipt[1]/ReceivedFromPartyType[1]";
    public static final String START_STRING = "Message Desc:A validation occurred while parsing:  validation error: data \"xs:string('";

    public static Set<String> readBcFiles(String filepath) {
        Set<String> numbers = new HashSet<>();
        File file = new File(filepath);
        if (file.isDirectory()) {
            String[] filelist = file.list();
            for (int i = 0; i < filelist.length; i++) {
                File currentfile = new File(filepath + "\\" + filelist[i]);
                if (!currentfile.isDirectory()) {
                    String msg = getFileString(currentfile);
                    if (msg != null && msg.indexOf("<CarrierBookingNumber>") > 0 && msg.indexOf("</CarrierBookingNumber>") > 0) {
                        String number = msg.substring(msg.indexOf("<CarrierBookingNumber>") + 22, msg.indexOf("</CarrierBookingNumber>"));
                        numbers.add(number);
                    }
                }
            }

        }
        return numbers;
    }


    public static String getFileString(File file) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static Set<String> getBkgNumber(File file) {
        Set<String> numbers = new HashSet<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {
//                result.append(System.lineSeparator() + s);
//                System.out.println(s);
                if(s.contains(START_STRING) && s.contains(END_STRING)){
                    numbers.add(s.substring(START_STRING.length(), s.indexOf(END_STRING)));
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numbers;
    }

    public static void main(String[] args) {
//
//        String s = "Message Desc:A validation occurred while parsing:  validation error: data \"xs:string('7220478060')\" length must be at most 3 CHARACTERs   ({com.tibco.xml.validation}SIMPLE_E_LENGTH_TOO_LONG) at /BookingConfirm[1]/Body[1]/DocumentInformation[1]/ReceivedDocument[1]/DocumentReceipt[1]/ReceivedFromPartyType[1]";
//        System.out.println(s.indexOf(START_STRING));

        Set<String> numbers = getBkgNumber(new File("D:\\BC\\ParkingLot20191105.log"));
        Set<String> numbers1 = getBkgNumber(new File("D:\\BC\\ParkingLot20191104.log"));
        Set<String> total = new HashSet<>();
        total.addAll(numbers);
        total.addAll(numbers1)
;        System.out.println(total);
//        if (msg.indexOf("<CarrierBookingNumber>") > 0 && msg.indexOf("</CarrierBookingNumber>") > 0) {
//            String number = msg.substring(msg.indexOf("<CarrierBookingNumber>") + 22, msg.indexOf("</CarrierBookingNumber>"));
//            numbers.add(number);
//        }

    }
}
