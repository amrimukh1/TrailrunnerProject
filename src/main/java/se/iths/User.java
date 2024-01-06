package se.iths;

public class User {
    private double height;
    private double weight;

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
    

}
