package Week1And2;

/**
 * Created by mranjan on 07/09/17.
 */
public class BinaryTree1 {

    class Node{
        int value;
        Node leftChild=null;
        Node rightChild=null;
        Node(int value)
        {
            this.value=value;
        }

    }
    protected Node root=null;
    public void inorderTraversal(Node n)
    {
        if(n==null)
        {
            return;
        }
        inorderTraversal(n.leftChild);
        visit(n);
        inorderTraversal(n.rightChild);
    }

    private void visit(Node n) {
        System.out.println(n);
    }
    public boolean binaryTreeSearch(Node n,int value)
    {
        if(n==null)
        {
            return false;
        }

        if(n.value==value)
        {
            return true;
        }
        else if(n.value<value)
        {
            return binaryTreeSearch(n.leftChild,value);
        }
        else
        {
            return binaryTreeSearch(n.rightChild,value);
        }
    }

    public boolean add(Node n,int value)
    {
        if(n.value==value)
        {
            return false;
        }
        else if(n.value<value)
        {
            if(n.rightChild==null)
            {
                n.rightChild=new Node(value);
                return true;
            }
            else
            {
                return add(n.rightChild,value);
            }
        }
        else
        {
            if(n.leftChild==null)
            {
                n.leftChild=new Node(value);
                return true;
            }
            else
            {
                return add(n.leftChild,value);
            }
        }
    }
    public boolean remove(Node n,Node parent,int value)
    {
        if(n==null) {
            return false;
        }
        if(value>n.value)
        {
            return remove(n.leftChild,n,value);
        }
        else if(value<n.value)
        {
            return remove(n.rightChild,n,value);
        }
        else
        {
            if(parent==null)
            {
                root=n;
            }
            if(n.leftChild!=null&&n.rightChild!=null)
            {
                n.value=maxValue(n.leftChild);
                remove(n.leftChild,n,n.value);
            }
            else if(parent.leftChild==n)
            {
                parent.leftChild=n.leftChild==null?n.rightChild:n.leftChild;
            }
            else
            {
                parent.rightChild=n.leftChild==null?n.rightChild:n.leftChild;
            }
            return true;
        }
    }

    private int maxValue(Node leftChild) {
        return 0;
    }
}
