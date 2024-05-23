package com.example.pixelpower2024;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends BaseAdapter implements Filterable {
    private Context context;
    private final String[] originalOrgNames;
    private final int[] originalOrgImages;
    private String[] filteredOrgNames;
    private int[] filteredOrgImages;

    public GridAdapter(Context context, String[] orgNames, int[] orgImages) {
        this.context = context;
        this.originalOrgNames = orgNames;
        this.originalOrgImages = orgImages;
        this.filteredOrgNames = orgNames;
        this.filteredOrgImages = orgImages;
    }

    @Override
    public int getCount() {
        return filteredOrgNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.text);
        ImageView imageView = convertView.findViewById(R.id.image);

        textView.setText(filteredOrgNames[position]);
        imageView.setImageResource(filteredOrgImages[position]);

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                if (constraint == null || constraint.length() == 0) {
                    results.values = originalOrgNames;
                    results.count = originalOrgNames.length;

                    filteredOrgImages = originalOrgImages;
                } else {
                    List<String> filteredNamesList = new ArrayList<>();
                    List<Integer> filteredImagesList = new ArrayList<>();

                    for (int i = 0; i < originalOrgNames.length; i++) {
                        if (originalOrgNames[i].toLowerCase().contains(constraint.toString().toLowerCase())) {
                            filteredNamesList.add(originalOrgNames[i]);
                            filteredImagesList.add(originalOrgImages[i]);
                        }
                    }

                    filteredOrgNames = filteredNamesList.toArray(new String[0]);
                    filteredOrgImages = new int[filteredImagesList.size()];
                    for (int i = 0; i < filteredImagesList.size(); i++) {
                        filteredOrgImages[i] = filteredImagesList.get(i);
                    }

                    results.values = filteredOrgNames;
                    results.count = filteredOrgNames.length;
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredOrgNames = (String[]) results.values;
                notifyDataSetChanged();
            }
        };
    }

    // Public getter methods to access the filtered data
    public String[] getFilteredOrgNames() {
        return filteredOrgNames;
    }

    public int[] getFilteredOrgImages() {
        return filteredOrgImages;
    }
}