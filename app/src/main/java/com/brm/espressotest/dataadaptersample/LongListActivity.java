package com.brm.espressotest.dataadaptersample;


import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.brm.espressotest.R;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * An activity displaying a long list with a text view and a toggle button. The last clicked row is
 * displayed at the top.
 */
public class LongListActivity extends Activity {

    @VisibleForTesting
    public static final String ROW_TEXT = "ROW_TEXT";

    @VisibleForTesting
    protected static final String ROW_ENABLED = "ROW_ENABLED";

    @VisibleForTesting
    protected static final int NUMBER_OF_ITEMS = 100;

    @VisibleForTesting
    protected static final String ITEM_TEXT_FORMAT = "item: %d";

    private List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

    private LayoutInflater layoutInflater;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_long_list);
        populateData();

        ListView listView = (ListView) findViewById(R.id.list);
        String[] from = new String[]{ROW_TEXT, ROW_ENABLED};
        int[] to = new int[]{R.id.rowContentTextView, R.id.rowToggleButton};
        layoutInflater = getLayoutInflater();

        // Create the adapter for the list.
        ListAdapter adapter = new LongListAdapter(from, to);

        // Send the data to the list.
        listView.setAdapter(adapter);
    }

    @VisibleForTesting
    protected static Map<String, Object> makeItem(int forRow) {
        Map<String, Object> dataRow = Maps.newHashMap();
        dataRow.put(ROW_TEXT, String.format(ITEM_TEXT_FORMAT, forRow));
        dataRow.put(ROW_ENABLED, forRow == 1);
        return dataRow;
    }

    private void populateData() {
        for (int i = 0; i < NUMBER_OF_ITEMS; i++) {
            data.add(makeItem(i));
        }
    }

    private class LongListAdapter extends SimpleAdapter {

        public LongListAdapter(String[] from, int[] to) {
            super(LongListActivity.this, LongListActivity.this.data, R.layout.long_list_item, from, to);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // Inflate list items.
            if (null == convertView) {
                convertView = layoutInflater.inflate(R.layout.long_list_item, null);
            }

            convertView.setOnClickListener(v -> ((TextView) findViewById(R.id.selection_row_value)).setText(
                    String.valueOf(position)));

            return super.getView(position, convertView, parent);
        }
    }
}