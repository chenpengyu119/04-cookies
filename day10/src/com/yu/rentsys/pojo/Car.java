package com.yu.rentsys.pojo;

/**
 * @author pengyuchen
 */
public class Car extends MotoVehicle{
    /**
     * // 型号
     */
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Car(String no, String brand, String type) {
        super(no, brand);
        this.type = type;
    }

    public Car() {
    }

    @Override
    public int calcRent(int days) {
        if("奥迪".equals(getBrand())) {
            return 300*days;
        }else if("宝马".equals(getBrand())){
            return 500*days;
        }
        return days*200;
    }
}
