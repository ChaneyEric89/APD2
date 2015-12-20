package com.fitwidget;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by eric chaney on 12/09/15.
 */
public class AddFrag extends Fragment implements AdapterView.OnItemSelectedListener{

    Spinner addSpinner;
    EditText exerciseEntry;
    Button addExercise;
    String newExercise, newBodyPart;

    //BodyPart bodyPart;

    public String entriesFile;
    public Saved saved;

    ArrayList<Saved>entriesArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.add_frag, container, false);



        entriesArrayList = new ArrayList<Saved>();

        if (saved == null) {

            saved = new Saved();
        }

        if(entriesFile == null){
            entriesFile = "entries.dat";
        }



        exerciseEntry = (EditText) view.findViewById(R.id.editText);
        addExercise = (Button)  view.findViewById(R.id.add_exercise_button);

        addSpinner = (Spinner) view.findViewById(R.id.add_spinner);
        addSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.body_parts, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        addSpinner.setAdapter(adapter);

        addExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(entriesArrayList != null) {

                    readFromFIle();

                }

              newExercise = exerciseEntry.getText().toString();
                //Toast.makeText(getActivity(), newExercise, Toast.LENGTH_SHORT).show();

                saved = new Saved(newBodyPart, newExercise);

                entriesArrayList.add(saved);

                if(newBodyPart.equals("Body Part")){

                    Toast.makeText(getActivity(), "Select Body Part", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getActivity(), newBodyPart, Toast.LENGTH_SHORT).show();
                    saveToFile();

                }


                exerciseEntry.setText("");


//                ((AddActivity) getActivity()).refreshWidget();
                ((AddActivity) getActivity()).refreshListFrag();

            }
        });



        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        newBodyPart = (String) parent.getItemAtPosition(position);




       // Toast.makeText(getActivity(), newBodyPart, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void readFromFIle(){
        try {

            FileInputStream fin = getActivity().openFileInput("entries.dat");

            ObjectInputStream oin = new ObjectInputStream(fin);
            entriesArrayList = (ArrayList<Saved>) oin.readObject();

            oin.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public  void saveToFile(){

        try {

            FileOutputStream fos = getActivity().openFileOutput(entriesFile, getActivity().MODE_PRIVATE);

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(entriesArrayList);

            oos.close();

        }
        catch (IOException e) {
            e.printStackTrace();

        }


    }




}
