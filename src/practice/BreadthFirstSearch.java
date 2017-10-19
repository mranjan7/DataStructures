package practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by mranjan on 19/09/17.
 */
public class BreadthFirstSearch {

    private Set<Node> marked;
    private Graph graphToSearch;

    BreadthFirstSearch(Graph graph)
    {
        marked=new HashSet<Node>();
        graphToSearch=graph;
    }

    public boolean bfs(String elementToFind,Node startNode)
    {
        if(!graphToSearch.containsNode(startNode))
        {
            return false;
        }
        if(elementToFind.equals(startNode.getElement()))
        {
            return true;
        }
        Queue<Node> nodesToExplore=new LinkedList<Node>();
        marked.add(startNode);
        nodesToExplore.offer(startNode);
        while(!nodesToExplore.isEmpty())
        {
            Node node =nodesToExplore.poll();
            for(Node neighbour:graphToSearch.getNodeNeighbours(node))
            {
                if(marked.contains(neighbour))
                {
                    continue;
                }
                if(elementToFind.equals(neighbour.getElement()))
                {
                    return true;
                }
                marked.add(neighbour);
                nodesToExplore.offer(neighbour);
            }
        }
        return false;
    }
}
