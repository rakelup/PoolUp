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
}
