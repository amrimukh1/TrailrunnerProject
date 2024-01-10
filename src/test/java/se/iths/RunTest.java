package se.iths;
import java.time.Duration;
import java.time.LocalDate;


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class RunTest {
    @Test
    public void testCreateRun(){
        Run run = new Run(10,3600, "2024-01-09","1");

        assertEquals(10.0,run.distance,0.01);
        assertEquals(Duration.ofSeconds(3600), run.duration);
        assertEquals( LocalDate.parse("2024-01-09"), run.date);
        assertEquals("1",run.id);

    }

    @Test
    public void testCreateRunWithoutDate(){
         Run run = new Run(10,3600,"1");

        assertEquals(10.0,run.distance,0.01);
        assertEquals(Duration.ofSeconds(3600), run.duration);
        assertEquals( LocalDate.now(), run.date);

    }

    @Test
    public void testCalculateAveragespeed(){
        Run run = new Run(10,3600,"1");
        assertEquals(10, run.calculateSpeed() );
    }

    @Test 
    public void testCalculateKilometerTime(){
        Run run = new Run(10,3600,"1");
        assertEquals(Duration.ofSeconds(360), run.calculateKilometerTime());

        Run anotherRun = new Run(10,4000,"1");
        assertEquals(Duration.ofSeconds(400), anotherRun.calculateKilometerTime());
    }

    @Test
    public void testPrintDetails(){

        Run run = new Run(10,3600,"2024-01-10","1");
       
        String expectedDetails = "Distance is 10.0, duration is 3600, date is 2024-01-10";
        assertEquals(expectedDetails, run.toString());
        
    }

    
}
