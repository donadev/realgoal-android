package it.scuola.realgoal.matchdetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.scuola.realgoal.R;
import it.scuola.realgoal.models.Event;
import it.scuola.realgoal.models.utils.EventType;

/**
 * Created by roberta_barban on 08/06/16.
 */
public class DetailEventHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.time_view) public TextView timeView;
    @BindView(R.id.icon_view) public ImageView iconView;
    @BindView(R.id.description_view) public TextView descriptionView;


    public DetailEventHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void init(Event e) {
        timeView.setText(e.time);
        descriptionView.setText(getText(e));
        int icon = getIcon(e);
        if(icon != 0) iconView.setImageResource(icon);
    }
    public String getText(Event e) {
        if(e == null) return "Evento indefinito";
        if(e.type == EventType.SUBSTITUTION) return "Entra " + e.substitution_in + ", esce " + e.substitution_out;
        else if(e.participant != null) return e.participant;
        else return "";
    }
    public int getIcon(Event e) {
        if(e == null || e.type == null) return 0;
        switch (e.type) {
            case AUTOGOL: return R.drawable.icon_autogol;
            case RCARD: return R.drawable.icon_rcard;
            case YCARD: return R.drawable.icon_ycard;
            case GOAL: return R.drawable.icon_goal;
            case SUBSTITUTION: return R.drawable.icon_substitution;
        }
        return 0;
    }
}
