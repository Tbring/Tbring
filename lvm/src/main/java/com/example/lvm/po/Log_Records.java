package com.example.lvm.po;

public class Log_Records {
    private int id;
    private int userid;
    private String nickname;
    private String username;
    private String ipAddress;
    private String loginTime;
    private String log;
    private String time;
    private String permissions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "Log_Records{" +
                "id=" + id +
                ", userid=" + userid +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", log='" + log + '\'' +
                ", time='" + time + '\'' +
                ", permissions='" + permissions + '\'' +
                '}';
    }
}
