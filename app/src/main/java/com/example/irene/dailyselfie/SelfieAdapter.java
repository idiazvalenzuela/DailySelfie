package com.example.irene.dailyselfie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
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
    public ImageData getItem(int position) {
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

        //holder.selfie.setImageBitmap(curr.getSelfie());
        setPic(curr.getPath(), holder.selfie);
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

    public void setPic(String mCurrentPhotoPath, ImageView mImageView) {
        //ImageView mIm
        // Get the dimensions of the View
//        int targetW = mImageView.getWidth();
        //int targetH = mImageView.getHeight();
        int targetW = 204;
        int targetH = 153;

//
//        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;
//
//        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW/targetW, photoH/targetH);
//
//        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
//
        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        mImageView.setImageBitmap(bitmap);
    }





}
