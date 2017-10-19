package Week1And2;


public class BinarySearchTree<E extends Comparable<E>> {
	private int depth;
	class Node {
		E value;
		Node leftChild = null;
		Node rightChild = null;
		Node(E value) {
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			if ((obj instanceof BinarySearchTree.Node) == false)
				return false;
			Node other = (BinarySearchTree.Node)obj;
			return other.value.compareTo(value) == 0 &&
					other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}
	
	protected Node root = null;
	
	protected void visit(Node n) {
		System.out.println(n.value);
	}
	
	public boolean contains(E val) {
		return contains(root, val);
	}
	
	protected boolean contains(Node n, E val) {
		if (n == null) return false;
		
		if (n.value.equals(val)) {
			return true;
		} else if (n.value.compareTo(val) > 0) {
			return contains(n.leftChild, val);
		} else {
			return contains(n.rightChild, val);
		}
	}
	
	public boolean add(E val) {
		if (root == null) {
			root = new Node(val);
			return true;
		}
		return add(root, val);
	}
	
	protected boolean add(Node n, E val) {
		if (n == null) {
			return false;
		}
		int cmp = val.compareTo(n.value);
		if (cmp == 0) {
			return false; // this ensures that the same value does not appear more than once
		} else if (cmp < 0) {
			if (n.leftChild == null) {
				n.leftChild = new Node(val);
				return true;
			} else {
				return add(n.leftChild, val);
			} 	
		} else {
			if (n.rightChild == null) {
				n.rightChild = new Node(val);
				return true;
			} else {
				return add(n.rightChild, val);
			} 	
		}
	}	
	
	public boolean remove(E val) {
		return remove(root, null, val);
	}
	
	protected boolean remove(Node n, Node parent, E val) {
		if (n == null) return false;

		if (val.compareTo(n.value) == -1) {
				return remove(n.leftChild, n, val);
		} else if (val.compareTo(n.value) == 1) {
				return remove(n.rightChild, n, val);
		} else {
			if (n.leftChild != null && n.rightChild != null){
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if (parent == null) {
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			} else if (parent.leftChild == n){
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			} else {
				parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	protected E maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
	    } else {
	       return maxValue(n.rightChild);
	    }
	}

	
	/*********************************************
	 * 
	 * IMPLEMENT THE METHODS BELOW!
	 *
	 *********************************************/
	
	
	// Method #1.
	public Node findNode(E val) {

	    return search(root,val);

	}

    private Node search(Node n, E val) {
		if(val==null)
		{
			return null;
		}
        if(n==null )
        {
            return n;
        }
        if(n.value.equals(val))
        {
            return n;
        }
        else if(n.value.compareTo(val)>0)
        {
            return search(n.leftChild,val);
        }
        else
        {
            return search(n.rightChild,val);
        }
    }

    // Method #2.
	protected int depth(E val) {
		if(val==null)
		{
			return -1;
		}
		return calculateDepth(root,val,0);

	}

    private int calculateDepth(Node n,E val,int depth) {

        if(n==null)
        {
            return -1;
        }
		if(n.value.equals(val))
		{
			return depth;
		}
		else if(n.value.compareTo(val)>0) {

			return calculateDepth(n.leftChild, val,++depth);
		}
		else {

			return  calculateDepth(n.rightChild, val,++depth);
		}




    }

    // Method #3.
	protected int height(E val) {
        if(val==null)
        {
            return -1;
        }
		Node n=findNode(val);
        if(n==null)
        {
            return -1;
        }
        return(countDescendantNodes(n,0));

	}

    private int countDescendantNodes(Node n,int descendantCount) {

		return Math.max(n.leftChild==null?descendantCount:countDescendantNodes(n.leftChild, descendantCount+1), n.rightChild==null?descendantCount:countDescendantNodes(n.rightChild, descendantCount+1));


    }


    // Method #4.
	protected boolean isBalanced(Node n) {

		if(n==null)
        {
            return false;
        }
        n=findNode(n.value);
        if(n==null)
        {
            return false;
        }
        Node leftChild=n.leftChild;
        int leftChildHeight=0;
        if(leftChild==null)
        {
            leftChildHeight=-1;
        }
        else
        {
            leftChildHeight=height(leftChild.value);
        }
        Node rightChild=n.rightChild;
        int rightChildHeight=0;
        if(rightChild==null)
        {
            rightChildHeight=-1;
        }
        else
        {
            rightChildHeight=height(rightChild.value);
        }

        if(Math.abs(leftChildHeight-rightChildHeight)==0||Math.abs(leftChildHeight-rightChildHeight)==1)
        {
            return true;
        }
		
		return false;

	}
	
	private boolean isAllBalanced(Node n, boolean allBalanced) {

		if(n==null)
		{
			return allBalanced;
		}
		if(allBalanced==false)
		{
			return false;
		}

		return isAllBalanced(n.leftChild,isBalanced(n)) || isAllBalanced(n.rightChild,isBalanced(n));

	}

	// Method #5. .
	public boolean isBalanced() {

		return isAllBalanced(root,true);


	}

	public static void main(String args[])
	{
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		tree.add("dog");
		tree.add("cat");
		tree.add("pig");

		System.out.println(tree.contains("cat"));
	}


}
