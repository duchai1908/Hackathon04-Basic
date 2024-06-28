package Basic.HN_JV240408_BS_NguyenDucHai.ra.model;

import Basic.HN_JV240408_BS_NguyenDucHai.ra.validate.CatalogValidate;

import java.util.Scanner;

public class Catalog {
    private int catalogId;
    private String catalogName,descriptions;

    public Catalog() {
    }

    public Catalog(int catalogId, String catalogName, String descriptions) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void inputData(Scanner sc){
        this.catalogId = CatalogValidate.inputCatalogId(sc);
        this.catalogName = CatalogValidate.inputCatalogName(sc);
        this.descriptions = CatalogValidate.inputCatalogDescriptions(sc);
    }
    @Override
    public String toString() {
        return "CatalogID: " +this.catalogId + "   |   CatalogName: "+this.catalogName +"\n"
                +"------------------------------------------------------------------";
    }
}
