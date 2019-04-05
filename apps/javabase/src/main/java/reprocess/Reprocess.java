package reprocess;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Reprocess {

    public static Set<String> readfiles(String filepath) {
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

    public static void main(String[] args) {
        Set<String> numbers = readfiles("F:\\msg");
        String per50Numbers = "";
        int i = 0;
        for (String number:
             numbers) {
            per50Numbers = per50Numbers + ","
        }
    }

}
