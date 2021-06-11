package com.example.tsumusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tsumusic.Model.ToplistToday;
import com.example.tsumusic.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterToplist extends ArrayAdapter<ToplistToday> {
    public AdapterToplist(@NonNull Context context, int resource, @NonNull List<ToplistToday> objects) {
        super(context, resource, objects);
    }

    class ViewHolder {
        TextView txtnametoplist;
        ImageView imgbackgroundtoplist, imgviewtoplist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.line_toplist, null);
            viewHolder = new ViewHolder();
            viewHolder.txtnametoplist = convertView.findViewById(R.id.txtnametoplist);
            viewHolder.imgviewtoplist = convertView.findViewById(R.id.imgviewtoplist);
            viewHolder.imgbackgroundtoplist = convertView.findViewById(R.id.imgbackgroundtoplist);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ToplistToday toplistToday = getItem(position);
        Picasso.with(getContext()).load(toplistToday.getUrlhinhtoplist()).into(viewHolder.imgbackgroundtoplist);
        Picasso.with(getContext()).load(toplistToday.getIcontoplist()).into(viewHolder.imgviewtoplist);
        viewHolder.txtnametoplist.setText(toplistToday.getTentoplist());
        return convertView;
    }
}


