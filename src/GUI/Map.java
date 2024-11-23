package GUI;

import Backend.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map extends JPanel {
    JButton[] serviceButtons;
    Location[] locations;
    Location[] Alocations;//ambulance dots
    Location[] Flocations;//ambulance dots
    Location[] Plocations;//ambulance dots
    String[] names;
    float[] Lat;
    float[] Long;
    JLabel[] labels;
    String name; String location;
    Driver driver = new Driver();
    int index;
    ArrayList<Ambulance>Aavail;//available ambulance arraylist
    ArrayList<Firefighter>Favail;//available firetrucks arraylsit
    ArrayList<Police>Pavail;//available police arraylsit
    public Map(ActionListener actionListener) throws FileNotFoundException {
        setLayout(null);
        setBackground(new Color(134, 247, 138));
        setFocusable(true);
        driver.mapping();
        driver.fill();
        driver.edges();
        Aavail=driver.AvailAmub();//available ambulance
        Favail=driver.AvailFire();
        Pavail=driver.AvailPolice();
        names=new String[14];
        Long=new float[14];
        Lat=new float[14];
        locations = new Location[11];
        Alocations=new Location[Aavail.size()];//ambulances for painting
        Flocations=new Location[Favail.size()];//ambulances for painting
        Plocations=new Location[Pavail.size()];//ambulances for painting
        labels = new JLabel[11+Aavail.size()+Favail.size()+20];
        serviceButtons = new JButton[3];
        Scanner fileReader = new Scanner(new File("src/GUI/LocationCoordinates.txt"));

        int i2=0;
        for (int i = 0; i < locations.length; i++) {
            String name = fileReader.nextLine(), lat_str = fileReader.nextLine().split(": ")[1], long_str = fileReader.nextLine().split(": ")[1];
            names[i]=name;
            float latitude = (float) ((Float.parseFloat(lat_str)-24.75)*2500)+200, longitude = (Float.parseFloat(long_str)-67)*3000;
            System.out.println(longitude+" "+latitude);
            Lat[i]=latitude;
            Long[i]=longitude;
            Location location = new Location((int) latitude, (int) longitude, name,new Color(68, 195, 219));
            location.setBounds(location.x, location.y, 30, 30);
            location.addActionListener(actionListener);
            locations[i] = location;

            labels[i] = new JLabel(name);
            int labelX = locations[i].x + (locations[i].getWidth() - labels[i].getPreferredSize().width) / 2;

            int labelY = locations[i].y + locations[i].getHeight() ;
            labels[i].setBounds(labelX, labelY, 150, 30);

            add(labels[i]);
            add(locations[i]);
            i2=i;
        }
        i2++;
        int ind=0;
        Boolean notEmpty=true;

        for (int i = 0; i < Alocations.length; i++)
        {
            int index=Location.LocationConvertor(Aavail.get(i).getLocation(),names);
            if(index!=-1)
            {
                Location location = new Location((int) (Lat[index]+40), (int) (Long[index]+40), Aavail.get(i).getId(),new Color(255,0,0));
                location.setBounds(location.x, location.y, 10, 10);
                location.addActionListener(actionListener);
                Alocations[i] = location;
                labels[i2] = new JLabel(Aavail.get(i).getId());
                int labelX = Alocations[i].x + (Alocations[i].getWidth() - labels[i2].getPreferredSize().width) / 2+10;
                int labelY = Alocations[i].y + Alocations[i].getHeight() ;
                labels[i2].setBounds(labelX, labelY, 150, 30);
                add(labels[i2]);
                add(Alocations[i]);
                notEmpty=false;
                i2++;
            }
        }
        i2++;
        for (int i = 0; i < Flocations.length; i++)
        {
            int index=Location.LocationConvertor(Favail.get(i).getLocation(),names);
            if(index!=-1)
            {
                Location location = new Location((int) (Lat[index]+50), (int) (Long[index]+40), Favail.get(i).getId(),new Color(255, 91, 0));
                location.setBounds(location.x, location.y, 10, 10);
                location.addActionListener(actionListener);
                Flocations[i] = location;
                labels[i2] = new JLabel(Favail.get(i).getId());
                int labelX = Flocations[i].x + (Flocations[i].getWidth() - labels[i2].getPreferredSize().width) / 2+10;
                int labelY = Flocations[i].y + Flocations[i].getHeight() ;
                labels[i2].setBounds(labelX, labelY, 150, 30);
                add(labels[i2]);
                add(Flocations[i]);
                notEmpty=false;
                ind=i+Favail.size();
                i2++;
            }
        }
        i2++;
        for (int i = 0; i < Plocations.length; i++)
        {
            int index=Location.LocationConvertor(Pavail.get(i).getLocation(),names);
            if(index!=-1)
            {
                Location location = new Location((int) (Lat[index]+60), (int) (Long[index]+40), Pavail.get(i).getId(),new Color(18, 84, 238));
                location.setBounds(location.x, location.y, 10, 10);
                location.addActionListener(actionListener);
                Plocations[i] = location;
                labels[i2] = new JLabel(Pavail.get(i).getId());
                int labelX = Plocations[i].x + (Plocations[i].getWidth() - labels[i2].getPreferredSize().width) / 2+10;
                int labelY = Plocations[i].y + Plocations[i].getHeight() ;
                labels[i2].setBounds(labelX, labelY, 150, 30);
                add(labels[i2]);
                add(Plocations[i]);
                notEmpty=false;
                i2++;
            }
        }
        i2++;
        int x = 25, y=380;
        if(notEmpty)
        {
            System.out.println("There is no ambulance");
            JLabel messageLabel = new JLabel("There are no ambulances available.");
            messageLabel.setBounds(x,y-50,200,50);
            labels[i2]=messageLabel;
            add(labels[ind]);
        }
        labels[i2+1]=new JLabel("Ambulance");
        labels[i2+1].setBounds(x+20,y-110,200,50);
        labels[i2+2]=new JLabel("Firetruck");
        labels[i2+2].setBounds(x+20,y-140,200,50);
        labels[i2+3]=new JLabel("Rescue Team");
        labels[i2+3].setBounds(x+20,y-170,200,50);
        add(labels[i2+1]);
        add(labels[i2+2]);
        add(labels[i2+3]);
        index=i2;
        String[] services = {"Ambulance", "Fire Truck", "Rescue Team"};
        for (int i = 0; i<services.length; i++) {
            serviceButtons[i] = new JButton(services[i]);
            serviceButtons[i].setBounds(x, y, 150, 50);
            serviceButtons[i].setFont(new Font("Helvetica", Font.BOLD, 15));
            serviceButtons[i].setBackground(new Color(68, 195, 219));
            serviceButtons[i].setForeground(Color.DARK_GRAY);
            serviceButtons[i].addActionListener(actionListener);
//            int finalI = i;
//            serviceButtons[i].addActionListener(e -> System.out.println(serviceButtons[finalI].getText()));
            serviceButtons[i].setFocusable(false);
            add(serviceButtons[i]);
            y+=60;
        }

    }
    public void RemoveLabel(JLabel[] labels,String ID,Location[]L1)
    {
        for (int i = 0; i < labels.length; i++)
        {
            if(labels[i]!=null) {
                if (labels[i].getText().equals(ID)) {
                    remove(labels[i]);
                    labels[i] = null;
                    break;
                }
            }

        }
        for (int i = 0; i < L1.length; i++)
        {
            if(L1[i]!=null){
                if(L1[i].getText().equals(ID))
                {
                    remove(L1[i]);
                    L1[i]=null;
                    break;
                }
            }

        }
    }
    public void paintComponent(Graphics g) {
        int x = 25, y=380;
        super.paintComponent(g);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.white);
        g.fillRect(0, 0, 200, 600);
        g.setColor(Color.black);
        g.setFont(new Font("SanSerif", Font.BOLD, 15));
        g.drawString("NAME: "+name, 20, 20);
        g.drawString("LOCATION: "+location, 20, 50);
        g.setColor(Color.red);
        g.fillRect(x,y-90,10,10);
        g.setColor(new Color(255, 91, 0));
        g.fillRect(x,y-120,10,10);
        g.setColor(new Color(18, 84, 238));
        g.fillRect(x,y-150,10,10);
        for (int i = 0; i < locations.length; i++)
        {
            Helper helper=new Helper();
            ArrayList<String> list=helper.GetLocations(names[i],driver);
            for (int j = 0; j < list.size(); j++)
            {
                int index=Location.LocationConvertor(list.get(j),names);
                g.setColor(Color.black);
                g.drawLine((int) locations[i].x+10, (int) locations[i].y+10, (int) locations[index].x+10, (int) locations[index].y+10);
            }
        }
        //add more details
        //draw edges using graph
    }
    public boolean actionPerformed(ActionEvent e, User user) throws InterruptedException {
        for(JButton button : locations) {
            if (e.getSource() == button) {
                System.out.println();
                //display details
                return true;
            }
        }
        for(JButton button : serviceButtons) {
            if (e.getSource() == button) {
                //call action
                System.out.println(button.getText());
                if(button.getText().equals("Ambulance"))
                {
                    driver.callAmbulance(user.getLocation());
                    RemoveLabel(labels,driver.getStatus(),Alocations);
                    if(labels[index+4]!=null)
                    {
                        remove(labels[index+4]);
                    }
                    if(driver.getStatus()=="")
                    {
                        labels[index+4]=new JLabel("No ambulances available right now!");
                        labels[index+4].setBounds(1,90,250,100);
                        add(labels[index+4]);
                    }
                    else {
                        labels[index + 4] = new JLabel("Ambulance " + driver.getStatus() + " will be arriving soon.");
                        labels[index + 4].setBounds(1, 90, 250, 100);
                        add(labels[index + 4]);
                    }
                    revalidate();
                    repaint();

                }
                else if(button.getText().equals("Fire Truck"))
                {
                    driver.callFirefighter(user.getLocation());
                    RemoveLabel(labels,driver.getStatus(),Flocations);
                    if(labels[index+4]!=null)
                    {
                        remove(labels[index+4]);
                    }
                    if(driver.getStatus().equals(""))
                    {
                        labels[index + 4] = new JLabel("No firefighters available right now!");
                        labels[index + 4].setBounds(1, 90, 250, 100);
                        add(labels[index + 4]);
                    }
                    else {
                        labels[index+4]=new JLabel("Firefighter " +driver.getStatus()+ " will be arriving soon.");
                        labels[index+4].setBounds(1,90,250,100);
                        add(labels[index+4]);
                    }
                    revalidate();
                    repaint();
                }
                else if(button.getText().equals("Rescue Team"))
                {
                    driver.callPolice(user.getLocation());
                    RemoveLabel(labels,driver.getStatus(),Plocations);
                    if(labels[index+4]!=null)
                    {
                        remove(labels[index+4]);
                    }
                    if(driver.getStatus().equals(""))
                    {
                        labels[index+4]=new JLabel("No Police mobiles available right now!");
                        labels[index+4].setBounds(1,90,250,100);
                        add(labels[index+4]);

                    }
                    else {
                        labels[index+4]=new JLabel("Police " +driver.getStatus()+" will be arriving soon.");
                        labels[index+4].setBounds(1,90,250,100);
                        add(labels[index+4]);
                    }
                    revalidate();
                    repaint();
                }
                return true;
            }
        }
        return false;
    }

}
