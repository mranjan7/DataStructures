package Week1And2;/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		
		TreeMap<String,PriorityQueue<Integer>> resultMap=new TreeMap<String,PriorityQueue<Integer>>();
		if(allUsersRatings==null)
		{
			return resultMap;
		}

		for(UserMovieRating userMovieRating : allUsersRatings)
		{
			if(userMovieRating==null)
			{
				continue;
			}
			String movie=userMovieRating.getMovie();
			if(movie==null||movie.isEmpty())
			{
				continue;
			}
			int rating=userMovieRating.getUserRating();
			if(rating<0)
			{
				continue;
			}
			movie=movie.toLowerCase();
			if(resultMap.containsKey(movie))
			{
				PriorityQueue<Integer> ratings=resultMap.get(movie);
				ratings.add(rating);
			}
			else
			{
				PriorityQueue<Integer> ratings=new PriorityQueue<Integer>();
				ratings.add(rating);
				resultMap.put(movie,ratings);
			}
		}
		return resultMap;
	}

}
