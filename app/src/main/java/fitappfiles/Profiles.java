package fitappfiles;

import java.util.HashMap;
import java.util.Map;
// TODO: Make this a use case. Remove the unnecessary methods.
public class Profiles {
    private final Map<String, Profile> profiles;

    /**
     * Constructor for Profiles to hold multiple Profiles
     */
    public Profiles(){
        this.profiles = new HashMap<>();

    }

    /**
     * Allow users to sign up and create a Profile in Profiles
     * @param name String representing the account's username
     * @param password String representing the account's password
     * @param email String representing the account's username
     * @return a boolean true if the account was made or false if it already exists
     */
    public boolean signUp(String name, String password, String email){
        if(profiles.containsKey(name)){
            return false;
        }
        else {
            Profile person = new Profile(name, password, email);
            this.profiles.put(name, person);
            return true;
        }
    }

    /**
     * Allow someone to login to a profile using its username and password
     * @param name String representing the account's username that exists in Profiles
     * @param password String representing the account's password that exists to the username above
     * @return returns a Profile matching the username if logged in successfully, otherwise return null
     */
    public Profile loginToProfile(String name, String password){
        if(profiles.containsKey(name)){
            Profile person = profiles.get(name);
            if (person.getUser().login(name,password)){
                return person;
            }
        }
        return null;
    }

    /**
     * Search for another persons profile as long as you have their username
     * @param name this is the String username of the Profile you are searching for
     * @return return the Profile matching the username, null if not found
     */
    public Profile search(String name){
        if(profiles.containsKey(name)){
            return profiles.get(name);
        }
        return null;
    }

    /**
     * Delete a Profile in Profiles as long as you have its username and password
     * @param name the String username of the profile to be deleted
     * @param password the String password of the profile to be deleted
     */
    public void deleteProfile(String name, String password){
        if(profiles.containsKey(name)){
            Profile person = profiles.get(name);
            if (person.getUser().login(name,password)){
                this.profiles.remove(name);
            }
        }

    }

}
