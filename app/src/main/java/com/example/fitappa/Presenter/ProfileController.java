package com.example.fitappa.Presenter;

import com.example.fitappa.Model.UseCase.Profile;

import java.util.*;

public class ProfileController extends Observable {

    // declaring a list of integer
    private Profile profile;
    private Profile otherProfile;

    public ProfileController(Profile profile){
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