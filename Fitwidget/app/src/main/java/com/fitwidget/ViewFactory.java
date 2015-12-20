package com.fitwidget;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Created by eric chaney on 12/16/15.
 */
public class ViewFactory implements RemoteViewsService.RemoteViewsFactory {
    private static final int ID_CONSTANT = 0x0101010;
    private Context mContext;

    private Context context;
    BodyPart bodyPart;
    String findBodyPart;

    public ArrayList<Saved> entriesList;
    public ArrayList<String> workoutList;
    RemoteViews itemRemoteV;
    Application application;


    public ViewFactory(Context context) {
        mContext = context;

        if(bodyPart == null){
            bodyPart = new BodyPart();
        }

    }


    @Override
    public void onCreate() {

        if(bodyPart == null){
            bodyPart = new BodyPart();
        }

         //application = (Application)BodyPart.getContext();
         //bodyPart = (BodyPart)application;

        if(entriesList == null){
            entriesList = new ArrayList<Saved>();
        }

        if(workoutList == null) {
            workoutList = new ArrayList<String>();
        }

//        try {
//
//
//            FileInputStream fin = mContext.openFileInput("entries.dat");
//
//
//            ObjectInputStream oin = new ObjectInputStream(fin);
//            entriesList = (ArrayList<Saved>) oin.readObject();
//
//            oin.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        createWorkout(setBodyPart());

    }


    @Override
    public void onDataSetChanged() {

        findBodyPart = setBodyPart();
       // itemRemoteV = null;
        workoutList = null;

        try {


            FileInputStream fin = mContext.openFileInput("entries.dat");

            ObjectInputStream oin = new ObjectInputStream(fin);
            entriesList = (ArrayList<Saved>)oin.readObject();

            oin.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


       // if(findBodyPart != null) {
            createWorkout(findBodyPart);
       // }
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        if(workoutList != null) {
            return workoutList.size();
        } else{
            return 0;
        }
    }

    @Override
    public RemoteViews getViewAt(int position) {
//        if(workoutList != null) {
            itemRemoteV = new RemoteViews(mContext.getPackageName(), R.layout.widget_item);

            itemRemoteV.setTextViewText(R.id.title, workoutList.get(position));
        //itemRemoteV.setTextViewText(R.id.third_Title, entriesList.get(position).sBodyPart);


            Intent intent = new Intent();
            intent.putExtra(Provider.EXTRA_ITEM, workoutList.get(position));
            itemRemoteV.setOnClickFillInIntent(R.id.widget_item, intent);
//        }
        return itemRemoteV;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }



    public String setBodyPart(){

        if(bodyPart == null){
            bodyPart = new BodyPart();
        }

        if( bodyPart.getInstance().bPart == null){
            String x = "Chest";
            return x;
        }else {
            String x = bodyPart.getInstance().bPart;
            return x;
        }



//        if(bodyPart.getState() == null){
//            String x = "Chest";
//            return x;
//        }else {
//            String x = bodyPart.getState();
//            return x;
//        }

    }

public void createWorkout(String part){

       // if (entriesList != null) {
    workoutList = null;
    workoutList = new ArrayList<String>();
            for (int i = 0; i < entriesList.size(); i++) {
                if(entriesList.get(i).sBodyPart.equals(part)) {
                    workoutList.add(entriesList.get(i).sExercise);
                } //else{
                  //  workoutList.add("EMPTY");
                //}
            }
       // }

    }

}
