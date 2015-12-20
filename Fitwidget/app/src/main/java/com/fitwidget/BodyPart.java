package com.fitwidget;

/**
 * Created by eric chaney on 12/19/15.
 */
//public class BodyPart extends Application {
//
//    private static Context appContext;
//
//    public String bodyPart;
//
//    public String getState(){
//        return bodyPart;
//    }
//    public void setState(String input){
//        this.bodyPart = input;
//    }
//
//    public static Context getContext(){
//        return appContext;
//    }
//
//
//}

public class BodyPart {
    private static BodyPart mInstance= null;

    public String bPart;

    protected BodyPart(){}

    public static synchronized BodyPart getInstance(){
        if(null == mInstance){
            mInstance = new BodyPart();
        }
        return mInstance;
    }
}