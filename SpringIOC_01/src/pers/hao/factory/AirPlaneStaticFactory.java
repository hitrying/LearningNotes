package pers.hao.factory;

import pers.hao.bean.AirPlane;

public class AirPlaneStaticFactory {

    //AirPlaneStaticFactory.getAirPlane() 静态方法获取
    public static AirPlane getAirplane(String jzName) {
        System.out.println("静态方法正在造飞机中...");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("太行");
        airPlane.setFjsName("hah");
        airPlane.setJzName(jzName);
        airPlane.setPersonNum(300);
        airPlane.setYc("4m");

        return airPlane;
    }
}
