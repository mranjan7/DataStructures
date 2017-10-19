package Week3;/*
 * SD2x Homework #8
 * This class represents the Logic Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */

import java.util.*;

public class LogicTier {
	
	private DataTier dataTier; // link to the Data Tier
	
	public LogicTier(DataTier dataTier) {
		this.dataTier = dataTier;
	}

	public List<String> findBookTitlesByAuthor(String authorName)
	{
		List<String> result=new ArrayList<String>();
		List<Book> books=dataTier.getAllBooks();
		Collections.sort(books, new Comparator<Book>() {
			@Override
			public int compare(Book o1, Book o2) {
				if(o1.getPublicationYear()==o2.getPublicationYear())
				{
					return o1.getTitle().compareTo(o2.getTitle());
				}
				else
				{
					return o1.getPublicationYear()-o2.getPublicationYear();
				}

			}
		});
		for(Book book:books)
		{
			if(book.getAuthor().toLowerCase().indexOf(authorName.toLowerCase())!=-1) {
				result.add(book.getTitle());
			}
		}
		return result;

	}
	public int findNumberOfBooksInYear(int year)
	{
		int result=0;
		List<Book> books=dataTier.getAllBooks();
		//System.out.println(books);
		for(Book book:books)
		{
			if(year==book.getPublicationYear())
			{
				result++;
			}
		}
		return result;
	}
	

}
