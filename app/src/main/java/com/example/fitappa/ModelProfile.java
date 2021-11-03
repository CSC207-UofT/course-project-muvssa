package com.example.fitappa;

import fitappfiles.Profile;

import java.util.*;

public class ModelProfile extends Observable {

    // declaring a list of integer
    private Profile profile;

    // constructor to initialize the list
    public ModelProfile(){


    }

    // defining getter and setter functions


    public Profile getProfile() {
        return profile;
    }

    // function to make changes in the activity button's
    // count value when user touch it
    public void setProfile(Profile p){
        this.profile = p;
        setChanged();
        notifyObservers();
    }

}