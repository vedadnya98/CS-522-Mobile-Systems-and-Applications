package edu.stevens.cs522.chatserver.entities;

import android.os.Parcel;
import android.os.Parcelable;
//import android.text.format.DateUtils;
import edu.stevens.cs522.base.DateUtils;

import edu.stevens.cs522.base.InetAddressUtils;

import java.net.InetAddress;
import java.util.Date;

/**
 * Created by dduggan.
 */

public class Peer implements Parcelable {

    // Will be database key
    public long id;

    public String name;

    // Last time we heard from this peer.
    public Date timestamp;

    // Where we heard from them
    public InetAddress address;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        // TODO
        out.writeLong(this.id);
        out.writeString(this.name);
        DateUtils.writeDate(out,this.timestamp);
        InetAddressUtils.writeAddress(out,this.address);

    }

    public Peer() {}

    public Peer(Parcel in) {
        // TODO
        this.id = in.readLong();
        this.name= in.readString();
        this.timestamp = DateUtils.readDate(in);
        this.address = InetAddressUtils.readAddress(in);
    }

    public static final Creator<Peer> CREATOR = new Creator<Peer>() {

        @Override
        public Peer createFromParcel(Parcel source) {
            // TODO

            return new Peer(source);
        }

        @Override
        public Peer[] newArray(int size) {
            // TODO
            return new Peer[size];
        }

    };
}
