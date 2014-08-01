package poolup.penguins.chocolate.com.poolup;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import android.graphics.Color;
import android.os.AsyncTask;

import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.model.PolylineOptions;

/**
 * Created by demouser on 8/1/14.
 */
public class ShowRouteDialog extends DialogFragment {
        private EditText mEditText;
        GoogleMap map;
        TextView tvDistance;
        TextView tvDuration;

        public ShowRouteDialog() {
            // Empty constructor required for DialogFragment
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

           LatLng locA=new LatLng(getArguments().getDouble("SOURCE_LAT"),getArguments().getDouble("SOURCE_LONG"));
           LatLng locB=new LatLng(getArguments().getDouble("DEST_LAT"),getArguments().getDouble("DEST_LONG"));
           View view;



            view = inflater.inflate(R.layout.fragment_show_route, container);

            map = ((MapFragment) getFragmentManager()
                    .findFragmentById(R.id.mapRoute)).getMap();

            map.setMyLocationEnabled(true);

            map.animateCamera(CameraUpdateFactory.newLatLngZoom(locA, 8));

            map.addMarker(new MarkerOptions().position(locA).
                    icon(BitmapDescriptorFactory .defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).draggable(true));

            map.addMarker(new MarkerOptions().position(locB).
                    icon(BitmapDescriptorFactory .defaultMarker(BitmapDescriptorFactory.HUE_BLUE)).draggable(true));



            tvDistance= (TextView) view.findViewById(R.id.show_route_distance);
            tvDuration= (TextView) view.findViewById(R.id.show_route_duration);

            Log.d("MAPS", "enter GetDirections");
            String url = getDirectionsUrl(locA, locB);
            Log.d("MAPS", "enter DownloadTrask");

            DownloadTask downloadTask = new DownloadTask();
            Log.d("MAPS", "enter DownloadTraskExecute");

            // Start downloading json data from Google Directions API
            downloadTask.execute(url);

            Log.d("MAPS", "beforeReturn");

            //map.animateCamera(CameraUpdateFactory.newLatLngZoom(locA, 15));



            return view;
        }


    private String getDirectionsUrl(LatLng origin, LatLng dest)
    {
        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;

        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;

        // Sensor enabled
        String sensor = "sensor=false";

        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + sensor;

        // Output format
        String output = "json";

        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters;

        Log.d("maps",url);

        return url;
    }

    /** A method to download json data from url */

    private String downloadUrl(String strUrl) throws IOException
    {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try
        {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null)
            {
                sb.append(line);
            }

            data = sb.toString();

            br.close();

        } catch (Exception e)
        {
            Log.d("Exception while downloading url", e.toString());
        } finally
        {
            iStream.close();
            urlConnection.disconnect();
        }
        return data;
    }

    // Fetches data from url passed
    private class DownloadTask extends AsyncTask<String, Void, String>
    {
        // Downloading data in non-ui thread
        @Override
        protected String doInBackground(String... url)
        {

            // For storing data from web service
            String data = "";

            try
            {
                // Fetching the data from web service
                data = downloadUrl(url[0]);
            } catch (Exception e)
            {
                Log.d("Background Task", e.toString());
            }
            return data;
        }

        // Executes in UI thread, after the execution of
        // doInBackground()
        @Override
        protected void onPostExecute(String result)
        {
            super.onPostExecute(result);

            ParserTask parserTask = new ParserTask();

            // Invokes the thread for parsing the JSON data
            parserTask.execute(result);

        }
    }

    /** A class to parse the Google Places in JSON format */
    private class ParserTask extends AsyncTask<String, Integer, List<List<HashMap<String, String>>>>
    {

        // Parsing the data in non-ui thread
        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... jsonData)
        {
            JSONObject jObject;
            List<List<HashMap<String, String>>> routes = null;

            try
            {
                jObject = new JSONObject(jsonData[0]);
                DirectionsJSONParser parser = new DirectionsJSONParser();

                // Starts parsing data
                routes = parser.parse(jObject);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            return routes;
        }

        // Executes in UI thread, after the parsing process
        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> result)
        {
            ArrayList<LatLng> points = null;
            PolylineOptions lineOptions = null;
            MarkerOptions markerOptions = new MarkerOptions();
            String distance = "";
            String duration = "";



            // Traversing through all the routes
            for (int i = 0; i < result.size(); i++)
            {
                points = new ArrayList<LatLng>();
                lineOptions = new PolylineOptions();

                // Fetching i-th route
                List<HashMap<String, String>> path = result.get(i);

                // Fetching all the points in i-th route
                for (int j = 0; j < path.size(); j++)
                {
                    HashMap<String, String> point = path.get(j);

                    if (j == 0)
                    { // Get distance from the list
                        distance = point.get("distance");
                        continue;
                    } else if (j == 1)
                    { // Get duration from the list
                        duration = point.get("duration");
                        continue;
                    }
                    double lat = Double.parseDouble(point.get("lat"));
                    double lng = Double.parseDouble(point.get("lng"));
                    LatLng position = new LatLng(lat, lng);
                    points.add(position);
                }

                // Adding all the points in the route to LineOptions
                lineOptions.addAll(points);
                lineOptions.width(2);
                lineOptions.color(Color.RED);
            }

          tvDistance.setText( distance);
          tvDuration.setText( duration );

            // Drawing polyline in the Google Map for the i-th route

            Log.d("maps","pintando la linea");
           map.addPolyline(lineOptions);
        }
    }
   }


