package com.mapplinks.yuchat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignInActivity extends AppCompatActivity {

    private EditText mUserNumber;
    private EditText mPassword;
    private EditText mName;

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

        mUserNumber = (EditText)findViewById(R.id.user_number);
//        mUserNumber.setText(phoneNumber);
        mPassword = (EditText)findViewById(R.id.user_password);
        mName = (EditText)findViewById(R.id.user_name);

        Button logInButton = (Button)findViewById(R.id.log_in_button);
        Button signUpButton = (Button)findViewById(R.id.sign_up_button);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = mUserNumber.getText().toString();
                String password = mPassword.getText().toString();

                ParseUser user = new ParseUser();
                user.setUsername(phoneNumber);
                user.setPassword(password);
                user.put("name", mName.getText().toString());


                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(SignInActivity.this, "Signed Up!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignInActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logInInBackground(mUserNumber.getText().toString(),
                        mPassword.getText().toString(),
                        new LogInCallback() {
                            @Override
                            public void done(ParseUser parseUser, ParseException e) {
                                if (e == null) {
                                    Toast.makeText(SignInActivity.this, "Signed Up!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(SignInActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

}
