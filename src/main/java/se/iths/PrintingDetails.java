package se.iths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintingDetails {
    public static Map<String, List<Double>> runningSessions = new HashMap<>();

    public static void addRunningSession(String id, List<Double> distances) {
        runningSessions.put(id, distances);
    }

    public static double calculateTotalDistance() {
        double totalDistance = 0.0;
        for (List<Double> distances : runningSessions.values()) {
            totalDistance += distances.stream().mapToDouble(Double::doubleValue).sum();
        }
        return totalDistance;


    }
    public static double calculateAverageDistance() {
       List<Double> allDistances = new ArrayList<>();
        runningSessions.values().forEach(allDistances::addAll);
        
        if (allDistances.isEmpty()) {
            return 0;
        }
    
        double sum = allDistances.stream().mapToDouble(Double::doubleValue).sum();
        return sum / allDistances.size();

    }

    public static void printRunningSessionDetails(String id) throws IllegalArgumentException {
        List<Double> distances = runningSessions.get(id);
    
        if (distances == null) {
            throw new IllegalArgumentException("Error: Invalid ID. No running session found.");
        }
    
        double totalDistance = distances.stream().mapToDouble(Double::doubleValue).sum();
        double averageDistance = distances.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    
        System.out.println("Running Session Details for ID " + id + ":");
        System.out.println("Distances: " + distances);
        System.out.println("Total Distance: " + totalDistance + " kilometers");
        System.out.println("Average Distance: " + averageDistance + " kilometers");
    }

    public static void deleteRunningSession(String id) {

    
        if (!runningSessions.containsKey(id)) {
            throw new IllegalArgumentException("Error: Invalid ID. No running session found.");
        }
    
        List<Double> distancesToRemove = runningSessions.get(id);
        double totalDistanceBeforeDeletion = calculateTotalDistance();
    
        runningSessions.remove(id);
    
        double totalDistanceAfterDeletion = calculateTotalDistance();
        double distancesToRemoveSum = distancesToRemove.stream().mapToDouble(Double::doubleValue).sum();
    
        if (Math.abs(totalDistanceBeforeDeletion - distancesToRemoveSum - totalDistanceAfterDeletion) > 0.01) {
            throw new IllegalStateException("Error: Total distance calculation after deletion is incorrect.");
        }
    }

    
    /*public static void deleteRunningSession(String id) throws IllegalArgumentException {
        if (!runningSessions.containsKey(id)) {
            throw new IllegalArgumentException("Error: Invalid ID. No running session found.");
        }
    
        runningSessions.remove(id);
    }*/
    
    
}
