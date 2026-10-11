package com.airtribe.learntrack.entity;

import static com.airtribe.learntrack.constants.AppConstants.DEFAULT_EMAIL;

public class Student extends Person {
    private String batch;
    private boolean active;

    // Constructor 1: with email
    public Student(String id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = true;
    }

    // Constructor 2: Overloaded constructor without email
    public Student(String id, String firstName, String lastName, String batch) {
        super(id, firstName, lastName, DEFAULT_EMAIL);
        this.batch = batch;
        this.active = true;
    }

    @Override
    public String getDisplayName() {
        return "[Student] " + super.getDisplayName() + " (Batch: " + batch + ")";
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
