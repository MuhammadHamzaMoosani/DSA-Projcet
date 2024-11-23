package Backend;

public class Edge {
    Vertex src;
    Vertex des;
    int distance;

    Edge(Vertex src, Vertex des, int distance) {
        this.src = src;
        this.des = des;
        this.distance = distance;
    }

}
