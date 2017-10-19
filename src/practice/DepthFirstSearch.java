package practice;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mranjan on 19/09/17.
 */
public class DepthFirstSearch  {

    private Set<Node> marked;
    private Graph graphToSearch;

    DepthFirstSearch(Graph graph)
    {
        marked=new HashSet<Node>();
        graphToSearch=graph;
    }

    public boolean dfs(String elementToSearch,Node startNode)
    {
        if(!graphToSearch.containsNode(startNode))
        {
            return false;
        }
        if(elementToSearch.equals(startNode.getElement()))
        {
            return true;
        }
        else {
            marked.add(startNode);
            for (Node node:graphToSearch.getNodeNeighbours(startNode))
            {
                if(!marked.contains(node)&&dfs(elementToSearch,node))
                {
                    return true;
                }
            }
            return false;
        }
    }
}
