package Backend;

import java.io.FileNotFoundException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Driver driver = new Driver();
        Helper helper=new Helper();
        driver.mapping();
        driver.fill();
        driver.edges();
        //driver.show();
//        driver.AvailFire();
//        driver.AvailPolice();
        driver.callAmbulance("Nazimabad");
        driver.callAmbulance("Nazimabad");
        driver.callAmbulance("Nazimabad");
        driver.callAmbulance("Nazimabad");
        driver.callFirefighter("Defence");
        driver.callPolice("New Karachi Town");

        //driver.showEdges();
        helper.GetLocations("Nazimabad",driver);
    }
}