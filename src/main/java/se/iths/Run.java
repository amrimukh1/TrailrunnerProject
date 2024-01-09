package se.iths;
public class Run {
    String id;

    public Run(String userID){
        this.id = userID;
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
}
