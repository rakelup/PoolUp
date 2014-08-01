package poolup.penguins.chocolate.com.poolup;

import android.os.AsyncTask;

import com.example.mymodule.server.serverRouteEndpoint.ServerRouteEndpoint;
import com.example.mymodule.server.serverRouteEndpoint.model.ServerRoute;
import com.example.mymodule.server.serverUserEndpoint.ServerUserEndpoint;
import com.example.mymodule.server.serverUserEndpoint.model.ServerUser;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by demouser on 8/1/14.
 */
public class AddUserEntryAsyncTask extends AsyncTask<User, Void, Void> {

    @Override
    public Void doInBackground(User... params){
        User user = params[0];
        ServerUserEndpoint endpoint;
        ServerUserEndpoint.Builder builder = new ServerUserEndpoint.Builder(AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(),null);

        endpoint = builder.build();
        ServerUser serverUser = new ServerUser();
        serverUser.setName(user.getName());
        serverUser.setPassword(user.getPassword());
        serverUser.setPhoneNumber(user.getPhoneNumber());

        try {
            endpoint.insertServerUser(serverUser).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
