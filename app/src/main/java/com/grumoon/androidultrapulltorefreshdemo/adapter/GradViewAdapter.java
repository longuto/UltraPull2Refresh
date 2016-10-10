package com.grumoon.androidultrapulltorefreshdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.grumoon.androidultrapulltorefreshdemo.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by grumoon on 15/1/17.
 */
public class GradViewAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private String[] imageUrls;

    private DisplayImageOptions options;

    public GradViewAdapter(Context context, String[] imageUrls) {

        this.layoutInflater = LayoutInflater.from(context);
        this.imageUrls = imageUrls;

        options = new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.drawable.ic_empty_small)
                .showImageOnLoading(R.drawable.ic_empty_small)
                .showImageOnFail(R.drawable.ic_empty_small)
                .cacheInMemory(true)
                .build();

    }

    @Override
    public int getCount() {
        if (imageUrls == null) {
            return 0;
        }
        return imageUrls.length;
    }

    @Override
    public Object getItem(int position) {
        if (imageUrls == null || position > imageUrls.length - 1) {
            return null;
        }
        return imageUrls[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_view_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.ivCar = (ImageView) convertView.findViewById(R.id.iv_car);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        ImageLoader.getInstance().displayImage(imageUrls[position], viewHolder.ivCar, options);

        return convertView;
    }


    static class ViewHolder {
        ImageView ivCar;
    }
}
