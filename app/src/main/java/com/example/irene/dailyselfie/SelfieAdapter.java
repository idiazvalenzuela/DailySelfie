package com.example.irene.dailyselfie;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by irene on 17/07/15.
 */
public class SelfieAdapter extends BaseAdapter{

    private Context mContext;
    private ArrayList<ImageData> list = new ArrayList<ImageData>();
    private static LayoutInflater inflater = null;


    public SelfieAdapter(Context c){
        mContext = c;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View newView = convertView;
        ViewHolder holder;

        ImageData curr = list.get(position);

        if (null == convertView) {
            holder = new ViewHolder();
            newView = inflater
                    .inflate(R.layout.listview_layout, parent, false);
            holder.selfie = (ImageView) newView.findViewById(R.id.selfie);
            holder.name = (TextView) newView.findViewById(R.id.filename);
            newView.setTag(holder);

        } else {
            holder = (ViewHolder) newView.getTag();
        }

        holder.selfie.setImageBitmap(curr.getSelfie());
        holder.name.setText(curr.getName());

        return newView;
    }


    static class ViewHolder {

        ImageView selfie;
        TextView name;

    }

    public void add(ImageData listItem) {
        list.add(listItem);
        notifyDataSetChanged();
    }


}
