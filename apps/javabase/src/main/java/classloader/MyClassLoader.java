package classloader;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> result = this.getParent().loadClass(name);
        if (null != result) {
            return result;
        }
        byte[] classBytes = getClassFileByName(name);
        if (null == classBytes || classBytes.length == 0) {
            throw new ClassNotFoundException();
        }
        return defineClass(name, classBytes, 0, classBytes.length);
    }

    private byte[] getClassFileByName(String name) throws ClassNotFoundException {
        byte[] result;
        try {
            String parentPath = "C:\\Users\\mihe\\Desktop\\linshi";
            String subPath = name.replaceAll("\\.", "\\\\");
            File file = new File(parentPath + "\\\\" + subPath);
            InputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int ch;
            while ((ch = bufferedInputStream.read()) != -1) {
                byteArrayOutputStream.write(ch);
            }
            result = byteArrayOutputStream.toByteArray();
            bufferedInputStream.close();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
        return result;
    }

    public static void main(String[] args) {
        ClassLoader myClassLoader = new MyClassLoader();
        try {
            Class<?> helloClassLoader = myClassLoader.loadClass("classloader.HelloClassLoader");
            System.out.println(helloClassLoader.getClassLoader());
            System.out.println(helloClassLoader.getPackage().getName());
            Object instance = helloClassLoader.newInstance();
            System.out.println(instance.toString());
            Method setWord = helloClassLoader.getMethod("setWord", String.class);
            setWord.invoke(instance, "hello");
            System.out.println(instance.toString());
            Method main = helloClassLoader.getMethod("main", String[].class);
            main.invoke(null, (Object)new String[] {});

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
