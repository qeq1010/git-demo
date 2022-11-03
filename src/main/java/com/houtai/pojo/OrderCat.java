package com.houtai.pojo;

public class OrderCat {

    private Integer id;
    private String fname;
    private Integer price;
    private Integer num;
    private Integer ido;


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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getIdo() {
        return ido;
    }

    public void setIdo(Integer ido) {
        this.ido = ido;
    }

    @Override
    public String toString() {
        return "OrderCat{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", ido=" + ido +
                '}';
    }
}
