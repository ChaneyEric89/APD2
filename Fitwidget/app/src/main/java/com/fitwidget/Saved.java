package com.fitwidget;

import java.io.Serializable;

/**
 * Created by eric chaney on 12/3/15.
 */



public class Saved implements Serializable {
        private static final long serialVersionUID = 8736847634070552888L;

        public String sBodyPart;
        public String sExercise;


        public Saved(){
            sBodyPart = "";
            sExercise = "";

        }

        public Saved(String bodyPart, String exercise){
            sBodyPart = bodyPart;
            sExercise = exercise;

        }


    }



