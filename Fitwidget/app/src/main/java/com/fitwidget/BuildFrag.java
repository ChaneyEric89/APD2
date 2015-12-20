package com.fitwidget;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by ericchaney on 12/10/15.
 */
public class BuildFrag extends Fragment implements AdapterView.OnItemSelectedListener{

    Spinner buildSpinner;
    Button finishBuild;
    String buildBodyPart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.build_frag, container, false);

        buildSpinner = (Spinner) view.findViewById(R.id.select_build);
        buildSpinner.setOnItemSelectedListener(this);

        finishBuild = (Button) view.findViewById(R.id.final_button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.body_parts, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        buildSpinner.setAdapter(adapter);


        finishBuild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                ((BuildActivity) getActivity()).refreshWidget();

            }
        });


        return view;
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        //buildBodyPart = (String) parent.getItemAtPosition(position);
        buildBodyPart = parent.getItemAtPosition(position).toString();

        ((BuildActivity) getActivity()).getBodyPart(buildBodyPart);

        Toast.makeText(getActivity(), (CharSequence) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
