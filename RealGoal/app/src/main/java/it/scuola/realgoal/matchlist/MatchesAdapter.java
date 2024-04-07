package it.scuola.realgoal.matchlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.truizlop.sectionedrecyclerview.SimpleSectionedAdapter;

import java.util.List;

import it.scuola.realgoal.R;
import it.scuola.realgoal.models.Championship;
import it.scuola.realgoal.models.MatchInfos;

/**
 * Created by davide_vaccher on 02/06/16.
 */
public class MatchesAdapter extends SimpleSectionedAdapter<MatchesHolder> {

    private List<Championship> mValues;
    private MatchClickCallback mCb;
    public MatchesAdapter(List<Championship> values) {
        mValues = values;
    }
    public void setMatchClickCallback(MatchClickCallback cb) {
        mCb = cb;
    }
    public MatchInfos getMatch(int section, int index) {
        return mValues.get(section).matches.get(index);
    }

    @Override
    protected String getSectionHeaderTitle(int section) {
        Championship championship = mValues.get(section);
        return championship.country + " : " + championship.name;
    }

    @Override
    protected int getSectionCount() {
        return mValues.size();
    }

    @Override
    protected int getItemCountForSection(int section) {
        return mValues.get(section).matches.size();
    }

    @Override
    protected MatchesHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.matches_cell, parent, false);

        return new MatchesHolder(view);
    }

    @Override
    protected void onBindItemViewHolder(MatchesHolder holder, final int section, final int position) {
        Championship champ = mValues.get(section);
        MatchInfos infos = champ.matches.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCb != null) mCb.click(section, position);
            }
        });
        holder.setData(infos);
    }
}
