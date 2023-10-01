package com.example.myapplication.entity;

public class User {
    private String name;
    private String gender;
    private String atribute;
    private int legs;
    private int photo;

    public User(String name, String gender,  int photo) {
        this.name = name;
        this.gender = gender;

        this.photo = photo;
    }
    public String getName(){
        return this.name;
    }
    public String getGender(){
        return this.gender;
    }
    public int getPhoto(){
        return this.photo;
    }
}
