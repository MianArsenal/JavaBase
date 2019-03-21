package disignpatterns.buillder;

/**
 * Created by MIHE on 3/21/2019.
 * 导演类
 */
public class Director {

  private AbstractBuilder builder;

  public void setBuilder(AbstractBuilder builder) {
    this.builder = builder;
  }

  public Product construct() {
    this.builder.buildPartA();
    this.builder.buildPartB();
    return this.builder.getProduct();
  }

}
