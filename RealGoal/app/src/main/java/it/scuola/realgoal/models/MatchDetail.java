package it.scuola.realgoal.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.Date;
import java.util.List;

/**
 * Created by donadev on 02/06/16.
 */

@Parcel
public class MatchDetail {
    @SerializedName("home")
    public Team home;

    @SerializedName("away")
    public Team away;

    @SerializedName("date")
    public String date;

    @SerializedName("events")
    public List<Event> events;

}
