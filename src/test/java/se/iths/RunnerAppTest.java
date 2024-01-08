package se.iths;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RunnerAppTest {
    @Test
    public void testDistanceTimeAndDate(){
        RunnerApp runapp = new RunnerApp(10,1,25,0,"2024-01-06");
        //assertEquals(1, runapp.getUserID());
        assertEquals(10, runapp.getDistance());
        assertEquals(1, runapp.getHour());
        assertEquals(25, runapp.getMinute());
        assertEquals(0, runapp.getSecond());
        assertEquals(LocalDate.parse("2024-01-06"), runapp.getDate());
        assertNotNull(runapp.getUserID());

    }

    @Test 
    public void testDefaultDate(){
        RunnerApp runner = new RunnerApp(12, 1, 23, 0, "");
        assertEquals(LocalDate.now(), runner.getDate());
    }

    

    @Test
    public void testUserIdGenerateProperly(){
        RunnerApp run1 = new RunnerApp(12,3,60,54,"2024-01-05");
        RunnerApp run2 = new RunnerApp(15,1,32,21,"2024-01-06");

        assertNotEquals(run1.getUserID(),run2.getUserID());
    }

    @Test 
    public void testCalculateAveragespeed(){
        RunnerApp runnerapp = new RunnerApp(12,4,23,0,"2024-01-02");
        assertEquals(3.0,runnerapp.calculateAveragespeed());
        
    }
    
     @Test 
    public void testCalculateKilometerTime(){
        RunnerApp runnerapp = new RunnerApp(4,2,23,0,"2024-01-02");
        assertEquals(5.75, runnerapp.calculateKilometerTime());
    }
    @Test
    public void testInvalidDistance(){
        assertThrows(IllegalArgumentException.class, () -> new RunnerApp(0,2,23,0,"2024-01-02"));
    }

    @Test
    public void testInvalidTime(){
        assertThrows(IllegalArgumentException.class, ()-> new RunnerApp(12, 0,0,0,"2024-01-04"));
    }
}