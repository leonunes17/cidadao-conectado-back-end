package com.cidadao_conectado.cidadao.domain.dto;

import java.util.UUID;

public class UserGetDto {
    public UserGetDto(String name, String email, String password, int age, UUID id) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        Id = id;
    }

    private String name;
    private String email;
    private String password;
    private int age;
    
    private UUID Id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }
}
