package it.scuola.realgoal.matchdetail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.truizlop.sectionedrecyclerview.SectionedRecyclerViewAdapter;

import it.scuola.realgoal.R;
import it.scuola.realgoal.models.Event;
import it.scuola.realgoal.models.MatchDetail;
import it.scuola.realgoal.models.utils.TeamType;

/**
 * Created by roberta_barban on 08/06/16.
 */
public class DetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private MatchDetail match;

    private static final int TYPE_EVENT_HOME = 1;
    private static final int TYPE_EVENT_AWAY = 2;
    private static final int TYPE_HEADER = 3;


    public DetailAdapter(MatchDetail match) {
        this.match = match;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_detail_header_cell, parent, false);
            return new DetailHeaderHolder(v);
        } else if(viewType == TYPE_EVENT_AWAY) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_event_away_cell, parent, false);
            return new DetailEventHolder(v);
        } else if(viewType == TYPE_EVENT_HOME) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_event_home_cell, parent, false);
            return new DetailEventHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof DetailEventHolder) {
            Event e = match.events.get(position - 1);
            ((DetailEventHolder)holder).init(e);
        } else if (holder instanceof DetailHeaderHolder) {
            ((DetailHeaderHolder)holder).init(match);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) return TYPE_HEADER;
        Event e = match.events.get(position - 1);
        return e.teamType == TeamType.AWAY ? TYPE_EVENT_AWAY : TYPE_EVENT_HOME;
    }

    @Override
    public int getItemCount() {
        return match.events.size() + 1;
    }

}

