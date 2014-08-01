package poolup.penguins.chocolate.com.poolup;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by demouser on 7/31/14.
 */
public class MapController implements GoogleMap.OnMarkerDragListener {

    private final GoogleMap mMap;
    private Boolean mIsOriginSet = false;
    private Boolean mIsDestinationSet = false;
    private LatLng mOrigin;
    private LatLng mDestination;


    private final GoogleMap.OnMapClickListener mapListener = new GoogleMap.OnMapClickListener(){
        public void addMarker(View view) {
            Log.d("MAPS", "MapController addMarker");
            mMap.addMarker(new MarkerOptions().position(
                    new LatLng(mMap.getCameraPosition().target.latitude,
                            mMap.getCameraPosition().target.longitude)));




        }

        @Override
        public void onMapClick(LatLng point) {
            Log.d("MAPS", "enter onMapClick");


            if (mIsOriginSet ==false) {
                Log.d("MAPS", "origin");

                Marker origin= mMap.addMarker(new MarkerOptions().position(point)
                        .title("ORIGIN")
                        .snippet("Origin")
                        .icon(BitmapDescriptorFactory
                                .defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));


                mOrigin=point;
                mIsOriginSet =true;

            }
            else if (!mIsDestinationSet){
                Log.d("MAPS", " destination");

                Marker dest= mMap.addMarker(new MarkerOptions().position(point)
                        .title("DESTINATION")
                        .snippet("Destination")
                        .icon(BitmapDescriptorFactory
                                .defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
                mDestination = point;
                mIsDestinationSet = true;

            }
        }

    };



    public LatLng getOrigin() {
        return this.mOrigin;
    }

    public LatLng getDestination() {
        return this.mDestination;
    }

    public MapController(GoogleMap map)
    {
        mMap = map;

        map.setOnMapClickListener(mapListener);
        Log.d("MAPS", "MapController constructor");
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {



    }


//
//
//    @Override
//    public void onMapClick(LatLng point ) {
//
//
//    }



    /*LatLng sydney = new LatLng(-33.867, 151.206);

    mMap.setMyLocationEnabled(true);
    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));

    mMap.addMarker(new MarkerOptions()
    .title("Sydney")
    .snippet("The most populous city in Australia.")
    .position(sydney));

    mMap.setOnMapClickListener(this);*/

}
