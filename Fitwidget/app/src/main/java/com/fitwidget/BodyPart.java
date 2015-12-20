package com.fitwidget;

/**
 * Created by eric chaney on 12/17/15.
 */


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