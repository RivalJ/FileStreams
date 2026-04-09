
public static void main(String[] args) {
    RandomProductMaker rpm = new RandomProductMaker();
    Product p = new Product("123456", "TestProduct", "This is a test", 2.95);
    rpm.WriteProductToFile(p);
}