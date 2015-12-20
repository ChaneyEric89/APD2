package com.fitwidget;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by ericchaney on 12/09/15.
 */
public class ListFrag extends ListFragment implements AdapterView.OnItemLongClickListener{

    ListView lv;

    public ArrayList<Saved> entriesList;
    public ArrayList<String> entriesForAdapter;
    public ArrayAdapter<String> adapter;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        if(entriesForAdapter == null) {
            entriesForAdapter = new ArrayList<String>();
        }

        if(entriesList == null){
            entriesList = new ArrayList<Saved>();
        }

        try {


            FileInputStream fin = getActivity().openFileInput("entries.dat");


            ObjectInputStream oin = new ObjectInputStream(fin);
            entriesList = (ArrayList<Saved>) oin.readObject();

            oin.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




        if(entriesList != null) {
            for (int i = 0; i < entriesList.size(); i++) {

                entriesForAdapter.add(entriesList.get(i).sExercise);

            }
        }

        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, entriesForAdapter));
        lv = getListView();
        //lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);
        adapter = (ArrayAdapter<String>) lv.getAdapter();


    }




    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        Log.i("FragmentList", "Item clicked: " + id);
        entriesForAdapter.remove(entriesForAdapter.get(position));
        entriesList.remove(position);
        //entriesForAdapter.notifyDataSetChanged();
        adapter.notifyDataSetChanged();
        saveToFile();

        return false;
    }




    public  void saveToFile() {

        try {

            FileOutputStream fos = getActivity().openFileOutput("entries.dat", getActivity().MODE_PRIVATE);

            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(entriesList);

            oos.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}


