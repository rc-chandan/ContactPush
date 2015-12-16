package com.androidzippers.contactpush;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();

        if(intent.getBooleanExtra("loggedin", false)) {
            String name = intent.getStringExtra("name");
            String empid = intent.getStringExtra("empid");
            String phone = intent.getStringExtra("phone");

            TextView textView = (TextView) findViewById(R.id.welcomeText);
            textView.setText("Welcome " + name);
            textView = (TextView) findViewById(R.id.phoneNumber);
            textView.setText("Contact : " + phone);
            textView = (TextView) findViewById(R.id.empId);
            textView.setText("Employee Id : " + empid);
        }else {
            Toast.makeText(getApplicationContext(), "You are not logged in.", Toast.LENGTH_SHORT).show();
            Intent parent = new Intent(this, MainActivity.class);
            startActivity(parent);
        }
    }

    public void onClickSendContact(View view){

        Intent intent = new Intent(this, ContactList.class);
        intent.putExtra("loggedin", true);
        startActivity(intent);
    }

    public void onClickReceiveContact(View view){
        Toast.makeText(getApplicationContext(), "Code not written :(", Toast.LENGTH_SHORT).show();
    }

}
