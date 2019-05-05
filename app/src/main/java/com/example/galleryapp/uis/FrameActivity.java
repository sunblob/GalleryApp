package com.example.galleryapp.uis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.galleryapp.R;
import com.example.galleryapp.adapters.FrameAdapter;
import com.example.galleryapp.models.Frame;

import java.util.ArrayList;
import java.util.List;

public class FrameActivity extends AppCompatActivity {

    private List<Frame> frameList = new ArrayList<>();
    private RecyclerView recyclerViewFrame;
    private FrameAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        getToolbarToWork();
        setRecyclerViewFrame();
    }

    private void getToolbarToWork(){
        Toolbar toolbar = findViewById(R.id.toolbarCategory);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Рамки");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void getSubCategoryId(){
        Intent intent = getIntent();
        int result = intent.getIntExtra("subId", 0);

        switch (result){
            case 0:
                frameList.clear();
                frameList.add(new Frame(0, "https://3.bp.blogspot.com/-6KsJROAUNEA/VgUrfHZ4kXI/AAAAAAAARNE/KDHatQwPaZo/s1600/%25D0%25A0%25D0%25B0%25D0%25BC%25D0%25BA%25D0%25B8%2BPng%2B%25D1%2587%25D0%25B0%25D1%2581%25D1%2582%25D1%258C%2B2%2B%2528%25D0%25BA%25D0%25B2%25D0%25B0%25D0%25B4%25D1%2580%25D0%25B0%25D1%2582%25D0%25BD%25D1%258B%25D0%25B5%2B%25D0%25B8%2B%25D0%25BF%25D1%2580%25D1%258F%25D0%25BC%25D0%25BE%25D1%2583%25D0%25B3%25D0%25BE%25D0%25BB%25D1%258C%25D0%25BD%25D1%258B%25D0%25B5%2B%25D1%2586%25D0%25B2%25D0%25B5%25D1%2582%25D0%25BE%25D1%2587%25D0%25BD%25D1%258B%25D0%25B5%2B%25D1%2580%25D0%25B0%25D0%25BC%25D0%25BA%25D0%25B8%2529.png", "рамка 1"));
                break;
        }
    }

    private void setRecyclerViewFrame(){
        getSubCategoryId();
        recyclerViewFrame = findViewById(R.id.recyclerViewFrame);
        adapter = new FrameAdapter(frameList);
        recyclerViewFrame.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerViewFrame.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
