package com.kshrd.models.DTO;

import java.io.Serializable;

public class Product implements Serializable {
    int id=1;
    String name;
    Double unitPrice;
    int qty;
    String ImportDate;
    public Product(int id, String name, Double unitPrice, int qty, String ImprotDate){
        this.id =id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.ImportDate = ImprotDate;
    }
    public Product(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getImportDate() {
        return ImportDate;
    }

    public void setImportDate(String importDate) {
        ImportDate = importDate;
    }


}
