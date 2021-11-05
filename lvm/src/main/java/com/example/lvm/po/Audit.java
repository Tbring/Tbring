package com.example.lvm.po;

public class Audit {
    private int id;
    private String name;
    private int state;
    private String auditname;
    private String submitTime;
    private int dataId;

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

    public String getAuditname() {
        return auditname;
    }

    public void setAuditname(String auditname) {
        this.auditname = auditname;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    @Override
    public String toString() {
        return "Audit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", auditname='" + auditname + '\'' +
                ", submitTime='" + submitTime + '\'' +
                ", dataId=" + dataId +
                '}';
    }
}
