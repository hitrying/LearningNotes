package pers.hao.factory;

import pers.hao.bean.AirPlane;

public class AirPlaneInstanceFactory {

    //new AirPlaneInstanceFactory().getAirPlane()
    public AirPlane getAirplane(String jzName) {
        System.out.println("实例方法正在造飞机...");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("太行");
        airPlane.setFjsName("hah");
        airPlane.setJzName(jzName);
        airPlane.setPersonNum(300);
        airPlane.setYc("4m");

        return airPlane;
    }
}
