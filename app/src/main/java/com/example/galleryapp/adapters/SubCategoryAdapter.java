package com.example.galleryapp.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.galleryapp.R;
import com.example.galleryapp.models.SubCategory;
import com.example.galleryapp.uis.FrameActivity;

import java.util.List;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.SubCategoryHolder> {

    private List<SubCategory> subCategories;

    public SubCategoryAdapter(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    @NonNull
    @Override
    public SubCategoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sub_category_item, viewGroup, false);
        SubCategoryHolder holder = new SubCategoryHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SubCategoryHolder subCategoryHolder, final int i) {
        final int position = subCategoryHolder.getAdapterPosition();
        subCategoryHolder.textViewSubCategory.setText(subCategories.get(position).getSubTitle());
        subCategoryHolder.cardViewSubCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FrameActivity.class);
                intent.putExtra("subId", subCategories.get(position).getSubTitle());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (subCategories != null){
            return subCategories.size();
        } else return 0;
    }

    class SubCategoryHolder extends RecyclerView.ViewHolder{

        private TextView textViewSubCategory;
        private CardView cardViewSubCategory;

        public SubCategoryHolder(@NonNull View itemView) {
            super(itemView);
            textViewSubCategory = itemView.findViewById(R.id.textViewSubCategory);
            cardViewSubCategory = itemView.findViewById(R.id.cardViewSubCategory);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), FrameActivity.class);
                    intent.putExtra("subId", getAdapterPosition());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
