package com.yu.rentsys.pojo;

/**
 * @author pengyuchen
 */
public class MotoVehicle {
    /**
     * 车牌号
     */
    private String no;
    /**
     * //品牌
     */
    private String brand;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public MotoVehicle() {
    }

    public MotoVehicle(String no, String brand) {
        this.no = no;
        this.brand = brand;
    }
    /**
     * 计算租金
     */
    public int calcRent(int days){
        return 0;
    }

}
