package com.houtai.pojo;

public class Order {

    private Integer id;
    private String orderId;
    private Integer cartTotalPrice;
    private Integer cartTotalCount;
    private Integer status;
    private Integer ids;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getCartTotalPrice() {
        return cartTotalPrice;
    }

    public void setCartTotalPrice(Integer cartTotalPrice) {
        this.cartTotalPrice = cartTotalPrice;
    }

    public Integer getCartTotalCount() {
        return cartTotalCount;
    }

    public void setCartTotalCount(Integer cartTotalCount) {
        this.cartTotalCount = cartTotalCount;
    }

    public Integer getIds() {
        return ids;
    }

    public void setIds(Integer ids) {
        this.ids = ids;
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
        return "Order{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", cartTotalPrice=" + cartTotalPrice +
                ", cartTotalCount=" + cartTotalCount +
                ", status=" + status +
                ", ids=" + ids +
                '}';
    }
}
