package com.fluffysoft.bikestats.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.fluffysoft.bikestats.BikeRequest;
import com.fluffysoft.bikestats.BikeStats;
import com.pafers.fitnesshwapi.lib.device.FitnessHwApiDevice;
import com.pafers.fitnesshwapi.lib.device.FitnessHwApiDeviceFeedback;
import com.pafers.fitnesshwapi.lib.device.FitnessHwApiDeviceListener;

public class AndroidLauncher extends AndroidApplication implements FitnessHwApiDeviceListener, BikeRequest {
	public FitnessHwApiDevice device;
    public BikeStats game;
    // TODO: Figure out how to fecth this at runtime rather than hardcoding it.
    private static final String mac="8C:DE:52:73:F4:61";

    @Override
	protected void onCreate (Bundle savedInstanceState) {
        game = new BikeStats(this);
        try {
            device = new FitnessHwApiDevice();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getMessage());
        }
        device.addListener(this);
        device.connect(mac);

		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(game, config);
	}

    public void onDeviceConnected(String var2) {
        System.out.println("BIKE: onDeviceConnected(" + var2 + ")");
    };
    public void onDeviceConnectFailed() {
        System.out.println("BIKE: onDeviceConnectFailed()");
        device.connect(mac);
    };
    public void onDeviceDisconnected(){
        System.out.println("BIKE: onDeviceDisconnected");
    };
    public void onDeviceStarted(){
        System.out.println("BIKE: onDeviceStarted()");
    };
    public void onDeviceResumed(){
        System.out.println("BIKE: onDeviceResumed()");
    };
    public void onDevicePaused(){
        System.out.println("BIKE: onDevicePaused()");
    };
    public void onDeviceStopped(boolean var1){
        System.out.println("BIKE: onDeviceStopped(" + ((var1)?"TRUE":"FALSE") + ")");
    };
    public void onDeviceUpdate(FitnessHwApiDeviceFeedback var1){
        /*
        device.setTargetSpeed(12.3);
        game.calorie = var1.calorie;
        game.distance = var1.distance;
        game.incline = 3;
        game.pulse = device.getPulse();
        game.rpm = var1.rpm;
        game.speed = device.getSpeed();
        game.time = var1.time;
        game.watt = var1.watt;
*/
        System.out.println("BIKE: " + var1.calorie + " " + var1.distance + " " + var1.incline + " " + var1.pulse + " " + var1.rpm + " " + var1.speed + " " + var1.time + " " + var1.watt);
/*
        game.scene.setCalorie();
        game.scene.setDistance();
        game.scene.setIncline();
        game.scene.setPulse();
        game.scene.setRpm();
        game.scene.setSpeed();
        game.scene.setTime();
        game.scene.setWatt();
        */
    };
    public void onDeviceSpeedLimit(double var1, double var3){
        System.out.println("BIKE: onDeviceSpeedLimit(" + var1 + "," + var3 + ")");
    };
    public void onDeviceBrand(String var1){
        game.brand = var1;
        game.scene.setBrand();
        System.out.println("BIKE: onDeviceBrand(" + var1 + ")");
    };
    public void onDeviceManufacturer(String var1){
        game.manufacturer = var1;
        game.scene.setManufacturer();
        System.out.println("BIKE: onDeviceManufacturer(" + var1 + ")");
    };

    /*
    ** Delegate to device... using delegation to allow android to use one BikeListener and
    ** Desktop to use another.
     */

    public void queryManufacturer(){ device.queryManufacturer();};
    public void queryBrand(){ device.queryBrand(); };
    public void connect(String name){ device.connect(name); };
    public void disconnect(){ device.disconnect(); };
    public void reset(){ device.reset(); }
    public void start(){ device.start(); }
    public void pause(){ device.pause(); }
    public void stop(){ device.stop(); }
    public boolean isBike(){ return device.isBike();}
    public boolean isElliptical(){ return device.isElliptical();}
    public boolean isTreadmill(){ return device.isTreadmill(); }
    public boolean isBikeOrElliptical(){ return device.isBikeOrElliptical(); }
    public boolean isRunning(){ return device.isRunning(); }
    public boolean isPaused(){ return device.isPaused(); }
    public boolean isConnected(){ return device.isConnected(); }
    public boolean isMetric(){ return device.isMetric(); }
    public boolean isImperial(){ return device.isImperial(); }
    public void setTargetSpeed(double speed){ device.setTargetSpeed(speed); }
    public void setTargetTimeDistanceAndCalorie(int time, double distance, int calorie){ device.setTargetTimeDistanceAndCalorie(time, distance, calorie);}
    public void setTargetPulse(byte pulse){ device.setTargetPulse(pulse); }
    public void setTargetWatt(int watt){ device.setTargetWatt(watt); }
    public void setIncline(byte incline){ device.setIncline(incline); }
    public void setUserData(byte age, boolean isMale, int weight, int height, boolean isMetric){ device.setUserData(age, isMale, weight, height, isMetric); }
    public void enableStartKey(){ device.enableStartKey(); }
    public double getSpeed(){ return device.getSpeed();}
    public int getPulse() { return device.getPulse(); }
    public byte getIncline(){ return device.getIncline(); }
    public void startQuick(int age, boolean isMale, int height, int weight, boolean isMetric){ device.startQuick(age, isMale, height, weight, isMetric); }
    public void startCustom(int time, double distance, int calorie, int age, boolean isMale, int height, int weight, boolean isMetric){ device.startCustom(time, distance, calorie, age, isMale, height, weight, isMetric); }
    public void startHrc(final double speed, final byte incline, final byte pulse, final int age, final boolean isMale, final int height, final int weight, final boolean isMetric){ device.startHrc(speed, incline, pulse, age, isMale, height, weight, isMetric); }
    public void startWatt(final int watt, final int age, final boolean isMale, final int height, final int weight, final boolean isMetric){ device.startWatt(watt, age, isMale, height, weight, isMetric); }
}
