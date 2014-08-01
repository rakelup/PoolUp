package poolup.penguins.chocolate.com.poolup;

import android.text.format.Time;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by demouser on 7/31/14.
 */

public class Route {
    private static int mIdCounter = 1;

    private int mId;
    private String mDriver;
    private int mAvailableSeats;
    private int mPrice;
    private int mDepatureYear;
    private int mDepatureMonth;
    private int mDepatureDate;
    private int mDepatureHour;
    private int mDepatureMinute;
    private LatLng mStartPoint;
    private LatLng mEndPoint;
    private ArrayList<String> mPassengers;

    public Route(String driver, int availableSeats, int price, int departureYear, int departureMonth,
                 int departureDate, int departureHour, int departureMinute, LatLng startPoint, LatLng endPoint){
        mId = mIdCounter;
        mIdCounter++;
        mDriver = driver;
        mAvailableSeats = availableSeats;
        mPrice = price;
        mDepatureYear = departureYear;
        mDepatureMonth = departureMonth;
        mDepatureDate = departureDate;
        mDepatureHour = departureHour;
        mDepatureMinute = departureMinute;
        mStartPoint = startPoint;
        mEndPoint = endPoint;
        mPassengers = new ArrayList<String>();
    }

    public void addPassenger(String passenger){
        mPassengers.add(passenger);
        // re-calculate the price
        int nbrPassengers = mPassengers.size();
        mPrice = (mPrice/(nbrPassengers-1))*nbrPassengers;
    }

    public void removePassenger(String passenger){
        mPassengers.remove(passenger);
        // re-calculate the price
        int nbrPassengers = mPassengers.size();
        mPrice = (mPrice/(nbrPassengers+1))*nbrPassengers;
    }

    public int getId() {
        return mId;
    }

    public String getDriver() {
        return mDriver;
    }

    public int getAvailableSeats() {
        return mAvailableSeats;
    }

    public int getPrice() {
        return mPrice;
    }

    public int getDepatureYear() {
        return mDepatureYear;
    }

    public int getDepatureMonth() {
        return mDepatureMonth;
    }

    public int getDepatureDate() {
        return mDepatureDate;
    }

    public int getDepatureHour() {
        return mDepatureHour;
    }

    public int getDepatureMinute() {
        return mDepatureMinute;
    }

    public LatLng getStartPoint() {
        return mStartPoint;
    }

    public LatLng getEndPoint() {
        return mEndPoint;
    }

    public ArrayList<String> getPassengers() {
        return mPassengers;
    }
}
