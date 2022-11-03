package com.houtai.pojo;

public class Salary {

    private Integer id;
    private String name;
    private String basePay;
    private String meritPay;
    private String bonus;
    private String totalWages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBasePay() {
        return basePay;
    }

    public void setBasePay(String basePay) {
        this.basePay = basePay;
    }

    public String getMeritPay() {
        return meritPay;
    }

    public void setMeritPay(String meritPay) {
        this.meritPay = meritPay;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getTotalWages() {
        return totalWages;
    }

    public void setTotalWages(String totalWages) {
        this.totalWages = totalWages;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basePay='" + basePay + '\'' +
                ", meritPay='" + meritPay + '\'' +
                ", bonus='" + bonus + '\'' +
                ", totalWages='" + totalWages + '\'' +
                '}';
    }
}
