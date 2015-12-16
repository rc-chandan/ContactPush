package com.androidzippers.contactpush;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void onClickLogin(View view){

        EditText editText = (EditText)findViewById(R.id.loginId);
        String loginId = editText.getText().toString();
        editText = (EditText)findViewById(R.id.password);
        String password = editText.getText().toString();

        //send the id and password to server and get other details if available otherwise toast login failed.

        //server side authentication and profile retrieval.

        //get response from server which includes the all the user data.
        if(loginId.equals("8908389654") && password.equals("abc123")){
            String name = "Chandan kumar"; //will be assigned according to the response from server.
            String empid = "848404"; //will be assigned according to the response from server.
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra("loggedin", true);
            intent.putExtra("name", name);
            intent.putExtra("empid", empid);
            intent.putExtra("phone", loginId);
            startActivity(intent);
        }else {
            Toast.makeText(getApplicationContext(), "Login failed try again :(", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickSignUp(View view){
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }
}
