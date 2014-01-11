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

    @ApiMethod(name = "add", httpMethod = "post")
    public void add(Gift item) {
        ObjectifyService.register(Gift.class);
        ObjectifyService.ofy().save().entity(item).now();
    }

    /*@ApiMethod(name = "gift.add", httpMethod = "post")
    public void add(@Named("senderID") Long senderID, @Named("senderUsername") String senderUsername,
                    @Named("receiverID") Long receiverID, @Named("receiverUsername") String receiverUsername,
                    @Named("soundID") Long soundID, @Named("soundTitle") String soundTitle,
                    @Named("soundArtistID") Long soundArtistID, @Named("soundArtistUsername") String soundArtistUsername,
                    @Named("coverURL") String coverURL, @Named("streamURL") String streamURL) {
        Gift gift = Gift.create(senderID, receiverID, soundID, soundArtistID)
                .withSender(senderUsername).withReceiver(receiverUsername)
                .withTitle(soundTitle).withCover(coverURL).withStream(streamURL)
                .withArtist(soundArtistUsername);
        ObjectifyService.register(Gift.class);
        ObjectifyService.ofy().save().entity(gift).now();
    }*/

    /*@ApiMethod(name = "gift.addJSON", httpMethod = "post")
    public void addJSON(@Named("JSONString") String JSONString) {
        JsonObject object = JsonObject.readFrom(JSONString);
        long senderID = object.get(Gift.SENDER_ID).asLong();
        long receiverID = object.get(Gift.RECEIVER_ID).asLong();
        long soundID = object.get(Gift.SOUND_ID).asLong();
        long soundArtistID = object.get(Gift.SOUND_ARTIST_ID).asLong();
        String senderUsername = object.get(Gift.SENDER_USERNAME).asString();
        String receiverUsername = object.get(Gift.RECEIVER_USERNAME).asString();
        String soundTitle = object.get(Gift.SOUND_TITLE).asString();
        String coverURL = object.get(Gift.COVER_URL).asString();
        String streamURL = object.get(Gift.STREAM_URL).asString();
        String soundArtistUsername = object.get(Gift.SOUND_ARTIST_USERNAME).asString();
        Gift gift = Gift.create(senderID, receiverID, soundID, soundArtistID)
                .withSender(senderUsername).withReceiver(receiverUsername)
                .withTitle(soundTitle).withCover(coverURL).withStream(streamURL)
                .withArtist(soundArtistUsername);
        ObjectifyService.register(Gift.class);
        ObjectifyService.ofy().save().entity(gift).now();
    }*/

    @ApiMethod(name = "list")
    public List<Gift> getGift(@Named("id") Long id) {
        List< Gift> list1 = ObjectifyService.ofy().load().type(Gift.class).filter("senderID", id).list();
        List< Gift> list2 = ObjectifyService.ofy().load().type(Gift.class).filter("receiverID", id).list();
        list1.addAll(list2);
        /*JsonArray array = new JsonArray();
        for(Gift item: list1) {
            JsonObject object = new JsonObject()
                    .add(Gift.SENDER_ID, item.getSenderID())
                    .add(Gift.RECEIVER_ID, item.getReceiverID())
                    .add(Gift.SOUND_ID, item.getSoundID())
                    .add(Gift.SOUND_ARTIST_ID, item.getSoundArtistID())
                    .add(Gift.SENDER_USERNAME, item.getSenderUsername())
                    .add(Gift.RECEIVER_USERNAME, item.getReceiverUsername())
                    .add(Gift.SOUND_TITLE, item.getSoundTitle())
                    .add(Gift.COVER_URL, item.getCoverURL())
                    .add(Gift.STREAM_URL, item.getStreamURL())
                    .add(Gift.SOUND_ARTIST_USERNAME, item.getSoundArtistUsername());
            array.add(object);
        }*/
        return list1;
    }
}