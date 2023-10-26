package org.example;

import java.time.LocalDate;

public class User {
    private String name;
    private int age;
    private String address;
    private String hobby;
    private LocalDate birthday;

    public User(String name, int age, String address, String hobby, LocalDate birthday) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.hobby = hobby;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
