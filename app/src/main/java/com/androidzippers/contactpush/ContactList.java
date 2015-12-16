package com.androidzippers.contactpush;

import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ContactList extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        Intent intent = getIntent();

        if(intent.getBooleanExtra("loggedin", false)) {
            final ListView listView = (ListView) findViewById(R.id.listView);

            final ArrayList<ContactItem> contactList = new ArrayList<ContactItem>();

            Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            while (cursor.moveToNext()) {

                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                String lastName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.StructuredName.FAMILY_NAME));

                ContactItem contact = new ContactItem();
                contact.setFirstName(name);
                contact.setTelMobile(phoneNumber);
                contact.setSurName(lastName);

                contactList.add(contact);

            }
            cursor.close();

            final ContactAdapter adapter = new ContactAdapter(this, contactList);
            listView.setAdapter(adapter);
        }else {
            Toast.makeText(getApplicationContext(), "You are not logged in.", Toast.LENGTH_SHORT).show();
            Intent parent = new Intent(this, MainActivity.class);
            startActivity(parent);
        }
    }



    public void onClickNext(View view){
        Intent intent = new Intent(this, ChooseMode.class);
        startActivity(intent);
    }
}
