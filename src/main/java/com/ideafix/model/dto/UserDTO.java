package com.ideafix.model.dto;

public class UserDTO {
    private String name;
    private String nickname;
    private String password;
    private int age;
    private String email;
    private String about;
    private String picture;
    private String city;
    private String country;

    public UserDTO(String name, String nickname,
                   String password, int age,
                   String email, String about,
                   String picture, String city, String country) {
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.age = age;
        this.email = email;
        this.about = about;
        this.picture = picture;
        this.city = city;
        this.country = country;
    }

    public UserDTO() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getAbout() {
        return about;
    }

    public String getPicture() {
        return picture;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
