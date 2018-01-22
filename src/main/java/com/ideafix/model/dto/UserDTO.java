package com.ideafix.model.dto;

public class UserDTO {
    private final String name;
    private final String nickname;
    private final String password;
    private final int age;
    private final String email;
    private final String about;
    private final String picture;
    private final String city;
    private final String country;

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
