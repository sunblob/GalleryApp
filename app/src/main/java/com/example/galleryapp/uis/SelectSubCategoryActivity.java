package com.example.galleryapp.uis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.galleryapp.R;
import com.example.galleryapp.adapters.SubCategoryAdapter;
import com.example.galleryapp.models.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class SelectSubCategoryActivity extends AppCompatActivity {

    private List<SubCategory> subCategories = new ArrayList<>();
    private Intent intent;
    private RecyclerView recyclerViewSubCategory;
    private SubCategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_sub_category);
        setRecyclerViewSubCategory();
        getToolbarToWork();
    }

    private void getCategoryId(){
        intent = getIntent();
        int result = intent.getIntExtra("id", 0);

        switch (result){
            case 0:
                subCategories.clear();
                subCategories.add(new SubCategory(0, "1"));
                subCategories.add(new SubCategory(1, "2"));
                subCategories.add(new SubCategory(2, "3"));
                subCategories.add(new SubCategory(3, "4"));
                break;
            case 1:
                subCategories.clear();
                subCategories.add(new SubCategory(0, "5"));
                subCategories.add(new SubCategory(1, "6"));
                subCategories.add(new SubCategory(2, "7"));
                subCategories.add(new SubCategory(3, "8"));
                break;
            case 2:
                subCategories.clear();
                subCategories.add(new SubCategory(0, "9"));
                subCategories.add(new SubCategory(1, "10"));
                subCategories.add(new SubCategory(2, "11"));
                subCategories.add(new SubCategory(3, "11"));
                break;
        }
    }

    private void setRecyclerViewSubCategory(){
        recyclerViewSubCategory = findViewById(R.id.recyclerViewSubCategory);
        getCategoryId();
        adapter = new SubCategoryAdapter(subCategories);
        recyclerViewSubCategory.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewSubCategory.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void getToolbarToWork(){
        Toolbar toolbar = findViewById(R.id.toolbarSubCategory);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Подкатегории");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
