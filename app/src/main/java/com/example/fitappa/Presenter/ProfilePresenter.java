package com.example.fitappa.Presenter;

import com.example.fitappa.Model.Gateway.ProfileReadWriter;
import com.example.fitappa.Model.Gateway.ReadWriter;
import com.example.fitappa.Model.UseCase.Profile;

public class ProfilePresenter {
    private Profile currentProfile;
    private Profile profile;
    private View view;

    /**
     * Constructor for ProfilePresenter class
     * @param view type view that represents the profile
     * @param myProfile type Profile that represents the user's profile
     * @param thisProfile type Profile that represents another profile
     */
    public ProfilePresenter(View view, Profile myProfile, Profile thisProfile) {
        this.view = view;
        this.profile = myProfile;
        this.currentProfile = thisProfile;
    }

    /**
     * Determines if a profile belongs to the user
     * @return returns a boolean value of whether the username of a user is the same as the current user's username
     */
    public Boolean isMyProfile(){
        if(profile.getUser().getUsername().equals(currentProfile.getUser().getUsername())){
            return Boolean.TRUE;
        }
        else{
            return Boolean.FALSE;
        }
    }

    /**
     * Gets the username from the user's profile
     * @return the username of a user as type Profile
     */
    public String getUsername(){
        return currentProfile.getUser().getUsername();
    }

    /**
     * Gets the amount of people that are following the user
     * @return the number of people that are following the user as type Profile
     */
    public String getFollow(){
        return currentProfile.getProfileFollow().followerCount();
    }

    /**
     * Gets the amount of people that the user is following
     * @return the number of people that the user is following as type Profile
     */
    public String getFollowing(){
        return currentProfile.getProfileFollow().followingCount();
    }

    public void saveData() {
        ReadWriter readWriter = new ProfileReadWriter();
        readWriter.save(this.currentProfile);
    }

    public interface View{
        void searched(Profile searchedProfile);
        void home();

    }

}
