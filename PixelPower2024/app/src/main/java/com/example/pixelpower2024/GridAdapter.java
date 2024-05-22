package com.example.pixelpower2024;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private final String[] orgNames;
    private final int[] orgImages;

    public GridAdapter(Context context, String[] orgNames, int[] orgImages) {
        this.context = context;
        this.orgNames = orgNames;
        this.orgImages = orgImages;
    }

    @Override
    public int getCount() {
        return orgNames.length;
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

        textView.setText(orgNames[position]);
        imageView.setImageResource(orgImages[position]);

        return convertView;
    }
}
