package com.example.lvm.po;

public class Checkincoming {
    private int id;
    private String designatedarea;
    private int inventoryquantity;
    private String expirationdate;
    private String dateofproduction;
    private int procurementId;


    public int getProcurementId() {
        return procurementId;
    }

    public void setProcurementId(int procurementId) {
        this.procurementId = procurementId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignatedarea() {
        return designatedarea;
    }

    public void setDesignatedarea(String designatedarea) {
        this.designatedarea = designatedarea;
    }

    public int getInventoryquantity() {
        return inventoryquantity;
    }

    public void setInventoryquantity(int inventoryquantity) {
        this.inventoryquantity = inventoryquantity;
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    public String getDateofproduction() {
        return dateofproduction;
    }

    public void setDateofproduction(String dateofproduction) {
        this.dateofproduction = dateofproduction;
    }

    @Override
    public String toString() {
        return "Checkincoming{" +
                "id=" + id +
                ", designatedarea='" + designatedarea + '\'' +
                ", inventoryquantity=" + inventoryquantity +
                ", expirationdate='" + expirationdate + '\'' +
                ", dateofproduction='" + dateofproduction + '\'' +
                ", procurementId=" + procurementId +
                '}';
    }
}
