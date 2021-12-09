package com.example.fitappa.profile;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * This class is a testing class for Profile, a crucial object of the app.
 * <p>
 * The methods in this class are testing methods to see if the corresponding methods in the actual class work.
 * <p>
 * The documentation in this class give a specification on what the methods do
 *
 * @author Munim
 */


public class ProfileTest {
    /**
     * This setup method allows us to set up a few objects for testing purposes.
     * *
     * profile1 and profile2 are Profile objects with different parameters for testing
     * y is a RepSet object to support in testing of x
     * z is a WeightedSet object to support in testing of x
     */
    Profile profile1;
    Profile profile2;



    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Executing a JUNIT test file");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Execution of JUNIT test file done");
    }

    @Before
    /**
     * This setup method allows us to set up a few objects for testing purposes.
     * *
     * @objects profile1 and profile2 are distinct Profile objects.
     */
    public void setUp() throws Exception {
        System.out.println("Executing a new test");
        profile1 = new Profile("johnnyappleseed@gmail.com", "Johnny", "101290");
        profile2 = new Profile("helloworld@gmail.com", "Hello", "239092");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Execution done");
    }

    @Test
    /**
     * This method allows us to test the getEmail() method
     * *
     * checks to see if the desired string matches the one that's retrieved
     *
     */
    public void getEmail() {
        assertEquals("johnnyappleseed@gmail.com", profile1.getEmail());
        assertEquals("helloworld@gmail.com", profile2.getEmail());
    }
    @Test
    /**
     * This method allows us to test the getUsername() method
     * *
     * checks to see if the desired string matches the one that's retrieved
     *
     */
    public void getUsername() {
        //sees if the desired string matches the one that's got
        assertEquals("Johnny", profile1.getUsername());
        assertEquals("Hello", profile2.getUsername());
    }

    @Test
    /**
     * This method allows us to test the getUniqueID() method
     * *
     * checks to see if the desired string matches the one that's retrieved
     *
     */
    public void getUniqueID() {
        //sees if the desired string matches the one that's got
        assertEquals("101290", profile1.getUniqueID());
        assertEquals("239092", profile2.getUniqueID());
    }

    @Test
    public void setgetWeight() {
        /**
         * This method allows us to test the getWeight() and setWeight() methods
         * *
         * checks to see if the desired string matches the one that's retrieved and set to as well
         *
         * played around with the getters/setters
         */
        profile1.setWeight("140");
        profile2.setWeight("160");
        assertEquals("140", profile1.getWeight());
        profile1.setWeight(profile2.getWeight());
        assertEquals("160", profile1.getWeight());
    }

    @Test
    public void setgetHeight() {
        /**
         * This method allows us to test the getHeight() and setHeight() methods
         * *
         * checks to see if the desired string matches the one that's retrieved and set to as well
         *
         * played around with the getters/setters
         */
        //sees if the desired string matches the one that's set and gotten
        profile1.setHeight("75");
        profile2.setHeight("90");
        assertEquals("75", profile1.getHeight());
        assertEquals("90", profile2.getHeight());
        profile2.setHeight(profile1.getHeight());
        assertEquals("75", profile2.getHeight());
    }

    @Test
    public void setgetFirstName() {
        /**
         * This method allows us to test the getFirstName() and setFirstName() methods
         * *
         * checks to see if the desired string matches the one that's retrieved and set to as well
         *
         * played around with the getters/setters
         */
        profile1.setFirstName("John");
        assertEquals("John", profile1.getFirstName());
        profile1.setFirstName("Jack");
        assertEquals("Jack", profile1.getFirstName());
        profile2.setFirstName(profile1.getFirstName());
        assertNotEquals("John", profile2.getFirstName());
    }

    @Test
    public void setgetLastName() {
        /**
         * This method allows us to test the getFirstName() and setLastName() methods
         * *
         * checks to see if the desired string matches the one that's retrieved and set to as well
         *
         * played around with the getters/setters
         */
        profile1.setFirstName("John");
        assertNull(profile1.getLastName());
        profile1.setLastName("Apple");
        assertEquals("Apple", profile1.getLastName());
        profile2.setLastName("World");
        profile2.setLastName(profile1.getFirstName());
        assertEquals("John", profile2.getLastName());
    }

}
