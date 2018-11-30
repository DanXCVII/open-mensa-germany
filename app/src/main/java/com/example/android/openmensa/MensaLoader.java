package com.example.android.openmensa;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.example.android.openmensa.ExpandableRListView.Mensa;

import java.util.List;

public class MensaLoader extends AsyncTaskLoader<List<Mensa>> {

    /** Tag for log messages */
    private static final String LOG_TAG = MensaLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link MensaLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public MensaLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Mensa> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Mensa> earthquakes = QueryUtils.fetchMensaData(mUrl);
        return earthquakes;
    }
}
