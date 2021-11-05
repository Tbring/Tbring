package com.example.lvm.po;

import java.util.Date;

public class Purchase {
    private int id;
    private String name;
    private int state;
    private String type;
    private String brand;
    private String requisitioner;
    private int number;
    private String specification;
    private String purchasedate;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRequisitioner() {
        return requisitioner;
    }

    public void setRequisitioner(String requisitioner) {
        this.requisitioner = requisitioner;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getPurchasedate() {
        return purchasedate;
    }

    public void setPurchasedate(String purchasedate) {
        this.purchasedate = purchasedate;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", requisitioner='" + requisitioner + '\'' +
                ", number=" + number +
                ", specification='" + specification + '\'' +
                ", purchasedate='" + purchasedate + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}