package com.example.lvm.po;

public class Procurement {
    private int id;
    private int state;
    private double price;
    private String purchasedate;
    private String shop;
    private String procurmentUser;
    private String supplier;
    private int purchaseId;


    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPurchasedate() {
        return purchasedate;
    }

    public void setPurchasedate(String purchasedate) {
        this.purchasedate = purchasedate;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getProcurmentUser() {
        return procurmentUser;
    }

    public void setProcurmentUser(String procurmentUser) {
        this.procurmentUser = procurmentUser;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Procurement{" +
                "id=" + id +
                ", state=" + state +
                ", price=" + price +
                ", purchasedate='" + purchasedate + '\'' +
                ", shop='" + shop + '\'' +
                ", procurmentUser='" + procurmentUser + '\'' +
                ", supplier='" + supplier + '\'' +
                ", purchaseId=" + purchaseId +
                '}';
    }
}
