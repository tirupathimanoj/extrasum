package com.avium.extrasum;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Creation_of_group extends AppCompatActivity {

    boolean bflag = true;//declare it as public
    @BindView(R.id.show_dialog_one)
    ImageView showDialogOne;
    @BindView(R.id.show_dialog_two)
    ImageView showDialogTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_of_group);
        ButterKnife.bind(this);
        // Get reference of widgets from XML layout
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
//        CustomSpinner customSpinner=new CustomSpinner(spinner) {
//            @Override
//            public void onOpen() {
//                Toast.makeText(getApplicationContext(),"Hii",Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onClose() {
//                Toast.makeText(getApplicationContext(),"Bye",Toast.LENGTH_LONG).show();
//
//            }
//        };

        // Initializing a String Array
        String[] plants = new String[]{
                "Initial Investment",
                "California sycamore",
                "Mountain mahogany",
                "Butterfly weed",
                "Carrot weed"
        };
        final List<String> plantsList = new ArrayList<>(Arrays.asList(plants));

        // Initializing an ArrayAdapter
        final ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.spinner_item, plantsList) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            @Override
            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }
        };
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(spinnerArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    Toast.makeText
                            (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                            .show();
                } else {

                    Toast.makeText
                            (getApplicationContext(), "nothing", Toast.LENGTH_SHORT)
                            .show();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText
                        (getApplicationContext(), parent.toString(), Toast.LENGTH_SHORT)
                        .show();

            }
        });

    }


    @OnClick({R.id.show_dialog_one, R.id.show_dialog_two})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.show_dialog_one:

                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = inflater.inflate(R.layout.bottomdialog_layout, null);


                break;
            case R.id.show_dialog_two:
                break;
        }
    }
}
