package com.example.fitappa.Presenter;

import com.example.fitappa.Model.Gateway.ProfileReadWriter;
import com.example.fitappa.Model.Gateway.ReadWriter;
import com.example.fitappa.Model.UseCase.Profile;

public class ProfilePresenter {
    private Profile currentProfile;
    private Profile profile;
    private View view;

    public ProfilePresenter(View view, Profile myProfile, Profile thisProfile) {
        this.view = view;
        this.profile = myProfile;
        this.currentProfile = thisProfile;
    }

    public Boolean isMyProfile(){
        if(profile.getUser().getUsername().equals(currentProfile.getUser().getUsername())){
            return Boolean.TRUE;
        }
        else{
            return Boolean.FALSE;
        }
    }
    public String getUsername(){
        return currentProfile.getUser().getUsername();
    }
    public String getFollow(){
        return currentProfile.getProfileFollow().followerCount();
    }
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
