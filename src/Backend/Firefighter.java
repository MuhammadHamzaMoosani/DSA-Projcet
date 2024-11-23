package Backend;

public class Firefighter {
    String id;

    static int id_num = 0;
    String location;
    Boolean availability;

    @Override
    public String toString() {
        return  "\nID: " + id +
                "\nLocation: " + location +
                "\nAvailability: " + availability ;
    }

    public Firefighter(String location) {
        id= "F-" + id_num;
        id_num++;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }
}
