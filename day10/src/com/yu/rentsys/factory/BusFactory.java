package com.yu.rentsys.factory;

import com.yu.rentsys.pojo.Bus;
import com.yu.rentsys.pojo.Car;
import com.yu.rentsys.pojo.MotoVehicle;

/**
 * @author pengyuchen
 */
public class BusFactory {
    public static MotoVehicle newInstance(String no,String brand,String type,int seatCount){
            return new Bus(no, brand, seatCount);
    }
}
