package Basic.HN_JV240408_BS_NguyenDucHai.ra.service;

import Basic.HN_JV240408_BS_NguyenDucHai.ra.model.Catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogService implements IGenericService<Catalog,Integer>{
    private static ArrayList<Catalog> catalogs = new ArrayList<>();
    @Override
    public List<Catalog> getAll() {
        return catalogs;
    }

    @Override
    public void save(Catalog catalog) {
        if(findById(catalog.getCatalogId()) == null){
            catalogs.add(catalog);
        }else{
            catalogs.set(findIndexById(catalog.getCatalogId()),catalog);
        }

    }

    @Override
    public Catalog findById(Integer integer) {
        for(Catalog catalog: catalogs){
            if(catalog.getCatalogId() == integer){
                return catalog;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer integer) {
        if(findById(integer) == null){
            System.err.println("Cant found catalog with Id: " + integer);
        }else{
            catalogs.remove(findById(integer));
        }
    }
    public int findIndexById(Integer id){
        for(int i = 0; i < catalogs.size();i++){
            if(catalogs.get(i).getCatalogId() == id){
                return i;
            }
        }
        return -1;
    }
}
