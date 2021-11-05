package com.example.lvm.po;

public class User {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String sex;
    private int permissions;
    private String avatars;
    private String phone;
    private String ipaddress;
    private String userEmail;
    private String state;
    private String loginTime;
    private String aboutYourself;
    private String describeWork;

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getAboutYourself() {
        return aboutYourself;
    }

    public void setAboutYourself(String aboutYourself) {
        this.aboutYourself = aboutYourself;
    }

    public String getDescribeWork() {
        return describeWork;
    }

    public void setDescribeWork(String describeWork) {
        this.describeWork = describeWork;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getAvatars() {
        return avatars;
    }

    public void setAvatars(String avatars) {
        this.avatars = avatars;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public int getPermissions() {
        return permissions;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", permissions=" + permissions +
                ", avatars='" + avatars + '\'' +
                ", phone='" + phone + '\'' +
                ", ipaddress='" + ipaddress + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", state='" + state + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", aboutYourself='" + aboutYourself + '\'' +
                ", describeWork='" + describeWork + '\'' +
                '}';
    }
}
