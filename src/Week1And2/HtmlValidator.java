package Week1And2;

import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		Stack<HtmlTag> htmlTagStack=new Stack<HtmlTag>();
		while(!tags.isEmpty())
		{
			HtmlTag tag=tags.poll();
			if(tag.isOpenTag())
			{
				htmlTagStack.push(tag);
			}
			else if(tag.isSelfClosing())
			{
				continue;
			}
			else
			{
				if(htmlTagStack.isEmpty())
				{
					return null;
				}
				HtmlTag lastTag=htmlTagStack.peek();
				if(lastTag.getElement().equals(tag.getElement()))
				{
					htmlTagStack.pop();
				}
				else
				{
					return htmlTagStack;
				}
			}
		}
		return htmlTagStack;

	}
	

}

