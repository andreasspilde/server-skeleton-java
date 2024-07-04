package com.tietoevry.serverskeletonjava.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonDTO {
    @JsonProperty("name")
    private String name;
    @JsonProperty("socSecNum")
    private String socSecNum;
    @JsonProperty("address")
    private String address;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone")
    private String phone;

    public PersonDTO(){

    }
    public PersonDTO(String name, String socSecNum, String address, String email, String phone){
        this.name = name;
        this.socSecNum = socSecNum;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocSecNum() {
        return socSecNum;
    }

    public void setSocSecNum(String socSecNum) {
        this.socSecNum = socSecNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ValueData{" +
                "name='" + name + '\'' +
                ", socSecNum='" + socSecNum + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
