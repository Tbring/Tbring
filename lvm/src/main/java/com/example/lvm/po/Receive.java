package com.example.lvm.po;

public class Receive {
    private int id;
    private String name;
    private String brand;
    private String specification;
    private String recipientsdate;
    private String returndate;
    private int datareturn;
    private String username;
    private int number;
    private int state;
    private int dataId;


    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getRecipientsdate() {
        return recipientsdate;
    }

    public void setRecipientsdate(String recipientsdate) {
        this.recipientsdate = recipientsdate;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    public int getDatareturn() {
        return datareturn;
    }

    public void setDatareturn(int datareturn) {
        this.datareturn = datareturn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    @Override
    public String toString() {
        return "Receive{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", specification='" + specification + '\'' +
                ", recipientsdate='" + recipientsdate + '\'' +
                ", returndate='" + returndate + '\'' +
                ", datareturn=" + datareturn +
                ", username='" + username + '\'' +
                ", number=" + number +
                ", state=" + state +
                ", dataId=" + dataId +
                '}';
    }
}
