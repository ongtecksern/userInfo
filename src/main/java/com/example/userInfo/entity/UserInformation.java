
package com.example.userInfo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class UserInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String icNumber;
    private char gender;
    private LocalDate dateOfBirth;
    private String postcode;
    private String town;

    public UserInformation() {
    }

    public UserInformation(Long id, String icNumber, char gender, LocalDate dateOfBirth, String postcode, String town) {
        this.id = id;
        this.icNumber = icNumber;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.postcode = postcode;
        this.town = town;
    }

    public Long getId() {
        return id;
    }

    public String getIcNumber() {
        return icNumber;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getTown() {
        return town;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIcNumber(String icNumber) {
        this.icNumber = icNumber;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setTown(String town) {
        this.town = town;
    }    
}
