import java.util.Map;

public class Profile {


    private User user;
    private ProfileFollow profileFollow;
    //private ProfileSchedule profileSchedule;



    public Profile(String name, String password, String email){
        this.user = new User(name, password, email);
        this.profileFollow = new ProfileFollow(this.user);
    }
    public User getUser() {
        return user;

    }
    public Map getProfileFollowing(){
        return profileFollow.getFollowing();
    }
    public Map getProfileFollower(){
        return profileFollow.getFollowers();
    }

//    public ProfileSchedule getProfileSchedule(){
//        return profileSchedule;
//    }

}
