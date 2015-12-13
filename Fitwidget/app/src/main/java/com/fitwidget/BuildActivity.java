package com.fitwidget;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RelativeLayout;

/**
 * Created by eric chaney on 12/09/15.
 */
public class BuildActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.build_layout);


        RelativeLayout main = (RelativeLayout) findViewById(R.id.build_layout1);
        main.setBackgroundResource(R.drawable.dumbellstwo);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        //Add button fragment
        BuildFrag fragment = new BuildFrag();
        fragmentTransaction.add(R.id.build_container, fragment);
        fragmentTransaction.commit();

    }


}
