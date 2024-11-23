package Backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Driver {
    Graph map = new Graph();
    String status="";
    int minDist=0;
    ArrayList<String> locations = new ArrayList<>();
    Map<Firefighter ,Boolean> firefighters = new HashMap<>();
    Map<Police, Boolean> police = new HashMap<>();
    public Map<Ambulance, Boolean> ambulances = new HashMap<>();
    List<Edge> edges = new ArrayList<>();

    public Map<Ambulance, Boolean> getAmbulances() {
        return ambulances;
    }

    public Map<Firefighter, Boolean> getFirefighters() {
        return firefighters;
    }

    public Map<Police, Boolean> getPolice() {
        return police;
    }

    public String getStatus() {
        return status;
    }

    public void fill() {
        int[] fl = {1, 5, 3, 9, 6};
        int[] pl = {7, 3, 0, 4, 2};
        int[] al = {4, 10, 1, 8, 6};
        for (int i=0; i<5; i++) {
            Firefighter f = new Firefighter(locations.get(fl[i]));
            Police p = new Police(locations.get(pl[i]));
            Ambulance a = new Ambulance(locations.get(al[i]));
            if (Math.random()<0.5) {
                firefighters.put(f, false);
                police.put(p, false);
                ambulances.put(a, false);
            }
            else {
                firefighters.put(f, true);
                police.put(p, true);
                ambulances.put(a, true);
            }
        }

    }
    public void edges() throws FileNotFoundException {
        File f = new File("src/Backend/Distances");
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine()) {
            String src_label = sc.nextLine();
            String des_label = sc.nextLine();
            int distance = Integer.parseInt(sc.nextLine());
            Edge e = new Edge(map.findVertex(src_label), map.findVertex(des_label), distance);
            edges.add(e);
            map.addEdge(src_label, des_label);
        }
    }
    public void mapping() throws FileNotFoundException {
        File f = new File("src/Backend/location_list.txt");
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine()) {
            String name = sc.nextLine();
            locations.add(name);
            map.addVertex(name);
        }
        for (Map.Entry<Ambulance, Boolean> set: ambulances.entrySet() ) {
            map.addVertex(set.getKey().id + "");
        }
        for (Map.Entry<Firefighter, Boolean> set: firefighters.entrySet() ) {
            map.addVertex(set.getKey().id + "");
        }
        for (Map.Entry<Police, Boolean> set: police.entrySet() ) {
            map.addVertex(set.getKey().id + "");
        }

    }
    public void callAmbulance(String location) {
        List<Ambulance> available = new ArrayList<>();
        for (Ambulance a: ambulances.keySet()) {
            if (ambulances.get(a)) {
                available.add(a);
            }
        }
        if (available.size()==0) {
            System.out.println("No ambulances available right now!");
            status="";
            return;
        }
        int min_dist = map.shortestPath(location, available.get(0).location, edges);
        Ambulance a0 = available.get(0);
        System.out.println("The available ambulances are: ");
        for (Ambulance a: available) {
            System.out.println(a.id + " " + a.location);
        }
        for (int i=1; i<available.size(); i++) {
            if (location.equals(available.get(i).location)) {
                System.out.println("Ambulance " + available.get(i).id + " will be arriving soon.");
                status=  available.get(i).id ;
                ambulances.replace(available.get(i), true, false);
                return;
            }
            int d = map.shortestPath(location, available.get(i).location, edges);
            if (d < min_dist) {
                min_dist = d;
                a0 = available.get(i);
            }
        }

        System.out.println("Ambulance " + a0.id + " will be arriving soon.");
        status=  a0.id ;
        for (Ambulance a: ambulances.keySet()) {
            if (a.location.equals(a0.location)) {
                ambulances.replace(a, true, false);
            }
        }
    }
    public void callPolice(String location) {
        List<Police> available = new ArrayList<>();
        for (Police p: police.keySet()) {
            if (police.get(p)) {
                available.add(p);
            }
        }
        if (available.size()==0) {
            System.out.println("No Police mobiles available right now!");
            status="";
            return;
        }
        int min_dist = map.shortestPath(location, available.get(0).location, edges);
        Police p0 = available.get(0);
        System.out.println("The available police mobiles are: ");
        AvailPolice();
        for (int i=1; i<available.size(); i++) {
            if (location.equals(available.get(i).location)) {
                System.out.println("Police Mobile  " + available.get(i).id + " will be arriving soon.");
                status=available.get(i).id;
                police.replace(available.get(i), true, false);
                return;
            }
            int d = map.shortestPath(location, available.get(i).location, edges);
            if (d < min_dist) {
                min_dist = d;
                p0 = available.get(i);
            }
        }
        System.out.println("Police " + p0.id + " will be arriving soon.");
        status= p0.id;
        for (Police p: police.keySet()) {
            if (p.location.equals(p0.location)) {
                police.replace(p, true, false);
            }
        }
    }
    public void callFirefighter(String location) {
        List<Firefighter> available = new ArrayList<>();
        for (Firefighter f: firefighters.keySet()) {
            if (firefighters.get(f)) {
                available.add(f);
            }
        }
        if (available.size()==0) {
            System.out.println("No firefighters available right now!");
            status="";
            return;
        }
        int min_dist = map.shortestPath(location, available.get(0).location, edges);
        Firefighter f0 = available.get(0);
        System.out.println("The available firefighters are: ");
        for (Firefighter f: available) {
            System.out.println(f.id + " " + f.location);
        }
        for (int i=1; i<available.size(); i++) {
            if (location.equals(available.get(i).location)) {
                System.out.println("Firefighter " + available.get(i).id + " will be arriving soon.");
                status=available.get(i).id;
                firefighters.replace(available.get(i), true, false);
                return;
            }
            int d = map.shortestPath(location, available.get(i).location, edges);
            if (d < min_dist) {
                min_dist = d;
                f0 = available.get(i);
            }
        }
        System.out.println("Firefighter " + f0.id + " will be arriving soon.");
        status= f0.id;
        for (Firefighter f: firefighters.keySet()) {
            if (f.location.equals(f0.location)) {
                firefighters.replace(f, true, false);
            }
        }
    }

    void show() {
        map.BFS();
        //map.show();
    }
    void showEdges() {
        for(Edge e: edges) {
            System.out.println(e.src.label + "-" + e.des.label + ": " + e.distance);
        }
    }

    public ArrayList AvailAmub()
    {   ArrayList<Ambulance> ambulances1=new ArrayList<>();
        for (Ambulance ambulance : ambulances.keySet())
        {
            boolean avail=ambulances.get(ambulance);
            if(avail)
            {
                ambulances1.add(ambulance);
            }
        }
        System.out.println(ambulances1.toString());
        return ambulances1;
    }
    public ArrayList AvailFire()
    {   ArrayList<Firefighter> FireTruck1=new ArrayList<>();
        for (Firefighter firefighter : firefighters.keySet())
        {
            boolean avail=firefighters.get(firefighter);
            if(avail)
            {
                FireTruck1.add(firefighter);
            }
        }
        System.out.println(FireTruck1.toString());
        return FireTruck1;
    }
    public ArrayList AvailPolice()
    {   ArrayList<Police> PoliceList=new ArrayList<>();
        for (Police police1 : police.keySet())
        {
            boolean avail=police.get(police1);
            if(avail)
            {
                PoliceList.add(police1);
            }
        }
        System.out.println(PoliceList.toString());
        return PoliceList;
    }
    public List<Vertex> getNeighbours(String SourceLabel)
    {
        return map.getNeighbours(SourceLabel);
    }
}
