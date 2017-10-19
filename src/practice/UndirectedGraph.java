package practice;

/**
 * Created by mranjan on 18/09/17.
 */
public class UndirectedGraph extends Graph {

    UndirectedGraph()
    {
        super();
    }
    @Override
    public boolean addEdge(Node n1, Node n2, int weight) {
        addNode(n1);
        addNode(n2);

        boolean addEdgeSuccess=addEdgeFromTo(n1,n2,weight)&&addEdgeFromTo(n2,n1,weight);

        if(addEdgeSuccess)
        {
            numEdges++;
        }
        return addEdgeSuccess;
    }

    @Override
    public boolean removeEdge(Node n1, Node n2, int weight) {
        return false;
    }
}
