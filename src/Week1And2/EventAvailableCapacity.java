package Week1And2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mranjan on 01/09/17.
 */
public class EventAvailableCapacity {

    protected Queue<Integer> ticketRequests;
    protected int availableCapacity;

    EventAvailableCapacity(int maxCapacity)
    {
        ticketRequests=new LinkedList<Integer>();
        availableCapacity=maxCapacity;
    }

    public void addTicketRequest(int numPeople)
    {
        ticketRequests.add(numPeople);
    }

}
