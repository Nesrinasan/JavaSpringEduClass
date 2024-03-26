package com.robotdreams.JavaSpringEduClass.RDMarketPlace.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table
@Setter
@Getter
@ToString(exclude = "name")
public class Users extends BaseEntity {

    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private boolean premium;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return premium == users.premium && Objects.equals(name, users.name) && Objects.equals(lastName, users.lastName) && Objects.equals(email, users.email) && Objects.equals(phoneNumber, users.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, email, phoneNumber, premium);
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", premium=" + premium +
                '}';
    }
}
