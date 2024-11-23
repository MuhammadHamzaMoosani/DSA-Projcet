package Backend;

public class User
{
    private String Name;
    private String Location;
    public User()
    {

    }
    public User(String Name,String Location)
    {
        this.Name=Name;
        this.Location=Location;
    }

    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
