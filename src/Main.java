import ProductTools.ProductFileSaver;
import Objects.Product;

public static void main(String[] args) {
    ProductFileSaver rpm = new ProductFileSaver();
    Product p = new Product("123456", "TestProduct", "This is a test", 2.95);
    rpm.WriteProductToFile(p);
}