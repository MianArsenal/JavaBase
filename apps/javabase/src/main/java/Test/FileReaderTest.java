package Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class FileReaderTest {
    public static void main(String[] args) {
        BufferedReader br = null;
        int len = -1;
        char[] c = new char[8192]; //8kb
        long start = System.currentTimeMillis();
        try {
            br = new BufferedReader(new FileReader("D:\\test.txt"));
            while ((len = br.read(c)) != -1) {
                //System.out.print(new String(c,0,len));    //看情况输出
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        long end = System.currentTimeMillis();
        System.out.println("\ntime:" + (end - start));

        br = null;
        len = -1;
        c = new char[8192]; //8kb
        start = System.currentTimeMillis();
        try {
            br = new BufferedReader(new FileReader("D:\\test.txt"));
            while (br.readLine() != null) {
                //System.out.print(new String(c,0,len));    //看情况输出
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        end = System.currentTimeMillis();
        System.out.println("\ntime1.5:" + (end - start));

        //通过FileReader读入数据
        FileReader fr = null;
        len = -1;
        c = new char[512]; //8kb
        start = System.currentTimeMillis();
        try {
            fr = new FileReader("D:\\test.txt");

            while ((len = fr.read(c)) != -1) {
                //System.out.print(new String(c,0,len));    //看情况输出
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fr != null)
                try {
                    fr.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        end = System.currentTimeMillis();
        System.out.println("\ntime2:" + (end - start));

        //通过FileReader读入数据
        FileInputStream fileInputStream = null;
        len = -1;
        byte[] b = new byte[1024]; //8kb
        start = System.currentTimeMillis();
        try {
            fileInputStream = new FileInputStream("D:\\test.txt");

            while ((len = fileInputStream.read(b)) != -1) {
                //System.out.print(new String(c,0,len));    //看情况输出
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fr != null)
                try {
                    fr.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        end = System.currentTimeMillis();
        System.out.println("\ntime2.5:" + (end - start));

    }
}
