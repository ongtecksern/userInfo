
package com.example.userInfo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postcode;
    private String town;

    // Getters and Setters
    public Town() {
    }

    public Town(Long id, String postcode, String town) {
        this.id = id;
        this.postcode = postcode;
        this.town = town;
    }

    public Long getId() {
        return id;
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

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setTown(String town) {
        this.town = town;
    }    
}
