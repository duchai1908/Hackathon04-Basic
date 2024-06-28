package Basic.HN_JV240408_BS_NguyenDucHai.ra.menu;

import Basic.HN_JV240408_BS_NguyenDucHai.ra.feature.CatalogFeature;
import Basic.HN_JV240408_BS_NguyenDucHai.ra.feature.ProductFeature;

import java.util.Scanner;

public class ProductMenu {
    public static void showProductMenu(Scanner sc) {
        while (true) {
            System.out.println("********************PRODUCT-MANAGEMENT********************");
            System.out.println("1. Enter the product number and enter product information");
            System.out.println("2. Display product information");
            System.out.println("3. Sort products by price in descending order");
            System.out.println("4. Delete products by id)");
            System.out.println("5. Search for books by title");
            System.out.println("6. Change book information according to book id");
            System.out.println("7. Back");
            byte choice;
            while (true) {
                try {
                    System.out.println("Enter your choice");
                    choice = Byte.parseByte(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("You must enter a number, please try again");
                }
            }
            switch (choice) {
                case 1:
                    ProductFeature.addNewProduct(sc);
                    break;
                case 2:
                    ProductFeature.displayAllProduct();
                    break;
                case 3:
                    ProductFeature.sortProduct();
                    break;
                case 4:
                    CatalogFeature.deleteCatalogById(sc);
                    break;
                case 5:
                    return;
                default:
                    System.err.println("You must choice option 1 -> 5");
            }
        }
    }
}
