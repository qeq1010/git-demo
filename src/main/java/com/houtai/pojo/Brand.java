package com.houtai.pojo;

public class Brand {

    private Integer id;
    private String userName;
    private String fname;
    private String price;
    private Integer status;
    private Integer ids;

    public Integer getIds() {
        return ids;
    }

    public void setIds(Integer ids) {
        this.ids = ids;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    //逻辑视图
    public String getStatusStr() {
        if (status == null) {
            return "未知";
        }
        return status == 0 ? "未发货" : "已发货";
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", fname='" + fname + '\'' +
                ", price='" + price + '\'' +
                ", status=" + status +
                ", ids=" + ids +
                '}';
    }
}
