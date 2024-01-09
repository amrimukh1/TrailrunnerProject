package se.iths;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RunningSessionTest {
    @Test
    public void testDistanceTimeAndDate(){
        RunningSession runapp = new RunningSession(10,1,25,0,"2024-01-06");
        
        assertEquals(10, runapp.getDistance());
        assertEquals(1, runapp.getHour());
        assertEquals(25, runapp.getMinute());
        assertEquals(0, runapp.getSecond());
        assertEquals(LocalDate.parse("2024-01-06"), runapp.getDate());

    }

    @Test 
    public void testDefaultDate(){
        RunningSession runner = new RunningSession(12, 1, 23, 0, "");
        assertEquals(LocalDate.now(), runner.getDate());
    }

    @Test 
    public void testCalculateAveragespeed(){
        RunningSession runnerapp = new RunningSession(12,4,23,0,"2024-01-02");
        assertEquals(3.0,runnerapp.calculateAveragespeed());
        
    }
    
     @Test 
    public void testCalculateKilometerTime(){
        RunningSession runnerapp = new RunningSession(4,2,23,0,"2024-01-02");
        assertEquals(5.75, runnerapp.calculateKilometerTime());
    }
    @Test
    public void testInvalidDistance(){
        assertThrows(IllegalArgumentException.class, () -> new RunningSession(0,2,23,0,"2024-01-02"));
    }

    @Test
    public void testInvalidTime(){
        assertThrows(IllegalArgumentException.class, ()-> new RunningSession(12, 0,0,0,"2024-01-04"));
    }
    
    }
