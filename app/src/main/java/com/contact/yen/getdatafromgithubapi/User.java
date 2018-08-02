package com.contact.yen.getdatafromgithubapi;

public class User {
    private int mID;
    private String mNodeID;
    private String mName;
    private String mFullName;

    public User(int mID, String mNodeID, String mName, String mFullName) {
        this.mID = mID;
        this.mNodeID = mNodeID;
        this.mName = mName;
        this.mFullName = mFullName;
    }

    public int getmID() {
        return mID;
    }

    public void setmID(int mID) {
        this.mID = mID;
    }

    public String getmNodeID() {
        return mNodeID;
    }

    public void setmNodeID(String mNodeID) {
        this.mNodeID = mNodeID;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmFullName() {
        return mFullName;
    }

    public void setmFullName(String mFullName) {
        this.mFullName = mFullName;
    }
}
