package Basic.HN_JV240408_BS_NguyenDucHai.ra.feature;

import Basic.HN_JV240408_BS_NguyenDucHai.ra.model.Product;
import Basic.HN_JV240408_BS_NguyenDucHai.ra.service.IGenericService;
import Basic.HN_JV240408_BS_NguyenDucHai.ra.service.ProductService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductFeature {
    private static IGenericService<Product,String> product = new ProductService();
    public static void addNewProduct(Scanner sc){
        int number;
        while (true) {
            try {
                System.out.println("Enter the number product you want to add ");
                number = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("You must enter a number, please try again");
            }
        }
        for(int i = 0; i<number;i++){
            Product newProduct = new Product();
            System.out.println("Add Product "+(i+1));
            newProduct.inputData(sc);
            product.save(newProduct);
        }
        System.out.println("Add "+ number + " product success");

    }

    public static void displayAllProduct() {
        int count = 0;
        for(Product product: product.getAll()){
            System.out.println(product);
            count++;
        }
        System.out.println("Shop has "+ count + " products");
    }

    public static void sortProduct() {
        List<Product> sortedList = product.getAll().stream()
                .sorted(Comparator.comparingDouble(Product::getProductPrice).reversed())
                .toList();
        for (Product product: sortedList){
            System.out.println(product);
        }
        System.out.println("Sort success");
    }
    
}
