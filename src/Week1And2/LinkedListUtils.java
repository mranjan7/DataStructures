package Week1And2;

import java.util.*;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {
	
	public static void insertSorted(LinkedList<Integer> list, int value) {

		if(list==null)
		{
			return;
		}

		for(int i=0;i<list.size();i++)
		{
			int currentValue=list.get(i);
			if(currentValue>value)
			{
				list.add(i,value);
				return;
			}
		}
		list.add(value);

	}
	

	public static void removeMaximumValues(LinkedList<String> list, int N) {

		if(list==null||N<1)
		{
			return;
		}
		LinkedList<String> tempList= (LinkedList<String>) list.clone();
		Collections.sort(tempList);
		Collections.reverse(tempList);
		LinkedList<String> elementsToRemoveList=new LinkedList<>();
		int count=1;
		String element=tempList.peek();
		elementsToRemoveList.add(element);
		while(tempList.size()>0&&count<N)
		{
			String tempElement=tempList.pop();
			if(element!=tempElement)
			{
				element=tempElement;
				elementsToRemoveList.add(element);
				count++;
			}
		}
		list.removeAll(elementsToRemoveList);


	}
	
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
		if(one==null||one.size()==0||two==null||two.size()==0)
		{
			return false;
		}
		LinkedList<Integer>  tempOne= (LinkedList<Integer>) one.clone();
		LinkedList<Integer>  tempTwo= (LinkedList<Integer>) two.clone();
		boolean result=false;
		Integer firstElementOfTwo=two.peekFirst();
		outer:
		while(tempOne.size()>0)
		{
			Integer element=tempOne.pop();
			if(element.equals(firstElementOfTwo))
			{
				int i;
				for(i=1;i<tempTwo.size()&&tempOne.size()>0;i++)
				{
					element=tempOne.pop();
					if(!element.equals(tempTwo.get(i)))
					{
						continue outer;
					}
				}
				if(i==tempTwo.size())
				{
					result=true;
					break outer;
				}

			}
		}

		return result;
	}
}
