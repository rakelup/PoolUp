package poolup.penguins.chocolate.com.poolup;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.mymodule.server.registration.Registration;
import com.example.mymodule.server.serverUserEndpoint.ServerUserEndpoint;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by demouser on 8/1/14.
 */
public class AddRouteEntryAsyncTask<T> extends AsyncTask<Route, Void, Void> {
    private Context context;
//    private Routes myRoutes;

    public AddRouteEntryAsyncTask() {
//        Routes.Builder builder = new Routes.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null);
//
//        routesService = builder.build();

    }
    @Override
    public Void doInBackground(Route... params){


        ServerUserEndpoint endpoint;
        ServerUserEndpoint.Builder builder = new ServerUserEndpoint.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(),null);

        endpoint = builder.build();
        //endpoint.insertServerUser(null).execute();




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


