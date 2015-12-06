package com.fitwidget;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by eric chaney on 12/3/15.
 */
public class ButtonFrag extends Fragment {

    ImageButton imageBtnAdd, imageBtnBuild;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.button_frag, container, false);

        //Add Exercise button
        imageBtnAdd =(ImageButton)  view.findViewById(R.id.imageBtn_add);
        //Build Workout button
        imageBtnBuild = (ImageButton) view.findViewById(R.id.imageBtn_build);

        imageBtnAdd.setImageResource(R.drawable.add_btn);
        imageBtnBuild.setImageResource(R.drawable.build_btn);



        //Open add exercise activity
        imageBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), AddActivity.class);

                getActivity().startActivity(intent);

            }
        });


        //Fire Alert to select body part for workout

        imageBtnBuild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Add code for Build Alert here....


            }
        });





        return view;



    }
}
