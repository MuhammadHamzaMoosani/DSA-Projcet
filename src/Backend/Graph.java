package Backend;

import java.util.*;

public class Graph {
    List<Vertex> vertices;

    public Graph() {
        this.vertices = new ArrayList<>();
    }


    public void addVertex(String label) {
        vertices.add(new Vertex(label));
    }

    public List<Vertex> getNeighbours(String sourceLabel)
    {
        Vertex source = findVertex(sourceLabel);
        return source.getNeighbors();
    }
    public void addEdge(String sourceLabel, String destinationLabel) {
        Vertex source = findVertex(sourceLabel);
        Vertex destination = findVertex(destinationLabel);
        if (source != null && destination != null) {
            source.neighbors.add(destination);
        }
    }

    public Vertex findVertex(String label) {
        for (Vertex vertex : vertices) {
            if (vertex.label.equals(label)) {
                return vertex;
            }
        }
        System.out.println("Data does not exist in the graph");
        return null;
    }

    public Vertex getStartingVertex() {
        if (!vertices.isEmpty()) {
            return vertices.get(0);
        }
        System.out.println("There is no data in the graph");
        return null;
    }

    public List<Vertex> getNeighbors(Vertex vertex) {

        return vertex.neighbors;
    }

    public void BFS() {
        Queue<Vertex> queue = new ArrayDeque<>();
        Vertex startVertex = getStartingVertex();

        if (startVertex == null) {
            System.out.println("Graph is empty.");
            return;
        }

        startVertex.visited = true;
        queue.add(startVertex);
        System.out.print(" " + startVertex.label);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();
            List<Vertex> neighbors = getNeighbors(currentVertex);

            for (Vertex neighbor : neighbors) {
                if (!neighbor.visited) {
                    queue.add(neighbor);
                    neighbor.visited = true;
                    System.out.print(" " + neighbor.label);
                }
            }
        }
        System.out.println();
    }

    public int shortestPath(String label1, String label2, List<Edge> edges) {
        Vertex startVertex = findVertex(label1);
        Vertex endVertex = findVertex(label2);

        if (startVertex == null || endVertex == null) {
            System.out.println("One or both nodes not found in the graph.");
            return 0;
        }

        resetVisitedFlags();

        Queue<Vertex> queue = new LinkedList<>();
        Map<Vertex, Vertex> previousNodes = new HashMap<>();

        startVertex.visited = true;
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll();

            for (Vertex neighbor : getNeighbors(currentVertex)) {
                if (!neighbor.visited) {
                    queue.add(neighbor);
                    neighbor.visited = true;
                    previousNodes.put(neighbor, currentVertex);
                }
            }
        }
        return printShortestPath(previousNodes, startVertex, endVertex, edges);
    }

    private void resetVisitedFlags() {
        for (Vertex vertex : vertices) {
            vertex.visited = false;
        }
    }

    private int printShortestPath(Map<Vertex, Vertex> previousNodes, Vertex start, Vertex end, List<Edge> edges) {
        List<Vertex> path = new ArrayList<>();
        Vertex current = end;

        while (current != null) {
            path.add(current);
            current = previousNodes.get(current);
        }

        Collections.reverse(path);

        //System.out.println("\nShortest Path from " + start.label + " to " + end.label + ":");
        for (Vertex vertex : path) {
            //System.out.print(vertex.label + " ");
        }
        int distance = 0;
        for (int i=0; i<path.size()-1; i++) {
            for (int j=1; j<path.size(); j++) {
                for (Edge e: edges) {
                    if (e.src.label.equals(path.get(i).label) && e.des.label.equals(path.get(j).label))
                        distance += e.distance;
                }
            }
        }
        return distance;
    }

    void show() {
        for(int i=0; i< vertices.size(); i++) {
            System.out.println(vertices.get(i).label);
        }
    }



    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex("1");
        graph.addVertex("2");
        graph.addVertex("3");
        graph.addVertex("4");
        graph.addVertex("5");
        graph.addVertex("6");
        graph.addVertex("7");

        graph.addEdge("1", "5");
        graph.addEdge("1", "4");
        graph.addEdge("4", "3");
        graph.addEdge("6", "2");
        graph.addEdge("3", "6");
        graph.addEdge("7", "2");

        System.out.println("Breadth-First Search:");
        graph.getNeighbours("1");
        graph.BFS();
        System.out.println();

    }
}
