package Basic.HN_JV240408_BS_NguyenDucHai.ra.feature;

import Basic.HN_JV240408_BS_NguyenDucHai.ra.model.Catalog;
import Basic.HN_JV240408_BS_NguyenDucHai.ra.model.Product;
import Basic.HN_JV240408_BS_NguyenDucHai.ra.service.CatalogService;
import Basic.HN_JV240408_BS_NguyenDucHai.ra.service.IGenericService;

import java.util.Scanner;

public class CatalogFeature {
    private static IGenericService<Catalog, Integer> catagories = new CatalogService();
    public static void addNewCatalog(Scanner sc) {
        int number;
        while (true) {
            try {
                System.out.println("Enter the number categories you want to add ");
                number = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("You must enter a number, please try again");
            }
        }
        for (int i =0; i < number ;i++){
            Catalog newCatalog = new Catalog();
            System.out.println("Add Catalog " + (i+1));
            newCatalog.inputData(sc);
            catagories.save(newCatalog);
        }
        System.out.println("Add "+number +" success");

    }

    public static void displayAllCatalog() {
        for(Catalog catalog: catagories.getAll()){
            System.out.println(catalog);
        }
    }

    public static void UpdateNameCatalogById(Scanner sc) {
        int catalogId;
        while (true){
            try {
                System.out.println("Enter catagory id you want to change name");
                catalogId = Integer.parseInt(sc.nextLine());
                break;
            }catch (NumberFormatException e){
                System.err.println("You must enter a number, please try again");
            }
        }
        System.out.println("Enter new catalog name you want to change");
        String newCatalogName = sc.nextLine();
        if(catagories.findById(catalogId) !=null ){
            catagories.findById(catalogId).setCatalogName(newCatalogName);
        }
        System.out.println("Update Catalog name success");
    }

    public static void deleteCatalogById(Scanner sc) {
        int catalogId;
        while (true){
            try {
                System.out.println("Enter catagory id you want to change name");
                catalogId = Integer.parseInt(sc.nextLine());
                break;
            }catch (NumberFormatException e){
                System.err.println("You must enter a number, please try again");
            }
        }
        if(catagories.findById(catalogId) != null){
//            for (Product product : )
        }else{
            System.err.println("Not found catalog with id: "+catalogId);
        }
    }
}
