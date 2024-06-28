package Basic.HN_JV240408_BS_NguyenDucHai.ra.run;

import Basic.HN_JV240408_BS_NguyenDucHai.ra.menu.CatalogMenu;
import Basic.HN_JV240408_BS_NguyenDucHai.ra.menu.ProductMenu;

import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("************************BASIC-MENU************************");
            System.out.println("1.Category Management");
            System.out.println("2.Product Management");
            System.out.println("3.Exit");
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
                    CatalogMenu.showCatalogMenu(sc);
                    break;
                case 2:
                    ProductMenu.showProductMenu(sc);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("You must choice option 1 -> 3");

            }
        }

    }
}
