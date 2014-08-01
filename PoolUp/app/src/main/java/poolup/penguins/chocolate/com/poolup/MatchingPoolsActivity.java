package poolup.penguins.chocolate.com.poolup;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

import poolup.penguins.chocolate.com.poolup.R;

public class MatchingPoolsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_pools);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.matching_pools, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_matching_pools, container, false);

            RoutesAdapter adapter = new RoutesAdapter();
            ListView listView = (ListView) rootView.findViewById(R.id.matching_pools_listview);
            listView.setAdapter(adapter);

            return rootView;
        }


        private class RoutesAdapter extends BaseAdapter {

            private ArrayList<Route> routes;

            public RoutesAdapter() {
                routes = new ArrayList<Route>();
                Time t = new Time();
                t.setToNow();
                routes.add(new Route("Brit",3,20, 1, 3, 3, 12, 23, new LatLng(1,1), new LatLng(2,2)));
                t.set(0,1,2,3,4,5);
                routes.add(new Route("Hanna",2,20, 3, 2, 1, 23, 12, new LatLng(1,1), new LatLng(2,2)));
            }


            public int getCount() {
                return routes.size();
            }

            public Route getItem(int position) {
                return routes.get(position);
            }

            public long getItemId(int position) {
                return routes.get(position).getId();
            }

            public View getView(int position, View convertView, ViewGroup parent) {

                LinearLayout layout;
                Route currRoute = routes.get(position);

                if (convertView == null) {
                    layout = new LinearLayout(parent.getContext());
                    layout.setOrientation(LinearLayout.VERTICAL);

                    TextView timeView = new TextView(parent.getContext());
                    timeView.setText(String.format("%02d",currRoute.getDepatureDate()) + "/" + String.format("%02d",currRoute.getDepatureMonth()) + "/" + currRoute.getDepatureYear() + " " + String.format("%02d",currRoute.getDepatureHour()) + ":" + String.format("%02d",currRoute.getDepatureMinute()));
                    timeView.setTextSize(18);
                    timeView.setTypeface(null, Typeface.BOLD);
                    timeView.setTextColor(Color.DKGRAY);
                    layout.addView(timeView);

                    TextView driverView = new TextView(parent.getContext());
                    driverView.setText("Driver: " + currRoute.getDriver());
                    driverView.setTextSize(18);
                    driverView.setTextColor(Color.DKGRAY);
                    layout.addView(driverView);

                    TextView priceView = new TextView(parent.getContext());
                    priceView.setText("Price: " + currRoute.getPrice() + "$");
                    priceView.setTextSize(18);
                    priceView.setTextColor(Color.DKGRAY);
                    layout.addView(priceView);

                }
                else {
                    layout = (LinearLayout) convertView;
                }

                return layout;
            }

        }


    }
}
