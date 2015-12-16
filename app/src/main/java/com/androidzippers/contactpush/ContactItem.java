package com.androidzippers.contactpush;

/**
 * Created by Chandan on 09-Jun-15.
 */
public class ContactItem {
    private String firstName, surName, organization, workTitle, telWork, telHome, telMobile, email, note;
    private int flag;

    public ContactItem(String firstName, String surName, String organization, String workTitle, String telWork, String telHome, String telMobile, String email, String note) {
        this.firstName = firstName;
        this.surName = surName;
        this.organization = organization;
        this.workTitle = workTitle;
        this.telWork = telWork;
        this.telHome = telHome;
        this.telMobile = telMobile;
        this.email = email;
        this.note = note;
    }

    public ContactItem() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(String workTitle) {
        this.workTitle = workTitle;
    }

    public String getTelWork() {
        return telWork;
    }

    public void setTelWork(String telWork) {
        this.telWork = telWork;
    }

    public String getTelHome() {
        return telHome;
    }

    public void setTelHome(String telHome) {
        this.telHome = telHome;
    }

    public String getTelMobile() {
        return telMobile;
    }

    public void setTelMobile(String telMobile) {
        this.telMobile = telMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
