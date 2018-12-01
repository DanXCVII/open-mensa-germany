package com.example.android.openmensa;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.openmensa.ExpandableRListView.Mensa;
import com.example.android.openmensa.ExpandableRListView.MultiCheckCity;
import com.example.android.openmensa.ExpandableRListView.MultiCheckCityAdapter;

import java.util.Arrays;
import java.util.List;

public class AddMensaActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Mensa>> {

    private MultiCheckCityAdapter mAdapter;

    private static final String OPENMENSA_REQUEST_URL = "http://openmensa.org/api/v2/canteens";

    /**
     * Constant value for the earthquake loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int MENSA_LOADER_ID = 1;

    /** TextView that is displayed when the list is empty */
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.town_ex_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        mAdapter = new MultiCheckCityAdapter(createAndReturnRandomList());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    private List<MultiCheckCity> create

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
        mAdapter.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mAdapter.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public Loader<List<Mensa>> onCreateLoader(int i, Bundle bundle) {
        // Create new Loader for the given URL
        return new MensaLoader(this, OPENMENSA_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Mensa>> loader, List<Mensa> earthquakes) {
        // Hide loading indicator because the data has been loaded
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        // Set empty state text to display "No earthquakes found."
        mEmptyStateTextView.setText(R.string.no_mensas);

        // Clear the adapter of previous earthquake data
        //mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (earthquakes != null && !earthquakes.isEmpty()) {
            //mAdapter.addAll(earthquakes);
            //-------------------------------------updateUi(earthquakes); // Needs to be implemented
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Mensa>> loader) {

    }
}