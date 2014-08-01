package poolup.penguins.chocolate.com.poolup;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.mymodule.server.registration.Registration;
import com.example.mymodule.server.serverRouteEndpoint.ServerRouteEndpoint;
import com.example.mymodule.server.serverRouteEndpoint.model.ServerRoute;
import com.example.mymodule.server.serverUserEndpoint.ServerUserEndpoint;
import com.example.mymodule.server.serverUserEndpoint.model.ServerUser;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by demouser on 8/1/14.
 */
public class AddRouteEntryAsyncTask extends AsyncTask<Route, Void, Void> {

    public AddRouteEntryAsyncTask() {
//        Routes.Builder builder = new Routes.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null);
//
//        routesService = builder.build();

    }
    @Override
    public Void doInBackground(Route... params){

        Route route = params[0];
        ServerRouteEndpoint endpoint;
        ServerRouteEndpoint.Builder builder = new ServerRouteEndpoint.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(),null);

        endpoint = builder.build();
        ServerRoute serverRoute = new ServerRoute();
        serverRoute.setDriver(route.getDriver());
        serverRoute.setAvailableSeats(route.getAvailableSeats());

        serverRoute.setMinute(route.getDepatureMinute());
        serverRoute.setHour(route.getDepatureHour());
        serverRoute.setDate(route.getDepatureDate());
        serverRoute.setMonth(route.getDepatureMonth());
        serverRoute.setYear(route.getDepatureYear());

        serverRoute.setEndLatitude(route.getEndPoint().latitude);
        serverRoute.setEndLongitude(route.getEndPoint().longitude);
        serverRoute.setStartLatitude(route.getStartPoint().latitude);
        serverRoute.setStartLongitude(route.getStartPoint().longitude);


        try {
            endpoint.insertServerRoute(serverRoute).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        Route entry = params[0];
//        try {
////            myRoutes.add(entry.getDriver(), entry.get).execute();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
//        Toast.makeText("Route added", Toast.LENGTH_LONG).show();
    }
}


