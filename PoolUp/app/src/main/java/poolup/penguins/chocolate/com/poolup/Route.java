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
    private Time mDepature;
    private LatLng mStartPoint;
    private LatLng mEndPoint;
    private ArrayList<String> mPassengers;

    public Route(String driver, int availableSeats, int price, Time departure, LatLng startPoint, LatLng endPoint){
        mId = mIdCounter;
        mIdCounter++;
        mDriver = driver;
        mAvailableSeats = availableSeats;
        mPrice = price;
        mDepature = departure;
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

    public Time getDepature() {
        return mDepature;
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
