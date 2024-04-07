package it.scuola.realgoal.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by donadev on 02/06/16.
 */

@Parcel
public class Team {
    @SerializedName("icon")
    public String icon;
    @SerializedName("name")
    public String name;
    @SerializedName("score")
    public int score;
}
