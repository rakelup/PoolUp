package poolup.penguins.chocolate.com.poolup;

import java.util.ArrayList;

/**
 * Created by demouser on 7/31/14.
 */
public class User {
    private String mName;
    private String mPhoneNumber;
    private String mPassword;
    private ArrayList<Integer> mRoutes;

    public User(String name, String phoneNumber, String password){
        mName = name;
        mPhoneNumber = phoneNumber;
        mPassword = password;
    }

    public String getName() {
        return mName;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public String getPassword() {
        return mPassword;
    }

    public void addRoute(int route){
        mRoutes.add(route);
    }

    public ArrayList<Integer> getRoutes(){
        return mRoutes;
    }

}
