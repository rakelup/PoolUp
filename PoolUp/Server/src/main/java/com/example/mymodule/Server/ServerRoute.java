package com.example.mymodule.Server;


import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.ArrayList;

import javax.inject.Named;


/**
 * Created by demouser on 8/1/14.
 */
@Entity
public class ServerRoute {

//    public ServerRoute(
//             String driver,
//             int availableSeats,
//             int price,
//             int year,
//             int month,
//             int date,
//             int hour,
//             int minute,
//             double startLatitude,
//             double startLongitude,
//             double endLatitude,
//             double endLongitude) {
//        this.driver = driver;
//        this.availableSeats = availableSeats;
//        this.price = price;
//        this.year = year;
//        this.month = month;
//        this.date = date;
//        this.hour = hour;
//        this.minute = minute;
//        this.startLatitude = startLatitude;
//        this.startLongitude = startLongitude;
//        this.endLatitude = endLatitude;
//        this.endLongitude = endLongitude;
//        passengers = new ArrayList<String>();
//    }


    @Id
    private int id;

    @Index
    private String driver;

    private int availableSeats;

    private int price;

    @Index
    private int year;
    @Index
    private int month;
    @Index
    private int date;
    @Index
    private int hour;
    @Index
    private int minute;

    @Index
    private double startLatitude;
    @Index
    private double startLongitude;
    @Index
    private double endLatitude;
    @Index
    private double endLongitude;

    private ArrayList<String> passengers;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public double getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(double startLatitude) {
        this.startLatitude = startLatitude;
    }

    public double getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(double startLongitude) {
        this.startLongitude = startLongitude;
    }

    public double getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(double endLatitude) {
        this.endLatitude = endLatitude;
    }

    public double getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(double endLongitude) {
        this.endLongitude = endLongitude;
    }

    public ArrayList<String> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<String> passengers) {
        this.passengers = passengers;
    }
}
