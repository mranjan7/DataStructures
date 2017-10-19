package Week1And2;

/**
 * Created by mranjan on 14/09/17.
 */
public class Heap {

    int[] values;
    int size=0;

    Heap(int maxHeight)
    {
        values=new int[(int)Math.pow(2,maxHeight)-1];
    }

    private void swapValues(int index1,int index2)
    {
        int temp=values[index1];
        values[index1]=values[index2];
        values[index2]=temp;
    }

    public void add(int value)
    {
        if(size==values.length)
        {
            throw new IndexOutOfBoundsException();
        }
        values[size]=value;
        bubbleUp(size);
        size++;

    }

    private void bubbleUp(int index) {

        if(index==0)
        {
            return;
        }

        int parentIndex=(index-1)/2;
        if(values[parentIndex]<values[index])
        {
            swapValues(parentIndex,index);
            bubbleUp(parentIndex);
        }

    }

    public int extractMax()
    {
        if(size==0)
        {
            throw new IndexOutOfBoundsException();
        }
        int extractMax=values[0];
        values[0]=values[size-1];
        bubbleDown(0);
        size=size-1;
        return extractMax;
    }

    private void bubbleDown(int index) {

        int greaterChild=0;

        int leftIndex=2*index+1;
        int rightIndex=2*index+2;

        if(rightIndex<size&&values[rightIndex]>values[leftIndex])
        {
            greaterChild=rightIndex;
        }
        else if(leftIndex<size&&values[leftIndex]>values[rightIndex])
        {
            greaterChild=leftIndex;
        }
        swapValues(index,greaterChild);
        bubbleDown(greaterChild);
    }


}
