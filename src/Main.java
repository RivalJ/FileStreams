import ProductTools.ProductFileSaver;
import Objects.Product;
import ProductTools.ProductNameSearch;

public static void main(String[] args) {
    //RandomProductMaker rpm = new RandomProductMaker();

    List<Product> results = ProductNameSearch.SearchByName("a");
    for(Product p : results){
        System.out.println(p.GetID().Get());
    }
}