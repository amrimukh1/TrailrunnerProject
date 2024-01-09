package se.iths;

import java.util.List;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PrintingDetailsTest {
    @BeforeEach
    void setUp() {
        PrintingDetails.addRunningSession("001", List.of(3.5, 2.0, 5.2, 4.8));
        PrintingDetails.addRunningSession("002", List.of(2.0, 3.0, 4.5));
    }


    @Test
    void testCalculateTotalDistance() {
        double totalDistance = PrintingDetails.calculateTotalDistance();
        assertEquals(25.0, totalDistance);
    }

    @Test
    void testCalculateAverageDistance() {
        double averageDistance = PrintingDetails.calculateAverageDistance();
        assertEquals(4.17, Math.round(averageDistance*100.0)/100.0,0.01);
    }

    @Test
    void testPrintRunningSessionDetailsValidId() {
        assertDoesNotThrow(() -> PrintingDetails.printRunningSessionDetails("001"));
    }

    @Test
    void testPrintRunningSessionDetailsInvalidId() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
                                           () -> PrintingDetails.printRunningSessionDetails("003"));
        assertEquals("Error: Invalid ID. No running session found.", exception.getMessage());

        //assertDoesNotThrow(() -> PrintingDetails.printRunningSessionDetails("003"));
    }

    @Test
    void testDeleteRunningSessionValidId() {
        
        assertTrue(PrintingDetails.calculateTotalDistance() > 0);
        assertDoesNotThrow(() -> PrintingDetails.deleteRunningSession("001"));
        assertEquals(0, PrintingDetails.calculateTotalDistance());
    }

    @Test
    void testDeleteRunningSessionInvalidId() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, 
                                                () -> PrintingDetails.deleteRunningSession("003"));
        assertEquals("Error: Invalid ID. No running session found.", exception.getMessage());

        //assertDoesNotThrow(() -> PrintingDetails.deleteRunningSession("003"));
    }


    
}
