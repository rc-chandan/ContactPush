package com.androidzippers.contactpush;

/**
 * Created by Chandan on 09-Jun-15.
 */
public class Contact {
    private String name, number;
    private boolean checked;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
