package poolup.penguins.chocolate.com.poolup;

import android.os.AsyncTask;

import com.example.mymodule.server.serverRouteEndpoint.ServerRouteEndpoint;
import com.example.mymodule.server.serverRouteEndpoint.model.CollectionResponseServerRoute;
import com.example.mymodule.server.serverRouteEndpoint.model.ServerRoute;
import com.example.mymodule.server.serverUserEndpoint.model.ServerUser;
import com.google.android.gms.maps.model.LatLng;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created by demouser on 8/1/14.
 */
public class RetrieveRouteAsyncTask extends AsyncTask<String, List<ServerRoute>, List<ServerRoute>> {

    @Override
    public List<ServerRoute> doInBackground(String... params){
        double latitudeStart= Double.parseDouble(params[0]);
        double latitudeEnd = Double.parseDouble(params[1]);
        double longitudeStart = Double.parseDouble(params[2]);
        double longitudeEnd = Double.parseDouble(params[3]);
        int flexibility = Integer.parseInt(params[4]);
        ServerRouteEndpoint endpoint;
        ServerRouteEndpoint.Builder builder = new ServerRouteEndpoint.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(),null);

        endpoint = builder.build();

        try {
            List<ServerRoute> routes = endpoint.listRoutes(flexibility, latitudeEnd, latitudeStart, longitudeEnd, longitudeStart).execute().getItems();
            return routes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<ServerRoute> routes) {
        super.onPostExecute(routes);

    }
}
