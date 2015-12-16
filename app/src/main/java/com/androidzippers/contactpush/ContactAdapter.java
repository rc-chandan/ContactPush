package com.androidzippers.contactpush;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chandan on 09-Jun-15.
 */
public class ContactAdapter extends ArrayAdapter{

    ArrayList<ContactItem> contactList = null;
    Context context;

    public ContactAdapter(Context context, ArrayList<ContactItem> contactList) {
        super(context, R.layout.layout_contact_row, contactList);
        this.context = context;
        this.contactList = contactList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.layout_contact_row, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.contactName);
        CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox);
        name.setText(contactList.get(position).getFirstName());
        cb.setActivated(contactList.get(position).getFlag() == 1? true:false);
        if (contactList.get(position).getFlag() == 1) {
            cb.setChecked(true);
        }else{
            cb.setChecked(false);
        }
        return convertView;
    }
}