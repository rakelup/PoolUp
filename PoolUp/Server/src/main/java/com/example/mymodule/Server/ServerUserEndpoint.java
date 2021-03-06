package com.example.mymodule.Server;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Named;
import static com.example.mymodule.Server.OfyService.ofy;

/** An endpoint class we are exposing */
@Api(name = "serverUserEndpoint", version = "v1", namespace = @ApiNamespace(ownerDomain = "Server.mymodule.example.com", ownerName = "Server.mymodule.example.com", packagePath=""))
public class ServerUserEndpoint {

    // Make sure to add this endpoint to your web.xml file if this is a web application.

    private static final Logger LOG = Logger.getLogger(ServerUserEndpoint.class.getName());

    /**
     * This method gets the <code>ServerUser</code> object associated with the specified <code>id</code>.
     * @param id The id of the object to be returned.
     * @return The <code>ServerUser</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getServerUser", path="user/get")
    public ServerUser getServerUser(@Named("id") Long id) {
        // Implement this function

        LOG.info("Calling getServerUser method");
        return null;
    }

    /**
     * This inserts a new <code>ServerUser</code> object.
     * @param serverUser The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertServerUser")
    public void insertServerUser(ServerUser serverUser) {
        // Implement this function
        ofy().save().entity(serverUser).now();
        LOG.info("Calling insertServerUser method");
    }

    @ApiMethod(name = "listUsers", path="user/list")
    public CollectionResponse<ServerUser> listDevices(@Named("count") int count) {
        List<ServerUser> users = ofy().load().type(ServerUser.class).limit(count).list();
        return CollectionResponse.<ServerUser>builder().setItems(users).build();
    }
}