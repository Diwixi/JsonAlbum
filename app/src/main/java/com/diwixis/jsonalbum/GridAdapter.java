package com.diwixis.jsonalbum;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diwixis on 27.10.2017.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {

    private List<String> imageList = new ArrayList<>();
    private int width = 0;

    public void setData(List<String> list, int width){
        imageList = list;
        this.width = width/2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String image = imageList.get(position);
        Glide.with(holder.image.getContext())
            .load(image)
            .override(width, width)
            .centerCrop()
            .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return imageList == null ? 0 : imageList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_item);
        }
    }
}
