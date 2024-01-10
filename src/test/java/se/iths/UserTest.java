package se.iths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void testSetAndGetHeight(){
        User user = new User();
        user.setHeight(171.0);
        assertEquals(171.0, user.getHeight());
    }

    @Test 
    public void testSetAndGetWeight(){
        User user = new User();
        user.setWeight(75);
        assertEquals(75, user.getWeight());
    }

    @Test 
    public void testCalculateBMI(){
        User user = new User();
        user.setHeight(175.5);
        user.setWeight(71.9);

        assertEquals(23.34, user.calculateBMI(),0.01);
    }
    
    @Test
    public void testAddRunWithExistingID() {
        User user = new User();

        Run run1 = new Run(10,3600,"6");
        Run run2 = new Run(10,3600,"6");
        Run run3 = new Run(10,3600,"9");


        user.addRun(run1);

        assertThrows(IllegalArgumentException.class, () -> user.addRun(run2));
        assertDoesNotThrow(() -> user.addRun(run3));
        //assertFalse(user.addRun(run2));
    }

    @Test 
    public void testSaveRun(){
        User user = new User();
        Run run = new Run(10,3600,"1");

        user.addRun(run);
        assertTrue(user.myRuns.contains(run));
    }

    @Test 
    public void testThreeRuns(){
        User user = new User();
        Run run1 = new Run(10,3600,"1");
        Run run2 = new Run(5,1800,"2");
        Run run3 = new Run(3,360,"3");

        user.addRun(run1);
        user.addRun(run2);
        user.addRun(run3);
        assertEquals(3,user.myRuns.size());

    }

    @Test 
    public void testTotalDistance(){
        User user = new User();
        Run run1 = new Run(10,3600,"1");
        Run run2 = new Run(5,1800,"2");
        Run run3 = new Run(3,360,"3");

        user.addRun(run1);
        user.addRun(run2);
        user.addRun(run3);
        assertEquals(18, user.calculateTotalDistance());
    }

    @Test 
    public void testAverageDistance(){
        User user = new User();
        Run run1 = new Run(10,3600,"1");
        Run run2 = new Run(5,1800,"2");
        Run run3 = new Run(3,360,"3");

        user.addRun(run1);
        user.addRun(run2);
        user.addRun(run3);
        assertEquals(6,user.calculateAverageDistance());
    }
     
    @Test
    public void testprintDetailsById() {
        User user = new User();
        Run run = new Run( 10,3600,"2024-01-10","1");

        user.addRun(run);

        String expected = "Distance is 10.0, duration is 3600, date is 2024-01-10";

        assertEquals(expected, user.printDetailsById("1"));
    }

    @Test 
    public void testDeleteDetailsById(){
        User user = new User();
        
        assertEquals(0, user.deleteDetailsById("1"));
    }

    @Test 
    public void testRunNotFoundForID(){
        Run run1 = new Run(10,3600,"2024-01-10","1");
        Run run2 = new Run(10,3600,"2024-01-10","2");
        Run run3 = new Run(10,3600,"2024-01-10","3");

        User user = new User(); 

        user.addRun(run1);
        user.addRun(run2);
        user.addRun(run3);

        
        String result = user.printDetailsById("4");

        assertEquals("Run not found for identification number: 4", result);

    }


    @Test
    public void testRemove_RunExists() {
        
        Run existingRun = new Run(10,3600,"2024-01-07","1");
        User user = new User(); 
        user.addRun(existingRun);

        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            user.remove(existingRun);
        });

    
        assertTrue(exception.getMessage().contains("Run with ID 1 already exists."));
    }
  
    }



    
