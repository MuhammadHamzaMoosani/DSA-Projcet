package Backend;

public class Police {
    String id;
    static int id_num=0;
    String location;

    public Police(String location) {
        id = "P-"+id_num;
        id_num++;
        this.location = location;
    }
    @Override
    public String toString() {
        return  "\nID: " + id +
                "\nLocation: " + location ;
    }

    public String getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }
}
