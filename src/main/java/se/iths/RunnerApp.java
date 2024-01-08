package se.iths;
import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class RunnerApp {
    private String userid;
    private double distance;
    private int hour;
    private int minute;
    private int second;
    private LocalDate date;

    public RunnerApp(double distance, int hour, int minute, int second, String date){

         if (distance <=0 || (hour<=0 && minute <=0 && second<=0)){
        throw new IllegalArgumentException("Distance and time must be in greater than zero");
         }

        this.userid = UUID.randomUUID().toString();
        this.distance = distance;  
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        
        if(date==null || date.isEmpty()){
            this.date = LocalDate.now();
        }else{
            this.date= LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        }
    }


    public String getUserID(){
        return userid;
    }

    public double getDistance(){
        return distance;
    }

    public int getHour(){
        return hour;
    }

    public int getMinute(){
        return minute;
    }

    public int getSecond(){
        return second;
    }
    
    public LocalDate getDate(){
        return date;
    }
    
    public double calculateAveragespeed(){
        double totalTimeInHour = hour + minute / 60 + second / 3600;
        return distance / totalTimeInHour;
    }

    public double calculateKilometerTime(){
        double totalTimeInMinute = hour / 60 + minute + second / 60;
        return totalTimeInMinute / distance;
    }
    
    
}
