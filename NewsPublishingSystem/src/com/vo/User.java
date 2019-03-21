package com.vo;

public class User {
    private int id;
    private String username;
    private String password;
    private String sex;
    private String profession;
    private String favourite;
    private String note;
    private String type;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }

    public String getProfession() {
        return profession;
    }

    public String getFavourite() {
        return favourite;
    }

    public String getNote() {
        return note;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setType(String type) {
        this.type = type;
    }

}
