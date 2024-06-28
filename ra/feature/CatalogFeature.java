package Basic.HN_JV240408_BS_NguyenDucHai.ra.feature;

import Basic.HN_JV240408_BS_NguyenDucHai.ra.model.Catalog;
import Basic.HN_JV240408_BS_NguyenDucHai.ra.model.Product;
import Basic.HN_JV240408_BS_NguyenDucHai.ra.service.CatalogService;
import Basic.HN_JV240408_BS_NguyenDucHai.ra.service.IGenericService;
import Basic.HN_JV240408_BS_NguyenDucHai.ra.service.ProductService;

import java.util.Scanner;

public class CatalogFeature {
    private static IGenericService<Catalog, Integer> catagories = new CatalogService();
    private static IGenericService<Product,String> products = new ProductService();

    //Add new Catalog
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

    //Display all Catalog
    public static void displayAllCatalog() {
        if(catagories.getAll().isEmpty()){
            System.err.println("List catalog is empty");
            return;
        }
        for(Catalog catalog: catagories.getAll()){
            System.out.println(catalog);
        }
    }

    //Update CatalogName By Id
    public static void UpdateNameCatalogById(Scanner sc) {
        if(catagories.getAll().isEmpty()){
            System.err.println("List catalog is empty");
            return;
        }
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
        String newCatalogName = "";
        if(catagories.findById(catalogId) !=null ){
            System.out.println("Enter new catalog name you want to change");
             newCatalogName = sc.nextLine();
            catagories.findById(catalogId).setCatalogName(newCatalogName);
            System.out.println("Update Catalog name success");
        }else {
            System.out.println("Cant found catalog with id: "+catalogId);
        }

    }

    //Delete Catalog By Id
    public static void deleteCatalogById(Scanner sc) {
        if(catagories.getAll().isEmpty()){
            System.err.println("List catalog is empty");
            return;
        }
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
            boolean check = false;
            for (Product product : products.getAll()){
                if(product.getCatalog().getCatalogId() == catalogId){
                    check = true;
                    System.err.println("Cant delete category has products");
                    break;
                }
            }
            if(!check){
                catagories.delete(catalogId);
                System.out.println("Delete success");
            }
        }else{
            System.err.println("Not found catalog with id: "+catalogId);
        }
    }
}
