package com.rashem8432.experience;

import android.content.Intent;
import android.location.Location;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import java.text.DateFormat;
import java.util.Date;


public class MainActivity extends ActionBarActivity {


    protected ImageButton maddexpbutton;
    protected ImageButton configure_button;
    protected ImageButton white_rabbit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        start_gps_poller();
        updateValuesFromBundle(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);

        white_rabbit_button=(ImageButton) this.findViewById(R.id.buttons_rabbit);
        maddexpbutton=(ImageButton) this.findViewById(R.id.buttons_addexp);
        configure_button=(ImageButton) this.findViewById(R.id.buttons_configure);

        white_rabbit_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //open_white_rabbit1("wahey");

                try {
                    updateTextView(String.valueOf(asdf.location.getLatitude()));
                }catch (Exception e) {

                }


            }

        });
        maddexpbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
open_add_exp1("yoohoo");

            }
        });
        configure_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                open_config1("floop");
            }
        });
    }



    private void open_white_rabbit1(String wop) {
        Intent myIntent = new Intent(this,white_rabbit_activity1.class);
        String value=wop;
        myIntent.putExtra("key", value); //Optional parameters
        startActivity(myIntent);

    }
    private void open_add_exp1(String yoohoo) {
        Intent myIntent = new Intent(this,add_exp_act1.class);
        String value=yoohoo;
        myIntent.putExtra("key", value); //Optional parameters
        startActivity(myIntent);

    }
    private void open_config1(String floop) {
        Intent myIntent = new Intent(this,config_act1.class);
        String value=floop;
        myIntent.putExtra("key", value); //Optional parameters
        startActivity(myIntent);

    }
    private void start_gps_poller(){
        startService(new Intent(this, gps_poller.class));
    };
    @Override
    protected void onStart() {
        super.onStart();
        start_gps_poller();
    }
    @Override
    protected void onStop() {
        super.onStop();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
/*
    @Override
    protected void onResume() {
        super.onResume();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
*/



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }




    private void updateValuesFromBundle(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            // Update the value of mRequestingLocationUpdates from the Bundle, and
            // make sure that the Start Updates and Stop Updates buttons are
            // correctly enabled or disabled.
          /*  if (savedInstanceState.keySet().contains(REQUESTING_LOCATION_UPDATES_KEY)) {
                mRequestingLocationUpdates = savedInstanceState.getBoolean(
                        REQUESTING_LOCATION_UPDATES_KEY);
                //setButtonsEnabledState();
            }

            // Update the value of mCurrentLocation from the Bundle and update the
            // UI to show the correct latitude and longitude.
            if (savedInstanceState.keySet().contains(LOCATION_KEY)) {
                // Since LOCATION_KEY was found in the Bundle, we can be sure that
                // mCurrentLocationis not null.
                mCurrentLocation = savedInstanceState.getParcelable(LOCATION_KEY);
            }

            // Update the value of mLastUpdateTime from the Bundle and update the UI.
            if (savedInstanceState.keySet().contains(LAST_UPDATED_TIME_STRING_KEY)) {
                mLastUpdateTime = savedInstanceState.getString(
                        LAST_UPDATED_TIME_STRING_KEY);
            }*/
            //updateUI();
        }}

        /**
         * Stores activity data in the Bundle.
         */
        public void onSaveInstanceState(Bundle savedInstanceState) {
   /*         savedInstanceState.putBoolean(REQUESTING_LOCATION_UPDATES_KEY, mRequestingLocationUpdates);
            savedInstanceState.putParcelable(LOCATION_KEY, mCurrentLocation);
            savedInstanceState.putString(LAST_UPDATED_TIME_STRING_KEY, mLastUpdateTime);*/
            super.onSaveInstanceState(savedInstanceState);
        }



    public void updateTextView(String toThis) {

        TextView textView = (TextView) findViewById(R.id.hello_text);
        textView.setText(toThis);

        return;
    }
}
