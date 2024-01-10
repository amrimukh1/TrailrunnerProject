package se.iths;

import java.util.List;
import java.util.ArrayList;

public class User {
    private double height;
    private double weight;

    List<Run> myRuns; 

   public User(){                     
    this.myRuns = new ArrayList<>();

   }

    public void setHeight(double height){
        this.height = height;
    }

    public double getHeight(){
        return height;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    public double getWeight(){
        return weight;
    }

    public double calculateBMI(){
        double heightInMeter = height / 100.0;  
        double Bmi;
        Bmi = weight / (heightInMeter * heightInMeter);
        return Bmi;
    }
    
    public void addRun(Run run){
        for (Run currentRun : myRuns) {
            if (currentRun.getuserID() == run.getuserID()) {
            throw new IllegalArgumentException("Run with ID " + run.getuserID() + " already exists.");
            }
        }
        myRuns.add(run);
    }

    public double calculateTotalDistance(){
        double sum = 0.0;

        for (Run run : myRuns) {
            sum += run.distance;
        }
        return sum;
    }

    public double calculateAverageDistance(){
        double sum = 0.0;
        double average = 0.0; 

        for (Run run : myRuns) {
            sum += run.distance;
            average = sum /myRuns.size();
        }
        return average;
        }

        public String printDetailsById(String id){

            //Run run = new Run(10,3600,"2024-01-10","1");
           
            for ( Run run : myRuns){
                if (run != null && run.getuserID().equals(id)) {
                return run.toString(); 
            } 
        }
        return "Run not found for identification number: " + id;
                
        }

        public int deleteDetailsById(String id){
            User user =new User();
            Run run = new Run(10,3600,"2024-01-10","1");
            if(run != null&& run.getuserID().equals(id)){
                user.remove(run);

            }
            return 0;
        }

        public void remove(Run run) {

        for (Run currentRun : myRuns) {
            if (currentRun.getuserID() == run.getuserID()) {
            throw new IllegalArgumentException("Run with ID " + run.getuserID() + " already exists.");
            }
        }
            myRuns.remove(run);
        }
        }


        

    
    
  

