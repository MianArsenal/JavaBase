package disignpatterns.abstractfactory;

/**
 * Created by MIHE on 3/19/2019.
 */
public class ProductOneFactory extends AbstractFactory {
  @Override
  public ProductA createProductA() {
    return new ProductA1();
  }

  @Override
  public ProductB createProductB() {
    return new ProductB1();
  }
}
