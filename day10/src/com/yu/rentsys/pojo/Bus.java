package com.yu.rentsys.pojo;

/**
 * @author pengyuchen
 */
public class Bus extends MotoVehicle {
    private int seatCount;

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public Bus() {
    }

    public Bus(String no, String brand, int seatCount) {
        super(no, brand);
        this.seatCount = seatCount;
    }

    @Override
    public int calcRent(int days) {
        if (days<30){
            return days*800;
        }else{
            return days*1600;
        }
    }
}
