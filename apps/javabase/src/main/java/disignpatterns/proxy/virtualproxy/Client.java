package disignpatterns.proxy.virtualproxy;

/**
 * Created by MIHE on 3/22/2019.
 * 场景类
 * 虚拟代理:真实主题类对象在需要的时候才被创建
 */
public class Client {

  public static void main(String[] args) {
    Monitor monitor = new Monitor();
    monitor.collect("zhangsan");
    monitor.collect("lisi");
    monitor.correct();  //这里才创建teacher对象
    monitor.collect("wangwu");
    monitor.collect("zhaoliu");
    monitor.correct();
  }

}
