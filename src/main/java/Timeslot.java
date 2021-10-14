package java;

public class Timeslot {
    String day;
    String init_hour;
    String init_minute;
    String final_hour;
    String final_minute;

    public Timeslot(String day,
            String init_hour,
            String init_minute,
            String final_hour,
            String final_minute){
        this.day = day;
        this.init_hour = init_hour;
        this.init_minute = init_minute;
        this.final_hour = final_hour;
        this.final_minute = final_minute;
    }

    @Override
    public String toString(){
        return this.day + this.init_hour+ ':' + this.init_minute + '-' +
                this.final_hour + ':' + this.final_minute;
    }

    //create an equals method!!(used in schedulers)
}
