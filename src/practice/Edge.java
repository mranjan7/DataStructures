package practice;

/**
 * Created by mranjan on 17/09/17.
 */
public class Edge {

    private Node source;
    private Node destination;
    private int weight;

    public Edge(Node source, Node destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Node getSource() {
        return source;
    }

    public Node getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object other) {

        Edge otherEdge=(Edge)other;
        Node otherSource=otherEdge.getSource();
        Node otherDestination=otherEdge.getDestination();
        int otherWeight=otherEdge.getWeight();
        return otherSource.equals(source)&&otherDestination.equals(destination)&&otherWeight==weight;

    }

    @Override
    public int hashCode() {
        return source.hashCode()+destination.hashCode()+weight;
    }
}
