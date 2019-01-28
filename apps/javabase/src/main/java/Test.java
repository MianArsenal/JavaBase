import java.util.Date;

/**
 * Created by MIHE on 1/17/2019.
 */
public class Test {
  public static void main(String[] args) {
    B b = new B();
    b.doo(new Date());
  }
}

abstract class A<E>{
  void doo(Date date){
    E e = (E) date;
    doo2(e);
  }

  abstract void doo2(E e);

}

class B extends A<String> {

  @Override
  void doo2(String date) {

  }
}
