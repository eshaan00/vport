package com.project.esh_an.vemanafeeportal;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.project.esh_an.vemanafeeportal.activity.InitialScreenActivity;
import com.project.esh_an.vemanafeeportal.add_on.netConnection;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class rentdetails extends AppCompatActivity {

    Button ok;
    private EditText roomnum,usn,amt;
    private Spinner semester;
    ArrayAdapter<CharSequence> adapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rentdetails);


        //net connection
        netConnection checkCon=new netConnection(this);
        if(checkCon.isConnected()==false){
            new AlertDialog.Builder(this)
                    .setTitle("WARNING")
                    .setMessage("No Internet Connection!!\n\nEnable it..!!!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(Settings.ACTION_SETTINGS);
                            startActivity(intent);
                        }
                    })
                    .show();
        }

            roomnum = (EditText) findViewById(R.id.roomnum);
            usn = (EditText) findViewById(R.id.usn);
            amt = (EditText) findViewById(R.id.amt);

            ok = (Button) findViewById(R.id.button2);

            semester = (Spinner)findViewById(R.id.spinner);



            adapter = ArrayAdapter.createFromResource(this,R.array.semester,android.R.layout.simple_spinner_item);
            semester.setAdapter(adapter);


            semester.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    if(i>0) {

                        Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i) + " selected", Toast.LENGTH_LONG).show();
                    }
                    else{}

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(rentdetails.this, InitialScreenActivity.class);
                    i.putExtra("EditText",amt.getText().toString());
                    startActivity(i);
                    finishActivity(0);
                }
            });

        }
    @Override
    protected void onResume() {
        super.onResume();
        netConnection checkCon=new netConnection(this);
        if(checkCon.isConnected()==false){
            new AlertDialog.Builder(this)
                    .setTitle("WARNING")
                    .setMessage("No Internet Connection!!\n\nEnable it..!!!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(Settings.ACTION_SETTINGS);
                            startActivity(intent);
                        }
                    })
                    .show();
        }

    }
    }

