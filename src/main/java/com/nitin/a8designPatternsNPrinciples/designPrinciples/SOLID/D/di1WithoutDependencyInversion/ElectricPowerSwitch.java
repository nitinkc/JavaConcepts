package com.nitin.a8designPatternsNPrinciples.designPrinciples.SOLID.D.di1WithoutDependencyInversion;

public class ElectricPowerSwitch {
    public LightBulb lightBulb;
    public boolean on;


    public ElectricPowerSwitch(LightBulb lightBulb) {
        this.lightBulb = lightBulb;
    }

    public boolean isOn(){
        return this.on;
    }

    public void press(){
        boolean checkOn = isOn();

        if (checkOn){
            lightBulb.turnOff();
            this.on = false;
        }else {
            lightBulb.turnOn();
            this.on = true;
        }
    }
}
