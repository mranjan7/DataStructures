package Week1And2;

import java.util.LinkedList;

/**
 * Created by mranjan on 31/08/17.
 */
public class Queue1 {

    protected LinkedList list=new LinkedList();

    public void add(Object value)
    {
        list.add(value);
    }

    public Object remove()
    {
        if(list.isEmpty())
        {
            return null;
        }

        return list.removeFirst();

    }
}
