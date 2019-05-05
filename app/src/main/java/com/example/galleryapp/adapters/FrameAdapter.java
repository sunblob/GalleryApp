package com.example.galleryapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.galleryapp.R;
import com.example.galleryapp.models.Frame;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class FrameAdapter extends RecyclerView.Adapter<FrameAdapter.FrameHolder> {

    private List<Frame> frameList;

    public FrameAdapter(List<Frame> frameList) {
        this.frameList = frameList;
    }

    @NonNull
    @Override
    public FrameHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frame_item, viewGroup, false);
        return new FrameHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FrameHolder frameHolder, int i) {

        final int position = frameHolder.getAdapterPosition();
        frameHolder.textViewFrame.setText(frameList.get(position).getTitle());
        frameHolder.imageViewFrame.setImageURI(frameList.get(position).getPicture());
        frameHolder.cardViewFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return frameList.size();
    }

    class FrameHolder extends RecyclerView.ViewHolder{

        private SimpleDraweeView imageViewFrame;
        private CardView cardViewFrame;
        private TextView textViewFrame;

        public FrameHolder(@NonNull View itemView) {
            super(itemView);
            imageViewFrame = itemView.findViewById(R.id.simpleDraweeViewFrame);
            cardViewFrame = itemView.findViewById(R.id.cardViewFrame);
            textViewFrame = itemView.findViewById(R.id.textViewFrame);
        }
    }
}
