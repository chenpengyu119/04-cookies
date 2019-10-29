package com.yu.rentsys.biz;

import com.yu.rentsys.factory.BusFactory;
import com.yu.rentsys.factory.CarFactory;
import com.yu.rentsys.pojo.Bus;
import com.yu.rentsys.pojo.Car;
import com.yu.rentsys.pojo.MotoVehicle;

import java.util.Scanner;

/**
 * @author pengyuchen
 */
public class MotoVehicleBiz {
    private Scanner input = new Scanner(System.in);
    public void menu(){

        while (true){
            System.out.println("租车系统：1.租车  2.退出  ");
            int choice = input.nextInt();
            if(choice==1){
                System.out.println("选择车型：1.小轿车  2.大巴车");
                int type = input.nextInt();
                if(type==1){
                    car();
                }else if(type==2){
                    bus();
                }

            }else if(choice==2){
                break;
            }
        }

    }

    private int car(){
        System.out.println("请选择品牌：1.奥迪  2.宝马");
        int brand = input.nextInt();
        System.out.println("请输入租赁天数：");
        int days = input.nextInt();
        System.out.println("选择辆数：");
        int counts = input.nextInt();
        Car car = (Car)CarFactory.newInstance("京B23333",brand==1?"奥迪":"宝马","A8");
        int carRent = car.calcRent(days);
        System.out.println("一共租车"+days+"天，租金："+carRent*counts);
        return carRent*counts;
    }

    private int bus(){
        System.out.println("请输入座位数：");
        int seatCount = input.nextInt();
        System.out.println("请输入租赁天数：");
        int days = input.nextInt();
        System.out.println("选择辆数：");
        int counts = input.nextInt();
        Bus bus = (Bus) BusFactory.newInstance("", "金龙", "", seatCount);
        int busRent = bus.calcRent(days);
        System.out.println("一共租车"+days+"天，租金："+busRent*counts);
        return busRent*counts;

    }
}
