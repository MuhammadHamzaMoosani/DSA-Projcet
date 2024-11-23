package Backend;

import java.util.ArrayList;
import java.util.List;

public class Vertex{
    String label;
    List<Vertex> neighbors;
    boolean visited;


    public Vertex(String label) {
        this.label = label;
        this.neighbors = new ArrayList<>();
        this.visited = false;
    }

    public List<Vertex> getNeighbors() {
        return neighbors;
    }
}
