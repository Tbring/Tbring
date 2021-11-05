package com.example.lvm.po;

public class InvcentoryLog {
    private int id;
    private String time;
    private String username;
    private String name;
    private String brand;
    private String supplier;
    private String log;
    private int price;
    private String specification;
    private int lognumber;
    private int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public int getLognumber() {
        return lognumber;
    }

    public void setLognumber(int lognumber) {
        this.lognumber = lognumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "InvcentoryLog{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", supplier='" + supplier + '\'' +
                ", log='" + log + '\'' +
                ", price=" + price +
                ", specification='" + specification + '\'' +
                ", lognumber=" + lognumber +
                ", number=" + number +
                '}';
    }
}
