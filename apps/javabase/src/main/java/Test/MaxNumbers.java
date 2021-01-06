package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxNumbers {
    public static void main(String[] args) {
        List<Long> result = new ArrayList<>(100);
        try {
            BufferedReader br = new BufferedReader(new FileReader("file_path"));
            String s;
            while ((s = br.readLine()) != null) {
                Long number = Long.valueOf(s.trim());
                if (result.size() < 100) {
                    result.add(number);
                } else {
                    Collections.sort(result);
                    if (number > result.get(0)) {
                        result.set(0, number);
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result.toString());
    }
}
