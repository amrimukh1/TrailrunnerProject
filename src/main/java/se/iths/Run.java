package se.iths;

import java.time.LocalDate;
import java.time.Duration;
public class Run {
    String id;
    double distance;
    Duration duration;
    LocalDate date;

    public Run(double distance, int duration, String date, String id){
        this.id = id;
        this.distance=distance;
        this.duration=Duration.ofSeconds(duration);
        this.date= LocalDate.parse(date);

    }

     public Run(double distance, int duration, String id ){
        this.id = id; 
        this.distance=distance;
        this.duration=Duration.ofSeconds(duration);
        date = LocalDate.now();
    }

    public String getuserID(){
        return id;

    }    

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        Run run = (Run) obj;
        return id == run.id;
    }   
    
    public double calculateSpeed(){
        double speed = distance / duration.toSeconds();
        return speed*3600;        
    }

    public Duration calculateKilometerTime(){
        long km = (long) (duration.toSeconds() / distance);
        return Duration.ofSeconds(km);
    }

    public String toString(){
    
        return String.format("Distance is " +distance + ", duration is "+duration.toSeconds() + ", date is "+date);

    }
   
}
