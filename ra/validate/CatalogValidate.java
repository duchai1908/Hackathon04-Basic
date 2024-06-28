package Basic.HN_JV240408_BS_NguyenDucHai.ra.validate;

import java.util.Scanner;

public class CatalogValidate {
    public static int inputCatalogId(Scanner sc){
        System.out.println("Enter Catalog Id");
        return Integer.parseInt(sc.nextLine());
    }

    public static String inputCatalogName(Scanner sc) {
        while (true){
            System.out.println("Enter Catalog Name");
            String catalogName = sc.nextLine();
            if(catalogName.trim().isEmpty()){
                System.err.println("Product name cannot be null");
            }
            else{
                return catalogName;
            }
        }
    }

    public static String inputCatalogDescriptions(Scanner sc) {
        while (true){
            System.out.println("Enter Catalog Descriptions");
            String catalogDescriptions = sc.nextLine();
            if(catalogDescriptions.trim().isEmpty()){
                System.err.println("Product descriptions cannot be null");
            }
            else{
                return catalogDescriptions;
            }
        }
    }
}
