package com.example.lvm.po;

public class Data {
    private int id;
    private String name;

    private String specification;

    private String brand;
    private int number;
    private String purchasingTime;
    private String ofproductiondate;
    private String type;
    private String storageTime;
    private String reviewer;
    private double price;
    private String designatedarea;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesignatedarea() {
        return designatedarea;
    }

    public void setDesignatedarea(String designatedarea) {
        this.designatedarea = designatedarea;
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


    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOfproductiondate() {
        return ofproductiondate;
    }

    public void setOfproductiondate(String ofproductiondate) {
        this.ofproductiondate = ofproductiondate;
    }

    public String getPurchasingTime() {
        return purchasingTime;
    }

    public void setPurchasingTime(String purchasingTime) {
        this.purchasingTime = purchasingTime;
    }


    public String getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(String storageTime) {
        this.storageTime = storageTime;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specification='" + specification + '\'' +
                ", brand='" + brand + '\'' +
                ", number=" + number +
                ", purchasingTime='" + purchasingTime + '\'' +
                ", ofproductiondate='" + ofproductiondate + '\'' +
                ", type='" + type + '\'' +
                ", storageTime='" + storageTime + '\'' +
                ", reviewer='" + reviewer + '\'' +
                ", price='" + price + '\'' +
                ", designatedarea='" + designatedarea + '\'' +
                '}';
    }


}
