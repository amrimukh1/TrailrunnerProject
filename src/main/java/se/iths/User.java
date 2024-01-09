package se.iths;

import java.util.List;
import java.util.ArrayList;

public class User {
    private double height;
    private double weight;

    List<Run> myRuns; 

   public User(){     //constructor
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
        double heightInMeter = height / 100.0;  //convert Height centimeter into meter;
        
        //Calculate BMI;
        return weight / (heightInMeter * heightInMeter);

    }
    
    public void addRun(Run run){
        for (Run currentRun : myRuns) {
            if (currentRun.getuserID() == run.getuserID()) {
            throw new IllegalArgumentException("Run with ID " + run.getuserID() + " already exists.");
            }
        }
        myRuns.add(run);
    }

    public List<Run> getRuns() {
        return myRuns;
    }

        
    }
  

