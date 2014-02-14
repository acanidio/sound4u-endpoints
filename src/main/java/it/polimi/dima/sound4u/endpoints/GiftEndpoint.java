package it.polimi.dima.sound4u.endpoints;

import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.appengine.repackaged.com.google.api.client.json.Json;
import com.google.appengine.repackaged.org.codehaus.jackson.annotate.JsonCreator;
import com.googlecode.objectify.ObjectifyService;

import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Defines v1 of a sound4u-endpoints API, which provides simple "gift" methods.
 */

@Api(name = "sound4uendpoints", version = "v1")
public class GiftEndpoint {

    static {
        ObjectifyService.register(Gift.class);
    }

    @ApiMethod(name = "add", httpMethod = "post")
    public void add(Gift item) {
        ObjectifyService.ofy().save().entity(item).now();
    }

    @ApiMethod(name = "list", httpMethod = "post")
    public List<Gift> getGift(@Named("id") Long id) {
        List< Gift> list1 = ObjectifyService.ofy().load().type(Gift.class).filter("senderID", id).list();
        List< Gift> list2 = ObjectifyService.ofy().load().type(Gift.class).filter("receiverID", id).list();
        list1.addAll(list2);
        return list1;
    }
}