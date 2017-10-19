package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by mranjan on 17/09/17.
 */
public abstract class Graph {

    public int numNodes;
    public int numEdges;
    private Map<Node,Set<Edge>> adjacencySet;

    Graph()
    {
        numNodes=0;
        numEdges=0;
        adjacencySet=new HashMap<Node,Set<Edge>>();
    }

    public int getNumNodes() {
        return numNodes;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public boolean containsNode(Node node)
    {
        return adjacencySet.containsKey(node);
    }

    public boolean addNode(Node node)
    {
        if(node==null||containsNode(node))
        {
            return false;
        }

        HashSet<Edge> edgeSet=new HashSet<Edge>();
        adjacencySet.put(node,edgeSet);
        numNodes++;
        return true;
    }

    public Set<Node> getNodeNeighbours(Node node)
    {
        if(!containsNode(node))
        {
            return null;
        }

        Set<Edge> edgeSet=adjacencySet.get(node);
        HashSet<Node> nodeNeighbours=new HashSet<Node>();
        for(Edge edge : edgeSet)
        {
            nodeNeighbours.add(edge.getDestination());
        }
        return nodeNeighbours;
    }

    public abstract boolean addEdge(Node n1,Node n2,int weight);

    public abstract boolean removeEdge(Node n1,Node n2,int weight);

    public boolean addEdgeFromTo(Node source,Node destination,int weight)
    {
        Edge edge=new Edge(source,destination,weight);
        Set<Edge> edgeSet=adjacencySet.get(source);
        if(edgeSet.contains(edge))
        {
            return false;
        }
        edgeSet.add(edge);
        return true;
    }


}
