package it.scuola.realgoal.matchlist;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.scuola.realgoal.R;
import it.scuola.realgoal.matchdetail.DetailActivity;
import it.scuola.realgoal.models.Championship;
import it.scuola.realgoal.models.MatchInfos;
import it.scuola.realgoal.network.Service;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.matches_list_view) public RecyclerView matchListView;
    @BindView(R.id.matches_swipe_layout) public SwipeRefreshLayout matchRefreshLayout;

    private MatchesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        matchRefreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE);
        matchListView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        matchRefreshLayout.setOnRefreshListener(mRefreshListener);
        load();

    }
    private SwipeRefreshLayout.OnRefreshListener mRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            load();
        }
    };

    private void setRefreshing(final Boolean refreshing) {
        matchRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                matchRefreshLayout.setRefreshing(refreshing);
            }
        });
    }
    private MatchClickCallback mListener = new MatchClickCallback() {
        @Override
        public void click(int section, int cell) {
            MatchInfos match = mAdapter.getMatch(section, cell);
            Intent i = new Intent(MainActivity.this, DetailActivity.class);
            i.putExtra("id", match.id);
            startActivity(i);
        }

    };
    private void load() {
        if(!matchRefreshLayout.isRefreshing()) setRefreshing(true);
        Service.service().list(new Callback<List<Championship>>() {

            @Override
            public void success(List<Championship> championships, Response response) {
                mAdapter = new MatchesAdapter(championships);
                mAdapter.setMatchClickCallback(mListener);
                matchListView.setAdapter(mAdapter);
                setRefreshing(false);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, "Something went wrong! " + error.toString(), Toast.LENGTH_SHORT).show();
                setRefreshing(false);
            }
        });
    }
}
