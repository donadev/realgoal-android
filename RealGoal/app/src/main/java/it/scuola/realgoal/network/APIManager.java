package it.scuola.realgoal.network;

import java.util.List;

import it.scuola.realgoal.models.Championship;
import it.scuola.realgoal.models.MatchDetail;
import it.scuola.realgoal.models.MatchInfos;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by donadev on 01/06/16.
 */
public interface APIManager {
    @GET("/matches/list")
    void list(Callback<List<Championship>> cb);

    @GET("/matches/detail")
    void getMatch(@Query("id") String id, Callback<MatchDetail> cb);
}
