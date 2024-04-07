package it.scuola.realgoal.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import it.scuola.realgoal.models.utils.MatchState;

/**
 * Created by donadev on 01/06/16.
 */
@Parcel
public class MatchInfos {
    @SerializedName("id")
    public String id;
    @SerializedName("state")
    public MatchState state;
    @SerializedName("hour")
    public String hour;
    @SerializedName("team_home")
    public String teamHome;
    @SerializedName("team_away")
    public String teamAway;
    @SerializedName("score")
    public String score;
    @SerializedName("timer")
    public String timer;

}
