package com.example.bean;

/**
 * @author uncle_yumo
 * @fileName UserJava
 * @createDate 2024/10/23 October
 * @school 无锡学院
 * @studentID 22344131
 * @description This is the UserJava class for the example project.
 */

public class UserJava {
    private Integer id;
    private String username;
    private String gender;
    private Integer age;
    private Boolean member;

    public UserJava(){}

    public UserJava(
            Integer id,
            String username,
            String gender,
            Integer age,
            Boolean member
    ) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.age = age;
        this.member = member;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getMember() {
        return member;
    }

    public void setMember(Boolean member) {
        this.member = member;
    }
}
