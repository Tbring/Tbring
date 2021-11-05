package com.example.lvm.po;

public class Borrow {
    private int id;
    private int number;
    private int dataId;
    private String username;
    private String agent;
    private String section;
    private String name;
    private String brand;
    private String borrowdate;
    private String specifications;
    private int returnNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
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

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public int getReturnNumber() {
        return returnNumber;
    }

    public void setReturnNumber(int returnNumber) {
        this.returnNumber = returnNumber;
    }

    public String getBorrowdate() {
        return borrowdate;
    }

    public void setBorrowdate(String borrowdate) {
        this.borrowdate = borrowdate;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", number=" + number +
                ", dataId=" + dataId +
                ", username='" + username + '\'' +
                ", agent='" + agent + '\'' +
                ", section='" + section + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", borrowdate='" + borrowdate + '\'' +
                ", specifications='" + specifications + '\'' +
                ", returnNumber=" + returnNumber +
                '}';
    }
}
