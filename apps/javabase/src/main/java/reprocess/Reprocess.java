package reprocess;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Reprocess {

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

  public static Set<String> readBlFiles(String filepath) {
    Set<String> numbers = new HashSet<>();
    File file = new File(filepath);
    if (file.isDirectory()) {
      String[] filelist = file.list();
      for (int i = 0; i < filelist.length; i++) {
        File currentfile = new File(filepath + "\\" + filelist[i]);
        if (!currentfile.isDirectory()) {
          String msg = getFileString(currentfile);
          if (msg != null && msg.indexOf("<BLNumber>") > 0 && msg.indexOf("</BLNumber>") > 0) {
            String number = msg.substring(msg.indexOf("<BLNumber>") + 10, msg.indexOf("</BLNumber>"));
            numbers.add(number);
          }
        }
      }

    }
    return numbers;
  }

  private static Set<String> getExistingNumbers(String filepath) {
    File file = new File(filepath);
    Set<String> result = new HashSet<>();
    if(!file.isDirectory()){
      String msg = getFileString(file);
      String[] existingNumbers = msg.split(",");
      for (String number:
           existingNumbers) {
        result.add(number);
      }
    }
    return result;
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
    String shipmentType = "BOOKING";
    Set<String> numbers2 = readBcFiles("C:\\Users\\mihe\\Desktop\\New folder\\13455_2-1-N");
    Set<String> numbers1 = readBcFiles("C:\\Users\\mihe\\Desktop\\New folder\\13455_1-1-N");
    Set<String> existingNumbers = getExistingNumbers("C:\\Users\\mihe\\Desktop\\New folder\\existing_bc.txt");
    Set<String> existingNumbers01 = getExistingNumbers("C:\\Users\\mihe\\Desktop\\New folder\\existing_bc_01.txt");
//    String shipmentType = "BL";
//    Set<String> numbers2 = readBlFiles("C:\\Users\\mihe\\Desktop\\New folder\\13455_2-2-N");
//    Set<String> numbers1 = readBlFiles("C:\\Users\\mihe\\Desktop\\New folder\\13455_1-2-N");
//    Set<String> existingNumbers = getExistingNumbers("C:\\Users\\mihe\\Desktop\\New folder\\existing_bl.txt");
    System.out.println(existingNumbers.toString());
    System.out.println(existingNumbers.size());
    System.out.println(numbers2.size());
    System.out.println(numbers1.size());
    Set<String> numbers = new HashSet<>();
    numbers.addAll(numbers2);
    numbers.addAll(numbers1);
    System.out.println(numbers.size());

    Set<String> notExistingNumbers = new HashSet<>();
    for (String number:
         numbers) {
      if(!existingNumbers.contains(number)) {
        notExistingNumbers.add(number);
      }

    }
    System.out.println("not existing size: " + notExistingNumbers.size());

    Set<String> notExisting01 = new HashSet<>();
    for (String number:
         notExistingNumbers) {
      if(!existingNumbers01.contains(number)) {
        notExisting01.add(number);
      }
    }
    System.out.println(notExisting01);
    System.out.println("not existing 01 size: " + notExisting01.size());

//    List<String> result = new ArrayList<>();
//    String per50Numbers = "";
//    int i = 0;
//    int l = 0;
//    for (String number : notExistingNumbers) {
//      if ("".equals(per50Numbers)) {
//        per50Numbers = number + ",";
//        i++;
//      } else if (i < 49) {
//        per50Numbers = per50Numbers + number + ",";
//        i++;
//      } else if (i == 49) {
//        per50Numbers = per50Numbers + number;
//        i = 0;
//        result.add(per50Numbers);
//        per50Numbers = "";
//      }
//      if (l == notExistingNumbers.size() - 1 && !"".equals(per50Numbers)) {
//        result.add(per50Numbers.substring(0, per50Numbers.length() - 1));
//      }
//      l++;
//    }
//
//    int j = 0;
//    for (String str :
//        result) {
//      System.out.println("--------------------------" + j + "---------------------------");
//      System.out.println(str);
//      j++;
//    }

//    List<String> result = new ArrayList<>();
//    String per50Numbers = "";
//    int i = 0;
//    int l = 0;
//    for (String number : numbers) {
//      if ("".equals(per50Numbers)) {
//        per50Numbers = number + ",";
//        i++;
//      } else if (i < 49) {
//        per50Numbers = per50Numbers + number + ",";
//        i++;
//      } else if (i == 49) {
//        per50Numbers = per50Numbers + number;
//        i = 0;
//        result.add(per50Numbers);
//        per50Numbers = "";
//      }
//      if (l == numbers.size() - 1 && !"".equals(per50Numbers)) {
//        result.add(per50Numbers.substring(0, per50Numbers.length() - 1));
//      }
//      l++;
//    }

    //    int j = 0;
    //    for (String str :
    //        result) {
    //      System.out.println("--------------------------" + j + "---------------------------");
    //      System.out.println(str);
    //      j++;
    //    }

//    int k = 0;
//    int l = 0;
//    int i = 0;
//    String subSql = "select * from shipment_folder_info sf WHERE sf.shipment_type = '" + shipmentType + "' and sf.shipment_number in (";
//    for (String number :
//        notExistingNumbers) {
//      subSql = subSql + "'" + number + "',";
//      if (k == 999 || l == notExistingNumbers.size() - 1) {
//        System.out.println("--------------------------" + i++ + "---------------------------");
//        subSql = subSql.substring(0, subSql.length() - 1) + ");";
//        System.out.println(subSql);
//        subSql = "select * from shipment_folder_info sf WHERE sf.shipment_type = '" + shipmentType + "' and sf.shipment_number in (";
//        k = 0;
//      }
//      k++;
//      l++;
//    }

  }

}
