package disignpatterns.builder;

/**
 * Created by MIHE on 3/21/2019.
 * 建造者实现类
 */
public class ConcreteBuilder1 extends AbstractBuilder {
  @Override
  protected void buildPartA() {
    this.product.setPartA("Product A1");
  }

  @Override
  protected void buildPartB() {
    this.product.setPartB("Product B1");
  }
}
