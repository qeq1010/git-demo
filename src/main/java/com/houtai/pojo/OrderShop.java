package com.houtai.pojo;

public class OrderShop {

    private Integer id;
    private String fname;
    private Integer price;



    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

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


    @Override
    public String toString() {
        return "OrderShop{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", price=" + price +
                '}';
    }
}
