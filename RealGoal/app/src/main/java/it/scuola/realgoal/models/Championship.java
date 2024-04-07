package it.scuola.realgoal.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.List;


/**
 * Created by donadev on 01/06/16.
 */
@Parcel
public class Championship {
    @SerializedName("country")
    public String country;
    @SerializedName("tournament")
    public String name;
    @SerializedName("matches")
    public List<MatchInfos> matches;
}
