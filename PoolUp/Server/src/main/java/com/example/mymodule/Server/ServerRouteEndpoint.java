package com.example.mymodule.Server;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Named;
import static com.example.mymodule.Server.OfyService.ofy;

/** An endpoint class we are exposing */
@Api(name = "serverRouteEndpoint", version = "v1", namespace = @ApiNamespace(ownerDomain = "Server.mymodule.example.com", ownerName = "Server.mymodule.example.com", packagePath=""))
public class ServerRouteEndpoint {

    // Make sure to add this endpoint to your web.xml file if this is a web application.

    private static final Logger LOG = Logger.getLogger(ServerRouteEndpoint.class.getName());

    /**
     * This method gets the <code>ServerRoute</code> object associated with the specified <code>id</code>.
     * @param id The id of the object to be returned.
     * @return The <code>ServerRoute</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getServerRoute", path = "route/get")
    public ServerRoute getServerRoute(@Named("id") Long id) {
        // Implement this function

        LOG.info("Calling getServerRoute method");
        return null;
    }

    /**
     * This inserts a new <code>ServerRoute</code> object.
     * @param serverRoute The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertServerRoute")
    public void insertServerRoute(ServerRoute serverRoute) {
        // Implement this function

        ofy().save().entity(serverRoute).now();

        LOG.info("Calling insertServerRoute method");
    }


    private boolean acceptLatitude(double startLatitude, double endLatitude, double myPositionStartLatitude, double myPositionEndLatitude, int flexibility) {
        return (Math.abs(startLatitude - myPositionStartLatitude) < flexibility) && (Math.abs(endLatitude - myPositionEndLatitude) < flexibility);

    }

    private boolean acceptLongitude(double startLongitude, double endLongitude, double myPositionStartLongitude, double myPositionEndLongitude, int flexibility) {
        return (Math.abs(startLongitude - myPositionStartLongitude) < flexibility) && (Math.abs(endLongitude - myPositionEndLongitude) < flexibility);

    }

    private boolean acceptRoute(double startLatitude, double endLatitude, double myPositionStartLatitude, double myPositionEndLatitude,
                                double startLongitude, double endLongitude, double myPositionStartLongitude, double myPositionEndLongitude, int flexibility) {

        return acceptLatitude(startLatitude, endLatitude, myPositionStartLatitude, myPositionEndLatitude, flexibility) &&
                acceptLongitude(startLongitude, endLongitude, myPositionStartLongitude, myPositionEndLongitude, flexibility);
    }


    @ApiMethod(name = "listRoutes", path = "route/list")
    public List<ServerRoute> listDevices(@Named("latitudeStart") double latitudeStart, @Named("latitudeEnd") double latitudeEnd,
                                                       @Named("longitudeStart") double longitudeStart, @Named("longitudeEnd") double longitudeEnd,
                                                       @Named("flexibility") int flexibility) {
        List<ServerRoute> routes = ofy().load().type(ServerRoute.class).list();
        List<ServerRoute> acceptedRoutes = new ArrayList<ServerRoute>();
        for (ServerRoute serverRoute: routes) {
            boolean isAccepted = acceptRoute(serverRoute.getStartLatitude(), serverRoute.getEndLatitude(), latitudeStart,
                    latitudeEnd, serverRoute.getStartLongitude(), serverRoute.getEndLongitude(),
                    longitudeStart, longitudeEnd, flexibility);
            if (isAccepted) {
                acceptedRoutes.add(serverRoute);
            }
        }

        return acceptedRoutes;
    }
}