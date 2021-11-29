package com.example.fitappa.Profile;

import java.io.Serializable;

/**
 * This class is an entity class containing extra information about a user that can be found on their profile.
 *
 * The methods in this class are all setters and getters
 *
 * The documentation is very basic mainly since all methods are getters and setters
 *
 * @author Souren
 * @since 0.1
 *
 */


public class SetupInformation implements Serializable {

    private String height;
    private String weight;
    private String first_Name;
    private String last_Name;

    /**
     * Constructor for an empty SetupInformation
     */
    public SetupInformation(){
       this.height = "";
       this.weight = "";
       this.first_Name = "";
       this.last_Name = "";
    }

    /**
     * Getter returns users height
     * @return string height
     */
    public String getHeight() {
        return height;
    }

    /**
     * Getter returns users weight
     * @return String weight
     */
    public String getWeight() {
        return weight;
    }
    /**
     * Getter returns users first name
     * @return String first_Name
     */
    public String getFirst_Name() {
        return first_Name;
    }
    /**
     * Getter returns users last name
     * @return String last_Name
     */
    public String getLast_Name() {
        return last_Name;
    }

    /**
     * Sets a users height
     * @param height a string representing a users height
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * Sets a users weight
     * @param weight a string representing a users weight
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }
    /**
     * Sets a users first name
     * @param first_Name a string representing a users first name
     */
    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }
    /**
     * Sets a users last name
     * @param last_Name a string representing a users last name
     */
    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }
}
