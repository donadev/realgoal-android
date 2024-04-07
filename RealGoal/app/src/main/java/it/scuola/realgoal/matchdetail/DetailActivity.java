package it.scuola.realgoal.matchdetail;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.scuola.realgoal.R;
import it.scuola.realgoal.models.MatchDetail;
import it.scuola.realgoal.network.APIManager;
import it.scuola.realgoal.network.Service;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DetailActivity extends AppCompatActivity {

    private String id;

    @BindView(R.id.recyclerview) public RecyclerView detailRecyclerView;
    @BindView(R.id.detail_swipe_refresh_layout) public SwipeRefreshLayout detailSwipeRefreshLayout;

    private DetailAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("id");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        detailRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        detailSwipeRefreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        loadInfos();
    }

    private void setRefreshing(final Boolean refreshing) {
        detailSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                detailSwipeRefreshLayout.setRefreshing(refreshing);
            }
        });
    }

    private void loadInfos() {
        setRefreshing(true);
        Service.service().getMatch(id, new Callback<MatchDetail>() {
            @Override
            public void success(MatchDetail matchDetail, Response response) {
                mAdapter = new DetailAdapter(matchDetail);
                detailRecyclerView.setAdapter(mAdapter);
                setRefreshing(false);
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
                setRefreshing(false);
                Snackbar.make(detailRecyclerView, "Errore di connessione, riprova", Snackbar.LENGTH_LONG).setAction("Riprova", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        loadInfos();
                    }
                }).show();
            }
        });
    }

}
