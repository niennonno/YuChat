package com.mapplinks.yuchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;
import com.parse.ParseUser;

public class ContactsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "QiJzIEgWWDOyAgL4gF8SjG5MYqj4ojgbn1Mp1oW2", "25w0GwzuYyjokR6DFxD6UVtOq3pJ7iOMsOvQx8L1");

        if (ParseUser.getCurrentUser() == null) {
            Intent i = new Intent(this, SignInActivity.class);
            startActivity(i);
        }
      
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ContactsFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contacts, menu);
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
