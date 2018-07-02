package com.droid.filip.activitylifecycleandsimplegui.stakes;

import java.util.Date;

public class ListItem {

    private String text;
    private Date dateCreated;

    public ListItem(String text, Date dateCreated) {
        this.text = text;
        this.dateCreated = dateCreated;
    }

    public String getText() {
        return text;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }
}
