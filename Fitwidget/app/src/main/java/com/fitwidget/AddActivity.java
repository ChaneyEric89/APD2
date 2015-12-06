package com.fitwidget;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RelativeLayout;

/**
 * Created by eric chaney on 12/3/15.
 */
public class AddActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_layout);

        RelativeLayout add = (RelativeLayout) findViewById(R.id.add_layout1);
        add.setBackgroundResource(R.drawable.dumbellstwo);


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        //Add Exercise fragment
        //ButtonFrag fragment = new ButtonFrag();

        //Add List fragment
        //ListFrag listFrag = new ListFrag();

//        fragmentTransaction.add(R.id.frameLayout, fragment);
//        fragmentTransaction.add(R.id.frameLayout_two, fragment);
//        fragmentTransaction.commit();




    }




}
