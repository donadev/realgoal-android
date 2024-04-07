package it.scuola.realgoal.network;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by donadev on 01/06/16.
 */
public class Service {
    public static APIManager service() {
        Gson gson = Serializer.initialize();

        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(60, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(60, TimeUnit.SECONDS);
        RestAdapter adapter = new RestAdapter.Builder()
                                             .setLogLevel(RestAdapter.LogLevel.FULL)
                                             .setConverter(new GsonConverter(gson))
                                             .setClient(new OkClient(okHttpClient))
                                             .setEndpoint("http://192.168.1.3:1337")
                                             .build();
        return adapter.create(APIManager.class);
    }
}
