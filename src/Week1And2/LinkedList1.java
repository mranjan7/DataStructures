package Week1And2;

/**
 * Created by mranjan on 22/08/17.
 */
public class LinkedList1 {

    private Node head;
    private Node tail;

    class Node{
        private int value;
        Node next =null;
        Node(int value)
        {
            this.value=value;
        }
    }

    public void addToFront(int value)
    {
        Node node=new Node(value);
        node.next=head;
        head=node;
        if(node.next==null)
        {
            tail=node;
        }
    }
    public void addToBack(int value)
    {
        Node node=new Node(value);
        if(tail==null)
        {
            tail=node;
        }
        else
        {
            tail.next=node;
            tail=node;
        }
    }
    public void add(int index,int value)
    {
        if(index<0)
        {
            throw new IndexOutOfBoundsException();
        }
        else if(index==0)
        {
            addToFront(value);
        }
        else {
            Node node = new Node(value);
            Node current = head;
            for (int i = 0; i < index; i++) {
                if(current==null)
                {
                    throw new IndexOutOfBoundsException();
                }
                current = current.next;
            }
            if(current.next==null)
            {
                current.next=node;
                tail=node;
            }
            else
            {
                node.next = current.next;
                current.next = node;
            }

        }

    }

    public boolean contains(int value)
    {
        Node current=head;
        while(current.next!=null)
        {
            if(current.value==value)
            {
                return true;
            }
            current=current.next;
        }
        return false;
    }
    public int get(int index)
    {
        if(index<0)
        {
            throw new IndexOutOfBoundsException();
        }
        Node current=head;
        for(int i=0;i<index;i++)
        {
            if(current==null||current.next==null)
            {
                throw new IndexOutOfBoundsException();
            }
            current=current.next;
        }
        return current.value;
    }

    public void removeFromFront()
    {
        if(head!=null)
        {
            head=head.next;
        }
        if(head==null)
        {
            tail=null;
        }
    }
    public void removeFromBack()
    {
        if(head==null)
        {
            return;
        }
        else if(head==tail)
        {
            head=null;
            tail=null;
        }
        else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
        }
    }
    public void remove(int index)
    {
        if(index<0)
        {
            throw new IndexOutOfBoundsException();
        }
        else if(index==0)
        {
            removeFromFront();
        }
        else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                if(current==null)
                {
                    throw new IndexOutOfBoundsException();
                }
                current = current.next;
            }

            current = current.next.next;
            if(current.next==null)
            {
                tail=current;
            }


        }
    }
}
