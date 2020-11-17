package rpc.registry;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import rpc.protocol.InvokerProtocol;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RegistryHandler extends ChannelInboundHandlerAdapter {

    //所有可用服务
    public static ConcurrentHashMap<String, Object> registryMap = new ConcurrentHashMap<>();
    //所有服务类
    private List<String> classNames = new ArrayList<>();

    public RegistryHandler() {
        scannerClass("rpc.provider");
        doRegister();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Object result = new Object();
        InvokerProtocol request = (InvokerProtocol) msg;

        if (registryMap.containsKey(request.getClassName())) {
            Object clazz = registryMap.get(request.getClassName());
            Method method = clazz.getClass().getMethod(request.getMethodName(), request.getParams());
            result = method.invoke(clazz, request.getValues());
        }
        ctx.write(result);
        ctx.flush();
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private void scannerClass(String packagePath) {
        URL url = this.getClass().getClassLoader().getResource(packagePath.replaceAll("\\.", "/"));
        File dir = new File(url.getFile());
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                scannerClass(packagePath + "." + file.getName());
            } else {
                classNames.add(packagePath + "." + file.getName().replace(".class", "").trim());
            }
        }
    }

    private void doRegister() {
        if (classNames.size() == 0) {
            return;
        }
        for (String className :
                classNames) {
            try {
                Class<?> clazz = Class.forName(className);
                Class<?> i = clazz.getInterfaces()[0];
                registryMap.put(i.getName(), clazz.newInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
