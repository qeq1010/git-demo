package com.houtai.pojo;

public class Inventory {

    private Integer id;
    private String fname;
    private String inventory;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", inventory='" + inventory + '\'' +
                '}';
    }
}
