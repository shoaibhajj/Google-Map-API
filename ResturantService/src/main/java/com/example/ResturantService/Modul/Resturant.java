package com.example.ResturantService.Modul;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Resturant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String city;
    private String rest1;
    private String rest2;
    private String rest3;

    public Resturant() {
    }

    public Resturant(String city, String rest1, String rest2, String rest3) {
        this.city = city;
        this.rest1 = rest1;
        this.rest2 = rest2;
        this.rest3 = rest3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRest1() {
        return rest1;
    }

    public void setRest1(String rest1) {
        this.rest1 = rest1;
    }

    public String getRest2() {
        return rest2;
    }

    public void setRest2(String rest2) {
        this.rest2 = rest2;
    }

    public String getRest3() {
        return rest3;
    }

    public void setRest3(String rest3) {
        this.rest3 = rest3;
    }
}
