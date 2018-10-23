package com.example.android.openmensa.ExpandableRListView;

import android.view.View;
import android.widget.Checkable;
import android.widget.CheckedTextView;

import com.example.android.openmensa.R;
import com.thoughtbot.expandablecheckrecyclerview.viewholders.CheckableChildViewHolder;

public class MultiCheckMensaViewHolder extends CheckableChildViewHolder {

    private CheckedTextView childCheckedTextView;

    public MultiCheckMensaViewHolder(View itemView) {
        super(itemView);
        childCheckedTextView = (CheckedTextView) itemView.findViewById(R.id.list_item_multicheck_mensa_name);

    }

    @Override
    public Checkable getCheckable() {
        return childCheckedTextView;
    }

    public void setMensaName(String mensaName) {
        childCheckedTextView.setText(mensaName);
    }
}
