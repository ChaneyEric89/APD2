package com.fitwidget;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;

/**
 * Created by eric chaney on 12/09/15.
 */
public class BuildActivity extends Activity {

    BodyPart bodyPart;
    Application application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bodyPart = new BodyPart();

//        application = (Application)BodyPart.getContext();
//        bodyPart = (BodyPart)application;

        setContentView(R.layout.build_layout);

        new ViewFactory(BuildActivity.this);


        RelativeLayout main = (RelativeLayout) findViewById(R.id.build_layout1);
        main.setBackgroundResource(R.drawable.dumbellstwo);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        //Add button fragment
        BuildFrag fragment = new BuildFrag();
        fragmentTransaction.add(R.id.build_container, fragment);
        fragmentTransaction.commit();

    }



    public void getBodyPart(String x){
        bodyPart = new BodyPart();

        bodyPart.getInstance().bPart = x;

        //bodyPart.setState(x);

    }

    public void refreshWidget(){
        //Update home screen widget
        Context context = getApplicationContext();
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        ComponentName thisWidget = new ComponentName(context, Provider.class);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.entries_list);

    }



}
