package com.example.galleryapp.adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.galleryapp.R;
import com.example.galleryapp.models.Category;
import com.example.galleryapp.uis.SelectSubCategoryActivity;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<Category> categories = new ArrayList<>();

    public CategoryAdapter(List<Category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_item, viewGroup, false);
        CategoryViewHolder holder = new CategoryViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        final int position = categoryViewHolder.getAdapterPosition();
        categoryViewHolder.textViewCategory.setText(categories.get(i).getTitle());
        categoryViewHolder.cardViewCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "" + categories.get(position).getId(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), SelectSubCategoryActivity.class);
                intent.putExtra("id", categories.get(position).getId());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (categories != null){
            return categories.size();
        } else return 0;
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewCategory;
        private CardView cardViewCategory;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCategory = itemView.findViewById(R.id.textViewCategory);
            cardViewCategory = itemView.findViewById(R.id.cardViewCategory);
        }
    }
}
