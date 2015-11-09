package com.simdetails.uzair.simdetails;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtSimNumber;
    private TextView txtSimSerial;
    private TextView txtImeiNumber;
    private TextView txtNetworkInfo;
    private TextView txtCallState;
    private TextView txtCellLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtSimNumber = (TextView) findViewById(R.id.txt_mobile_number);
        txtSimSerial = (TextView) findViewById(R.id.txt_sim_serial);
        txtImeiNumber = (TextView) findViewById(R.id.txt_imei_number);
        txtNetworkInfo = (TextView) findViewById(R.id.txt_network_info);



//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        setUpFields();




    }

    private void setUpFields() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        if (telephonyManager.getSimSerialNumber() != null){
            txtSimSerial.setText( telephonyManager.getSimSerialNumber().toString());
        }

        if (telephonyManager.getLine1Number() != null){
            txtSimNumber.setText(telephonyManager.getLine1Number());
        }

        if (telephonyManager.getDeviceId() != null){
            txtImeiNumber.setText(telephonyManager.getDeviceId());
        }

        if (telephonyManager.getNetworkOperatorName() != null){
            txtNetworkInfo.setText(telephonyManager.getNetworkOperatorName());
        }




    }

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
}
