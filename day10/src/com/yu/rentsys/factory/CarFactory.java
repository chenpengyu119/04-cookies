package com.yu.rentsys.factory;

import com.yu.rentsys.pojo.Bus;
import com.yu.rentsys.pojo.Car;
import com.yu.rentsys.pojo.MotoVehicle;

public class CarFactory {
    public static MotoVehicle newInstance( String no, String brand, String type){
        return new Car(no, brand, type);
    }
}
