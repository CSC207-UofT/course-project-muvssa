package com.example.fitappa.Profile;

import java.io.Serializable;

/**
 * This class is an entity class containing extra information about a user that can be found on their profile.
 * <p>
 * The methods in this class are all setters and getters
 * <p>
 * The documentation is very basic mainly since all methods are getters and setters
 *
 * @author Souren
 * @since 0.1
 */


class SetupInformation implements Serializable {

    private String height;
    private String weight;
    private String firstName;
    private String lastName;

    /**
     * Constructor for an empty SetupInformation
     */
    public SetupInformation() {
        this.height = "";
        this.weight = "";
        this.firstName = "";
        this.lastName = "";
    }

    /**
     * Getter returns users height
     *
     * @return string height
     */
    public String getHeight() {
        return height;
    }

    /**
     * Getter returns users weight
     *
     * @return String weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * Getter returns users first name
     *
     * @return String first_Name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter returns users last name
     *
     * @return String last_Name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets a users height
     *
     * @param height a string representing a users height
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * Sets a users weight
     *
     * @param weight a string representing a users weight
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * Sets a users first name
     *
     * @param firstName a string representing a users first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets a users last name
     *
     * @param lastName a string representing a users last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
