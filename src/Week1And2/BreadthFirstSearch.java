package Week1And2;

import java.util.*;

/*
 * SD2x Homework #6
 * This is an implementation of Breadth First Search (BFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class BreadthFirstSearch {

    protected Set<Node> marked;
    protected Graph graph;


    public BreadthFirstSearch(Graph graphToSearch) {
        marked = new HashSet<Node>();
        graph = graphToSearch;
    }

    /**
     * This method was discussed in the lesson
     */
    public boolean bfs(Node start, String elementToFind) {
        if (!graph.containsNode(start)) {
            return false;
        }
        if (start.getElement().equals(elementToFind)) {
            return true;
        }
        Queue<Node> toExplore = new LinkedList<Node>();
        marked.add(start);
        toExplore.add(start);
        while (!toExplore.isEmpty()) {
            Node current = toExplore.remove();
            for (Node neighbor : graph.getNodeNeighbors(current)) {
                if (!marked.contains(neighbor)) {
                    if (neighbor.getElement().equals(elementToFind)) {
                        return true;
                    }
                    marked.add(neighbor);
                    toExplore.add(neighbor);
                }
            }
        }
        return false;
    }

    public int bfsForMinDistance(Node start, String elementToFind) {

        if (!graph.containsNode(start)) {
            return -1;
        }
        if (start.getElement().equals(elementToFind)) {
            return 0;
        }
        HashMap<String, Integer> nodeDistanceMap = new HashMap<String, Integer>();
        nodeDistanceMap.put(start.getElement(), 0);

        Queue<Node> toExplore = new LinkedList<Node>();
        marked.add(start);
        toExplore.add(start);

        boolean connected = false;

        while (!toExplore.isEmpty()) {
            Node current = toExplore.remove();

            //System.out.println(nodeDistanceMap);

            for (Node neighbor : graph.getNodeNeighbors(current)) {
                //System.out.println("-"+neighbor);
                if (!marked.contains(neighbor)) {
                    if (neighbor.getElement().equals(elementToFind)) {
                        connected = true;
                    }
                    //System.out.println(nodeDistanceMap.get(current.getElement()));
                    int parentDistance = nodeDistanceMap.get(current.getElement());

                    nodeDistanceMap.put(neighbor.getElement(), parentDistance + 1);
                    marked.add(neighbor);
                    toExplore.add(neighbor);

                }
            }


        }
        //System.out.println(nodeDistanceMap);
        if (connected) {
            return nodeDistanceMap.get(elementToFind);
        } else {
            return -1;
        }


    }


    public HashMap<Node, Integer> bfsForDistanceMap(Node start) {

        HashMap<Node, Integer> nodeDistanceMap = new HashMap<Node, Integer>();
        nodeDistanceMap.put(start, 0);

        if (!graph.containsNode(start)) {
            return nodeDistanceMap;
        }


        Queue<Node> toExplore = new LinkedList<Node>();
        marked.add(start);
        toExplore.add(start);


        while (!toExplore.isEmpty()) {
            Node current = toExplore.remove();


            for (Node neighbor : graph.getNodeNeighbors(current)) {
                //System.out.println("-"+neighbor);
                if (!marked.contains(neighbor)) {
                    int parentDistance = nodeDistanceMap.get(current);
                    nodeDistanceMap.put(neighbor, parentDistance + 1);
                    marked.add(neighbor);
                    toExplore.add(neighbor);

                }
            }


        }
        //System.out.println(nodeDistanceMap);
        return nodeDistanceMap;
    }


}
