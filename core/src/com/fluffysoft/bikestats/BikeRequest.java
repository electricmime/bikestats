package com.fluffysoft.bikestats;

/**
 * Created by rzerby on 6/21/2015.
 */
public interface BikeRequest {
    public void queryManufacturer();
    public void queryBrand();
    public void connect(String name);
    public void disconnect();
    public void reset();
    public void start();
    public void pause();
    public void stop();
    public boolean isBike();
    public boolean isElliptical();
    public boolean isTreadmill();
    public boolean isBikeOrElliptical();
    public boolean isRunning();
    public boolean isPaused();
    public boolean isConnected();
    public boolean isMetric();
    public boolean isImperial();
    public void setTargetSpeed(double speed);
    public void setTargetTimeDistanceAndCalorie(int time, double distance, int calorie);
    public void setTargetPulse(byte pulse);
    public void setTargetWatt(int watt);
    public void setIncline(byte incline);
    public void setUserData(byte age, boolean isMale, int weight, int height, boolean isMetric);
    public void enableStartKey();
    public double getSpeed();
    public int getPulse() ;
    public byte getIncline();
    public void startQuick(int age, boolean isMale, int height, int weight, boolean isMetric) ;
    public void startCustom(int time, double distance, int calorie, int age, boolean isMale, int height, int weight, boolean isMetric);
    public void startHrc(final double speed, final byte incline, final byte pulse, final int age, final boolean isMale, final int height, final int weight, final boolean isMetric) ;
    public void startWatt(final int watt, final int age, final boolean isMale, final int height, final int weight, final boolean isMetric);
}
