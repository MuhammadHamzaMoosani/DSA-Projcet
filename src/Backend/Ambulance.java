package Backend;

public class Ambulance {
    String id;

    static int id_num = 0;
    String location;
    Boolean availability;

    public Ambulance(String location) {
        id = "A-"+id_num;
        id_num++;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }

    boolean is_boolean(){
        double num=Math.random();
        if(num<0.5)return true;
        else return false;
    }
    @Override
    public String toString() {
        return  "\nID: " + id +
                "\nLocation: " + location +
                "\nAvailability: " + availability;
    }
}
