package com.example.choremanager;

import java.util.Date;

public class chore {
    private Date dueTimeDate;
    private Date createdTimeDate;
    private String choreTitle;
    private String choreDescription;
    private boolean isCompleted;

    public chore(Date dueTimeDate, Date createdTimeDate, String choreTitle, String choreDescription, boolean isCompleted) {
        this.dueTimeDate = dueTimeDate;
        this.createdTimeDate = createdTimeDate;
        this.choreTitle = choreTitle;
        this.choreDescription = choreDescription;
        this.isCompleted = isCompleted;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Date getDueTimeDate() {
        return dueTimeDate;
    }

    public void setDueTimeDate(Date dueTimeDate) {
        this.dueTimeDate = dueTimeDate;
    }

    public Date getCreatedTimeDate() {
        return createdTimeDate;
    }

    public void setCreatedTimeDate(Date createdTimeDate) {
        this.createdTimeDate = createdTimeDate;
    }

    public String getChoreTitle() {
        return choreTitle;
    }

    public void setChoreTitle(String choreTitle) {
        this.choreTitle = choreTitle;
    }

    public String getChoreDescription() {
        return choreDescription;
    }

    public void setChoreDescription(String choreDescription) {
        this.choreDescription = choreDescription;
    }
}
