package com.fluffysoft.bikestats.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.fluffysoft.bikestats.BikeStats;
import com.pafers.fitnesshwapi.lib.device.FitnessHwApiDevice;
import com.pafers.fitnesshwapi.lib.device.FitnessHwApiDeviceFeedback;
import com.pafers.fitnesshwapi.lib.device.FitnessHwApiDeviceListener;

public class AndroidLauncher extends AndroidApplication implements FitnessHwApiDeviceListener {
	public FitnessHwApiDevice device;
    public BikeStats game;
    // TODO: Figure out how to fecth this at runtime rather than hardcoding it.
    private static final String mac="8C:DE:52:73:F4:61";

    @Override
	protected void onCreate (Bundle savedInstanceState) {
        game = new BikeStats();
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
        device.setTargetSpeed(12.3);
        game.calorie = var1.calorie;
        game.distance = var1.distance;
        game.incline = 3;
        game.pulse = device.getPulse();
        game.rpm = var1.rpm;
        game.speed = device.getSpeed();
        game.time = var1.time;
        game.watt = var1.watt;

        System.out.println("BIKE: " + game.calorie + " " + game.distance + " " + game.incline + " " + game.pulse + " " + game.rpm + " " + game.speed + " " + game.time + " " + game.watt);
        game.scene.setCalorie();
        game.scene.setDistance();
        game.scene.setIncline();
        game.scene.setPulse();
        game.scene.setRpm();
        game.scene.setSpeed();
        game.scene.setTime();
        game.scene.setWatt();
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
}
