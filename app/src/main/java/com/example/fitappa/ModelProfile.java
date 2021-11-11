package com.example.fitappa;

import fitappfiles.Profile;

import java.util.*;

public class ModelProfile extends Observable {

    // declaring a list of integer
    private Profile profile;
    private Profile otherProfile;

    public ModelProfile(Profile profile){
        this.profile = profile;

    }
    public Profile getFollow1(){
        return this.profile;
    }
    public Profile getFollow2(){
        return this.otherProfile;
    }

    public void setFollow(Profile profile){
        this.profile.getProfileFollow().follow(profile.getProfileFollow());
        this.otherProfile = profile;
        setChanged();
        notifyObservers();
    }

}