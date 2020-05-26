package demo.covariancedemo

class Super
class Sub extends Super

class Covariance1[A]
class Covariance2[+A]
class Covariance3[-A]


object CovarianceDemo {

  def main(args: Array[String]): Unit = {

    val sub = new Sub
    val super1:Super = sub

    val covariance1 = new Covariance1[Sub];
//    val covariance1_ :Covariance1[Super] = covariance1

    val covariance2 = new Covariance2[Sub]
    val covariance2_ :Covariance2[Super] = covariance2


    val covariance3 = new Covariance3[Super]
    val covariance3_ :Covariance3[Sub] = covariance3

  }

}
