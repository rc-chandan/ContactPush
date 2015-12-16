package com.androidzippers.contactpush;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


public class ChooseMode extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mode);

    }

    private RadioButton sms, email, bluetooth, contactPushShare;
    private RadioGroup radioGroup;
    int selectedRadioButtonId;
    public void onCLickShare(View view){
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        sms = (RadioButton)findViewById(R.id.sms);
        email = (RadioButton)findViewById(R.id.email);
        bluetooth = (RadioButton)findViewById(R.id.bluetooth);
        contactPushShare = (RadioButton)findViewById(R.id.contactPushShare);

        // writing vcf file to SD card.
        String filename = "contacts.vcf";
        File file = new File(getApplicationContext().getExternalFilesDir(null), filename);

        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(file);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream);
            writer.write("BEGIN:VCARD\r\n");
            writer.write("VERSION:3.0\r\n");
            writer.write("N:" + "Admin" + ";" + "ContactPush" + "\r\n");
            writer.write("FN:" + "ContactPush" + " " + "Admin" + "\r\n");
            writer.write("ORG:" + "TCS" + "\r\n");
            writer.write("TITLE:" + "Assistant Software Engineer" + "\r\n");
            writer.write("TEL;TYPE=MOBILE,VOICE:" + "+918147530172"+ "\r\n");
            writer.write("TEL;TYPE=WORK,VOICE:" + ""+ "\r\n");
            writer.write("TEL;TYPE=HOME,VOICE:" + "+918908389654" + "\r\n");
            writer.write("ADR;TYPE=WORK:;;" + "" + ";" + "Bangalore" + ";" + "" + ";" + "560037" + ";" + "India" + "\r\n");
            writer.write("EMAIL;TYPE=PREF,INTERNET:" + "chandan.rana@tcs.com" + "\r\n");
            writer.write("NOTE:" + "Send using ContactPush." + "\r\n");
            writer.write("END:VCARD\r\n");
            writer.close();
            outputStream.close();
            Toast.makeText(getApplicationContext(), file.toString(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        //Handling the sharing method
        if(selectedRadioButtonId == sms.getId()){
            //open sms compose activity of android and pass sms body.
            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.putExtra("sms_body", "Name = Chandan, Number = 8908389654");
            sendIntent.setType("vnd.android-dir/mms-sms");
            startActivity(sendIntent);
        }else if(selectedRadioButtonId == email.getId()){
            //Open android email intent and pass email body and subject.
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","", null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "ContactPush shared contacts");
            emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            startActivity(Intent.createChooser(emailIntent, "Send email..."));


        }else if(selectedRadioButtonId == bluetooth.getId()){
            //turn on bluetooth and share
            BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
            if (btAdapter == null) {
                Toast.makeText(getApplicationContext(), "Bluetooth not supported choose other mode.", Toast.LENGTH_SHORT).show();
            }else{
                // bring up Android chooser
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/x-vcard");
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
                startActivity(intent);
            }

        }else if (selectedRadioButtonId == contactPushShare.getId()){
            //Send the file to the server
        }else {
            Toast.makeText(getApplicationContext(), "Please select a sharing mode.", Toast.LENGTH_SHORT).show();
        }
    }

}