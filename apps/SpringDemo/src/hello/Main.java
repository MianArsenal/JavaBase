package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld("Spring");
        helloWorld.sayHello();

        //创建IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        //获取bean
        HelloWorld springHelloWorld = (HelloWorld) context.getBean("helloWorld");
        springHelloWorld.sayHello();
        Hashtable
    }

}
