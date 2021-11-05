package com.example.lvm.po;

public class RecipientstoReturn {
    private int id;
    private String username;
    private int receiveId;
    private String retrundate;
    private int returnNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(int receiveId) {
        this.receiveId = receiveId;
    }

    public String getRetrundate() {
        return retrundate;
    }

    public void setRetrundate(String retrundate) {
        this.retrundate = retrundate;
    }

    public int getReturnNumber() {
        return returnNumber;
    }

    public void setReturnNumber(int returnNumber) {
        this.returnNumber = returnNumber;
    }

    @Override
    public String toString() {
        return "RecipientstoReturn{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", receiveId=" + receiveId +
                ", retrundate='" + retrundate + '\'' +
                ", returnNumber=" + returnNumber +
                '}';
    }
}
