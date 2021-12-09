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


    /**
     * Set up
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Executing a JUNIT test file");
    }

    /**
     * Teardown
     */
    @AfterClass
    public static void tearDownAfterClass(){
        System.out.println("Execution of JUNIT test file done");
    }

    /**
     * This setup method allows us to set up a few objects for testing purposes.
     * *
     */
    @Before
    public void setUp() {
        System.out.println("Executing a new test");
        profile1 = new Profile("johnnyappleseed@gmail.com", "Johnny", "101290");
        profile2 = new Profile("helloworld@gmail.com", "Hello", "239092");
    }

    /**
     * Tear down
     */
    @After
    public void tearDown() {
        System.out.println("Execution done");
    }

    /**
     * This method allows us to test the getEmail() method
     * *
     * checks to see if the desired string matches the one that's retrieved
     *
     */
    @Test
    public void getEmail() {
        assertEquals("johnnyappleseed@gmail.com", profile1.getEmail());
        assertEquals("helloworld@gmail.com", profile2.getEmail());
    }


    /**
     * This method allows us to test the getUsername() method
     * *
     * checks to see if the desired string matches the one that's retrieved
     *
     */
    @Test
    public void getUsername() {
        //sees if the desired string matches the one that's got
        assertEquals("Johnny", profile1.getUsername());
        assertEquals("Hello", profile2.getUsername());
    }

    /**
     * This method allows us to test the getUniqueID() method
     * *
     * checks to see if the desired string matches the one that's retrieved
     *
     */
    @Test
    public void getUniqueID() {
        //sees if the desired string matches the one that's got
        assertEquals("101290", profile1.getUniqueID());
        assertEquals("239092", profile2.getUniqueID());
    }

    /**
     * This method allows us to test the getWeight() and setWeight() methods
     * *
     * checks to see if the desired string matches the one that's retrieved and set to as well
     *
     * played around with the getters/setters
     */
    @Test
    public void setgetWeight() {
        profile1.setWeight("140");
        profile2.setWeight("160");
        assertEquals("140", profile1.getWeight());
        profile1.setWeight(profile2.getWeight());
        assertEquals("160", profile1.getWeight());
    }

    /**
     * This method allows us to test the getHeight() and setHeight() methods
     * *
     * checks to see if the desired string matches the one that's retrieved and set to as well
     *
     * played around with the getters/setters
     */
    @Test
    public void setgetHeight() {
        //sees if the desired string matches the one that's set and gotten
        profile1.setHeight("75");
        profile2.setHeight("90");
        assertEquals("75", profile1.getHeight());
        assertEquals("90", profile2.getHeight());
        profile2.setHeight(profile1.getHeight());
        assertEquals("75", profile2.getHeight());
    }

    /**
     * This method allows us to test the getFirstName() and setFirstName() methods
     * *
     * checks to see if the desired string matches the one that's retrieved and set to as well
     *
     * played around with the getters/setters
     */
    @Test
    public void setgetFirstName() {
        profile1.setFirstName("John");
        assertEquals("John", profile1.getFirstName());
        profile1.setFirstName("Jack");
        assertEquals("Jack", profile1.getFirstName());
        profile2.setFirstName(profile1.getFirstName());
        assertNotEquals("John", profile2.getFirstName());
    }

    /**
     * This method allows us to test the getFirstName() and setLastName() methods
     * *
     * checks to see if the desired string matches the one that's retrieved and set to as well
     *
     * played around with the getters/setters
     */
    @Test
    public void setgetLastName() {
        profile1.setFirstName("John");
        assertNull(profile1.getLastName());
        profile1.setLastName("Apple");
        assertEquals("Apple", profile1.getLastName());
        profile2.setLastName("World");
        profile2.setLastName(profile1.getFirstName());
        assertEquals("John", profile2.getLastName());
    }

}
