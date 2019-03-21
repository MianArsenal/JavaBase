package disignpatterns.buillder;

/**
 * Created by MIHE on 3/21/2019.
 * 抽象建造者
 */
public abstract class AbstractBuilder {

  protected Product product = new Product();

  protected abstract void buildPartA();

  protected abstract void buildPartB();

  public final Product getProduct () {
    return this.product;
  }

}
