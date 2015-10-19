package com.mapplinks.yuchat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        getting the phone number
//
//        TelephonyManager telephonyManager = (TelephonyManager)this.getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
//        String phoneNumber = telephonyManager.getLine1Number();

        EditText userNumber = (EditText)findViewById(R.id.user_number);
//        userNumber.setText(phoneNumber);



    }

}
