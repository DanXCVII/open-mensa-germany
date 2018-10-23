package com.example.android.openmensa.ExpandableRListView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.openmensa.R;
import com.thoughtbot.expandablecheckrecyclerview.CheckableChildRecyclerViewAdapter;
import com.thoughtbot.expandablecheckrecyclerview.models.CheckedExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class MultiCheckCityAdapter extends CheckableChildRecyclerViewAdapter<CityViewHolder, MultiCheckMensaViewHolder> {

    private final int MAX_MENSA = 5;
    private int mensa_count = 0;

    public MultiCheckCityAdapter(List<MultiCheckCity> groups) {
        super(groups);
    }

    @Override
    public MultiCheckMensaViewHolder onCreateCheckChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MultiCheckMensaViewHolder(view);
    }

    @Override
    public void onBindCheckChildViewHolder(MultiCheckMensaViewHolder holder, int flatPosition, CheckedExpandableGroup group, int childIndex) {
        final Mensa mensa = (Mensa) group.getItems().get(childIndex);
        holder.setMensaName(mensa.getName());
    }

    @Override
    public void checkChild(boolean checked, int groupIndex, int childIndex) {
        super.checkChild(checked, groupIndex, childIndex);
    }

    @Override
    public void onChildCheckChanged(View view, boolean checked, int flatPos) {
        CharSequence toastText = "Maximum 5 Mensa";
        // If a Box gets unchecked
        if(checked == false) {
            mensa_count--;
        }
        // Maximum of 5 Mensen reached
        if(checked == true && mensa_count+1 >= 6) {
            Toast.makeText(view.getContext(), R.string.max_reached, Toast.LENGTH_SHORT).show();
            
        }
        super.onChildCheckChanged(view, checked, flatPos);
    }

    @Override
    public CityViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_group, parent, false);
        Log.v("test3", "" + view);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindGroupViewHolder(CityViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setCityTitle(group);
    }
}