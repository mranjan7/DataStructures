package Week1And2;

import java.util.*;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

    public static int minDistance(Graph graph, String src, String dest) {

        int minDistance = -1;

        if (graph == null || src == null || dest == null) {
            return -1;
        }

        Set<Node> allNodes = graph.getAllNodes();

        Node startNode = graph.getNode(src);
        if (!allNodes.contains(startNode)) {
            return -1;
        }
        Node destNode = graph.getNode(dest);

        //System.out.println(allNodes);

        if (!allNodes.contains(destNode)) {
            return -1;
        }
        if (src == dest) {
            return 0;
        }
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);
        minDistance = breadthFirstSearch.bfsForMinDistance(startNode, dest);

        return minDistance;

    }


    public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {

        if (graph == null || src == null || distance < 1) {
            return null;
        }

        Set<Node> allNodes = graph.getAllNodes();

        Node startNode = graph.getNode(src);
        if (!allNodes.contains(startNode)) {
            return null;
        }
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);
        HashMap<Node, Integer> nodeDistanceMap = breadthFirstSearch.bfsForDistanceMap(startNode);

        Set<String> values = new HashSet<String>();
        for (Map.Entry<Node, Integer> entry : nodeDistanceMap.entrySet()) {
            Node node = entry.getKey();
            int nodeDistance = entry.getValue();
            if (nodeDistance <= distance) {
                values.add(node.getElement());
            }
        }

        values.remove(src);

        //System.out.println(values);

        return values;

    }


    public static boolean isHamiltonianPath(Graph g, List<String> values) {

        if (g == null || values == null || values.isEmpty()) {
            return false;
        }
        for (String value : values) {
            Node node = g.getNode(value);
            if (node == null) {
                return false;
            }
        }
        if (values.get(0) != values.get(values.size() - 1)) {
            return false;
        }
        Set<Node> allNodes = g.getAllNodes();
        if (allNodes.size() != values.size() - 1) {
            return false;
        }

        //System.out.println(values);

        Node prevNode = g.getNode(values.get(0));

        for (int i = 1; i < values.size() - 1; i++) {

            Node currentNode = g.getNode(values.get(i));

            if (g.addEdge(prevNode, currentNode)) {
                return false;
            }

            prevNode = currentNode;

        }


        return true;

    }

}
