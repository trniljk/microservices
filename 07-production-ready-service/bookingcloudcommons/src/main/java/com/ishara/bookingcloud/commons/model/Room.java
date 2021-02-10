package com.ishara.bookingcloud.commons.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue
    int id;
    String type;
    String bed;
    String bathrooom;
    String view;
    boolean balcony;
    boolean miniBar;
    boolean airCondition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getBathrooom() {
        return bathrooom;
    }

    public void setBathrooom(String bathrooom) {
        this.bathrooom = bathrooom;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public boolean isMiniBar() {
        return miniBar;
    }

    public void setMiniBar(boolean miniBar) {
        this.miniBar = miniBar;
    }

    public boolean isAirCondition() {
        return airCondition;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }
}
