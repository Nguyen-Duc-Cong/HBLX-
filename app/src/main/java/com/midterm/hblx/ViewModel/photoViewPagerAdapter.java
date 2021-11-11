package com.midterm.hblx.ViewModel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.hblx.Model.Photo;
import com.midterm.hblx.R;

import java.util.List;

public class photoViewPagerAdapter extends RecyclerView.Adapter<photoViewPagerAdapter.PhotoViewHolder>{

    private List<Photo> mListPhoto;

    public photoViewPagerAdapter(List<Photo> mListPhoto) {
        this.mListPhoto = mListPhoto;
    }


    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent,false);

        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        Photo photo = mListPhoto.get(position);
        if(photo == null){
            return;
        }
        holder.imgPhoto.setImageResource(photo.getResourceID());
    }

    @Override
    public int getItemCount() {
        if(mListPhoto!= null){
            return mListPhoto.size();
        }
        return 0;
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgPhoto;


        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_photo);
        }
    }
}
