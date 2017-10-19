package Week3;/*
 * SD2x Homework #8
 * This class represents the Presentation Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below. 
 * Also implement the start method as described in the assignment description.
 */

import java.util.List;
import java.util.Scanner;

public class PresentationTier {
	
	private LogicTier logicTier; // link to the Logic Tier
	
	public PresentationTier(LogicTier logicTier) {
		this.logicTier = logicTier;
	}
	
	public void start() {

		Scanner scanner=new Scanner(System.in);
		System.out.println("Press 1 to find book titles by author name or press 2 to find number of books published in ayear : ");
		int input=scanner.nextInt();
		if(input==1)
		{
			showBookTitlesByAuthor();
		}
		else if(input==2)
		{
			showNumberOfBooksInYear();
		}
		else
		{
			System.out.println("Wrong input");
		}
		scanner.close();
	}
	
	public void showBookTitlesByAuthor()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("What is the author name ?");
		String authorName=scanner.next();
		List<String> titles=logicTier.findBookTitlesByAuthor(authorName);
		System.out.println("Titles by author "+authorName+" are : ");
		for(String title:titles)
		{
			System.out.println(title);
		}
		scanner.close();
	}
	public void showNumberOfBooksInYear()
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("For which year you want the number of books ?");
		int year=scanner.nextInt();
		System.out.println("Number of book published in year "+year+" : "+logicTier.findNumberOfBooksInYear(year));
		scanner.close();
	}
}
