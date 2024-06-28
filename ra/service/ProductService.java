package Basic.HN_JV240408_BS_NguyenDucHai.ra.service;

import Basic.HN_JV240408_BS_NguyenDucHai.ra.model.Catalog;
import Basic.HN_JV240408_BS_NguyenDucHai.ra.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IGenericService<Product,String> {
    private static ArrayList<Product> products = new ArrayList<>();
    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        if(findById(product.getProductId()) == null){
            products.add(product);
        }else{
            products.set(findIndexById(product.getProductId()),product);
        }
    }

    @Override
    public Product findById(String s) {
        for(Product product: products){
            if(product.getProductId().equals(s)){
                return product;
            }
        }
        return null;
    }

    @Override
    public void delete(String s) {
        if(findById(s) != null){
            products.remove(findById(s));
        }else{
            System.err.println("Not found product with id: "+s);
        }
    }
    public int findIndexById(String id){
        for(int i = 0; i < products.size(); i++){
            if(products.get(i).getProductId().equals(id)){
                return i;
            }
        }
        return -1;
    }
}
