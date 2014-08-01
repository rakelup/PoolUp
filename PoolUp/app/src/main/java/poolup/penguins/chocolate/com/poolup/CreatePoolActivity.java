package poolup.penguins.chocolate.com.poolup;

import android.app.Activity;
import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.TimePickerDialog;
import android.location.Location;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import org.w3c.dom.Text;

import java.util.Calendar;

import poolup.penguins.chocolate.com.poolup.R;

public class CreatePoolActivity extends Activity {

    public static String convertToHour(int hourOfDay, int minute) {

        String hourString;
        if (hourOfDay < 10)
            hourString = "0" + hourOfDay;
        else
            hourString = "" +hourOfDay;

        String minuteSting;
        if (minute < 10)
            minuteSting = "0" + minute;
        else
            minuteSting = "" +minute;

        return hourString + " : " + minuteSting;
    }

    public static String convertToDate(int year, int month, int day) {
        String monthString;
        if(month < 10) {
            monthString = "0" + month;
        } else {
            monthString = "" + month;
        }

        String dayString;
        if (day < 10) {
            dayString = "0" + day;
        } else {
            dayString = "" + day;
        }

        return monthString + "/" + dayString + "/" + year;

    }


    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            ((TextView) getActivity().findViewById(R.id.create_tv_time)).setText(convertToHour(hourOfDay, minute));

        }
    }


    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
           ((TextView) getActivity().findViewById(R.id.create_tv_date)).setText(convertToDate(year, month, day));
        }
    }

    public void showLoginDialog(View view) {

        LoginDialog loginDialog = new LoginDialog();
        loginDialog.show(this.getFragmentManager(), "fragment_login");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pool);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_pool, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showTimePickerDialog(View v) {
        Log.d("TIME", "shows the time");
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(this.
                getFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View view) {
        DialogFragment dialogFragment = new DatePickerFragment();
        dialogFragment.show(this.getFragmentManager(), "datePicker");
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        MapController mapController;

        public PlaceholderFragment() {
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_create_pool, container, false);
            // Get a handle to the Map Fragment
            GoogleMap map;
            map = ((MapFragment) getFragmentManager()
                    .findFragmentById(R.id.map)).getMap();

            LatLng loc=new LatLng(51.4926, -0.144);
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(loc,15));

            mapController = new MapController(map);

            // set set current time
            Calendar c = Calendar.getInstance();
            int minute = c.get(Calendar.MINUTE);
            int hour = c.get(Calendar.HOUR_OF_DAY);

            String time = convertToHour(hour, minute);
            ((TextView) rootView.findViewById(R.id.create_tv_time)).setText(time);


            // set current date
            int day = c.get(Calendar.DAY_OF_MONTH);
            int month = c.get(Calendar.MONTH);
            int year = c.get(Calendar.YEAR);
            ((TextView) rootView.findViewById(R.id.create_tv_date)).setText(convertToDate(year,month,day));


            return rootView;
        }

    }

    // LOGIN LOGIC
    public static class LoginDialog extends DialogFragment {

        private EditText mEditText;

        public LoginDialog() {
        // Empty constructor required for DialogFragment
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_login, container);
            mEditText = (EditText) view.findViewById(R.id.login_et_password);
            getDialog().setTitle("Please confirm password!");

            return view;
        }
    }

}
