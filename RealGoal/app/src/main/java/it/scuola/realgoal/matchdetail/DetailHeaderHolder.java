package it.scuola.realgoal.matchdetail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.scuola.realgoal.R;
import it.scuola.realgoal.models.MatchDetail;

/**
 * Created by roberta_barban on 08/06/16.
 */
public class DetailHeaderHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.home_name_view) public TextView homeNameView;
    @BindView(R.id.away_name_view) public TextView awayNameView;
    @BindView(R.id.home_icon_view) public ImageView homeIconView;
    @BindView(R.id.away_icon_view) public ImageView awayIconView;
    @BindView(R.id.score_view) public TextView scoreView;
    @BindView(R.id.date_view) public TextView dateView;
    private Context mContext;

    public DetailHeaderHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        ButterKnife.bind(this, itemView);
    }

    public void init(MatchDetail match) {
        homeNameView.setText(match.home.name);
        awayNameView.setText(match.away.name);
        scoreView.setText(match.home.score + " - " + match.away.score);

        dateView.setText(match.date);
        Picasso.with(mContext).load(match.home.icon).into(homeIconView);
        Picasso.with(mContext).load(match.away.icon).into(awayIconView);


    }
}
