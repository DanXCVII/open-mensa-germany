package com.example.android.openmensa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.openmensa.ExpandableRListView.MultiCheckCity;
import com.example.android.openmensa.ExpandableRListView.Mensa;
import com.example.android.openmensa.ExpandableRListView.MultiCheckCityAdapter;

import java.util.Arrays;
import java.util.List;

public class AddMensaActivity extends AppCompatActivity {

    private MultiCheckCityAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.town_ex_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        adapter = new MultiCheckCityAdapter(createAndReturnRandomList());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private List<MultiCheckCity> createAndReturnRandomList() {
        // creating List of Münster Mensen
        Mensa mensa1 = new Mensa("Mensa am Ring", "65484");
        Mensa mensa2 = new Mensa("Bispinghof", "68435");
        Mensa mensa3 = new Mensa("Mensa am Aasee", "84542");

        MultiCheckCity muenster = new MultiCheckCity("Münster", Arrays.asList(mensa1, mensa2, mensa3), "68351");

        //creating List of Frankfurt Mensen
        Mensa mensa4 = new Mensa("Mensa an der Bank", "84516");
        Mensa mensa5 = new Mensa("Mensa am See", "87546");

        MultiCheckCity frankfurt = new MultiCheckCity("Frankfurt", Arrays.asList(mensa4, mensa5), "94175");

        return Arrays.asList(muenster, frankfurt);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        adapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        adapter.onRestoreInstanceState(savedInstanceState);
    }
}