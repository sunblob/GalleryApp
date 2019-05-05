package com.example.galleryapp.uis;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.galleryapp.R;

public class FragmentMain extends Fragment {

    private Button buttonGoToCategory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        buttonGoToCategory = view.findViewById(R.id.buttonGoToCategory);

        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Выбери рамку");
        goToCategory();
        return view;
    }

    private void goToCategory(){
        buttonGoToCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SelectCategoryActivity.class);
                startActivity(intent);
            }
        });
    }


}
