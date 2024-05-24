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
    private final List<EventDetails> originalEvents;
    private List<EventDetails> filteredEvents;

    public GridAdapter(Context context, List<EventDetails> events) {
        this.context = context;
        this.originalEvents = events;
        this.filteredEvents = events;
    }

    @Override
    public int getCount() {
        return filteredEvents.size();
    }

    @Override
    public Object getItem(int position) {
        return filteredEvents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.text);
        ImageView imageView = convertView.findViewById(R.id.image);

        EventDetails event = filteredEvents.get(position);
        textView.setText(event.getName());
        imageView.setImageResource(event.getImageResourceId());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                if (constraint == null || constraint.length() == 0) {
                    results.values = originalEvents;
                    results.count = originalEvents.size();
                } else {
                    List<EventDetails> filteredList = new ArrayList<>();
                    for (EventDetails event : originalEvents) {
                        if (event.getName().toLowerCase().contains(constraint.toString().toLowerCase())) {
                            filteredList.add(event);
                        }
                    }
                    results.values = filteredList;
                    results.count = filteredList.size();
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredEvents = (List<EventDetails>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    // Getter method to access filtered events
    public List<EventDetails> getFilteredEvents() {
        return filteredEvents;
    }
}
