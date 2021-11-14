package com.example.fitappa.Presenter;

import android.view.View;
import com.example.fitappa.Model.UseCase.Profile;
import fitappfiles.Profiles;

public class ProfilePresenter {
    private Profile currentProfile;
    private Profile profile;
    private View view;
    private Profiles profiles;

    public ProfilePresenter(View view, Profile myProfile, Profile thisProfile, Profiles profiles) {
        this.view = view;
        this.profile = myProfile;
        this.currentProfile = thisProfile;
        this.profiles = profiles;
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

    public void searching(String userName){
        view.searched(profiles.search(userName));
    }



    public interface View{
        void searched(Profile searchedProfile);
        void home();
        void setGoToWorkouts();

    }

}
