package disignpatterns.abstractfactory;

/**
 * Created by MIHE on 3/19/2019.
 */
public class ProductTwoFactory extends AbstractFactory {
  @Override
  public ProductA createProductA() {
    return new ProductA2();
  }

  @Override
  public ProductB createProductB() {
    return new ProductB2();
  }
}
