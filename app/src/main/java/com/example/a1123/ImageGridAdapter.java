package com.example.a1123;

import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageGridAdapter extends RecyclerView.Adapter<ImageGridAdapter.ViewHolder> {
    private final List<Integer> images;

    public ImageGridAdapter(List<Integer> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageView image = new ImageView(parent.getContext());
        int size = parent.getResources().getDisplayMetrics().widthPixels / 2;
        image.setLayoutParams(new ViewGroup.LayoutParams(size, size));
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new ViewHolder(image);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView;
        }
    }
}
