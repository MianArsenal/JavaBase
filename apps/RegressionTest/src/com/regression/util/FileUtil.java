package com.regression.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.io.InputStream;

public class FileUtil {

    public static String readFileContent(String fileName) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        StringBuilder sb = new StringBuilder();
        InputStream stream = null;
        try {
            Resource[] resources = resolver.getResources(fileName);
            Resource resource = resources[0];
            stream = resource.getInputStream();
            byte[] bytes = new byte[1024];
            for (int n; (n = stream.read(bytes)) != -1; ) {
                sb.append(new String(bytes, 0, n));
            }
            stream.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
