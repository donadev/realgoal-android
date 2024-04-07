package it.scuola.realgoal.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import it.scuola.realgoal.models.utils.EventType;
import it.scuola.realgoal.models.utils.TeamType;

/**
 * Created by donadev on 02/06/16.
 */
@Parcel
public class Event {

    @SerializedName("time")
    public String time;

    @SerializedName("participant")
    public String participant;

    @SerializedName("assist")
    public String assist;

    @SerializedName("substitution_in")
    public String substitution_in;

    @SerializedName("substitution_out")
    public String substitution_out;

    @SerializedName("team")
    public TeamType teamType;

    @SerializedName("name")
    public EventType type;
}
