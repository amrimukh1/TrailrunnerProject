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

        assertEquals(23.34, user.calculateBMI(), 0.01);
    }
    




    }


    
