package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class ImageAdoptor extends RecyclerView.Adapter<ImageAdoptor.ImageViewHolder> {

    private List<image> list;
    private ViewPager2 viewPager2;

    public ImageAdoptor(List<image> imageList, ViewPager2 viewPager2){
        this.list = imageList;
        this.viewPager2 = viewPager2;

    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_container,parent,false);

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());

        if (position == list.size()-2){
            viewPager2.post(holder.runnable);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        RoundedImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview);

        }

         private Runnable runnable = new Runnable() {
             @Override
             public void run() {
                 list.addAll(list);
                 notifyDataSetChanged();

             }
         };
    }
}
