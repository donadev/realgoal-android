package it.scuola.realgoal.matchlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.scuola.realgoal.R;
import it.scuola.realgoal.models.Championship;
import it.scuola.realgoal.models.MatchInfos;

/**
 * Created by davide_vaccher on 02/06/16.
 */
public class MatchesHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.date_view) public TextView dateView;
    @BindView(R.id.timer_view) public TextView timerView;
    @BindView(R.id.home_view) public TextView homeView;
    @BindView(R.id.score_view) public TextView scoreView;
    @BindView(R.id.away_view) public TextView awayView;

    public MatchesHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    public void setData(MatchInfos match) {
        dateView.setText(match.hour);
        timerView.setText(match.timer);
        homeView.setText(match.teamHome);
        scoreView.setText(match.score);
        awayView.setText(match.teamAway);

    }
}
