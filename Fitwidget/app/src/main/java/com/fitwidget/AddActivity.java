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
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;

    BodyPart bodyPart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_layout);

        RelativeLayout add = (RelativeLayout) findViewById(R.id.add_layout1);
        add.setBackgroundResource(R.drawable.dumbellstwo);


         fragmentManager = getFragmentManager();
         fragmentTransaction = fragmentManager.beginTransaction();


        //Add Exercise fragment
        AddFrag fragment = new AddFrag();

        fragmentTransaction.add(R.id.frameLayout, fragment);

        fragmentTransaction.commit();

        refreshListFrag();


    }

    //Add List fragment
    public void refreshListFrag(){
        fragmentTransaction = fragmentManager.beginTransaction();
        ListFrag listFrag = new ListFrag();
        fragmentTransaction.replace(R.id.frameLayout_two, listFrag);
        fragmentTransaction.commit();
    }



}
