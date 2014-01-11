package it.polimi.dima.sound4u.endpoints;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;


/**
 * Created by canidio-andrea on 11/01/14.
 */
@Entity
public class Gift {

    @Id
    Long ID;

    public static final String SENDER_ID = "SENDER_ID";
    @Index
    Long senderID;

    public static final String SENDER_USERNAME = "SENDER_USERNAME";
    String senderUsername;

    public static final String RECEIVER_ID = "RECEIVER_ID";
    @Index
    Long receiverID;

    public static final String RECEIVER_USERNAME = "RECEIVER_USERNAME";
    String receiverUsername;

    public static final String SOUND_ID = "SOUND_ID";
    Long soundID;

    public static final String SOUND_TITLE = "SOUND_TITLE";
    String soundTitle;

    public static final String SOUND_ARTIST_ID = "SOUND_ARTIST_ID";
    Long soundArtistID;

    public static final String SOUND_ARTIST_USERNAME = "SOUND_ARTIST_USERNAME";
    String soundArtistUsername;

    public static final String COVER_URL = "COVER_URL";
    String coverURL;

    public static final String STREAM_URL = "STREAM_URL";
    String streamURL;

    private Gift(final long senderID, final long receiverID, final long soundID, final long soundArtistID) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.soundID = soundID;
        this.soundArtistID = soundArtistID;
    }

    public Gift() { }

    public static Gift create(final long senderID, final long receiverID, final long soundID, final long soundArtistID) {
        return new Gift(senderID, receiverID, soundID, soundArtistID);
    }

    public Gift withSender(String username) {
        this.senderUsername = username;
        return this;
    }

    public Gift withReceiver(String username) {
        this.receiverUsername = username;
        return this;
    }

    public Gift withTitle(String title) {
        this.soundTitle = title;
        return this;
    }

    public Gift withArtist(String username) {
        this.soundArtistUsername = username;
        return this;
    }

    public Gift withCover(String coverURL) {
        this.coverURL = coverURL;
        return this;
    }

    public Gift withStream(String streamURL) {
        this.streamURL = streamURL;
        return this;
    }

    public long getID() {
        return ID;
    }

    public long getSenderID() {
        return senderID;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public long getReceiverID() {
        return receiverID;
    }

    public String getReceiverUsername() {
        return receiverUsername;
    }

    public long getSoundID() {
        return soundID;
    }

    public String getSoundTitle() {
        return soundTitle;
    }

    public long getSoundArtistID() {
        return soundArtistID;
    }

    public String getSoundArtistUsername() {
        return soundArtistUsername;
    }

    public String getCoverURL() {
        return coverURL;
    }

    public String getStreamURL() {
        return streamURL;
    }
}
