package Week1And2;/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.*;


public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		List<String> movies=new ArrayList<String>();
		if(movieRatings==null||movieRatings.isEmpty())
		{
			return movies;
		}
		movies.addAll(movieRatings.keySet());
		return movies;
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		List<String> movies=new ArrayList<String>();
		if(movieRatings==null||movieRatings.isEmpty())
		{
			return movies;
		}
		for(Map.Entry<String,PriorityQueue<Integer>> entry:movieRatings.entrySet())
		{
			String movie=entry.getKey();
			if(movie==null||movie.isEmpty())
			{
				continue;
			}
			PriorityQueue<Integer> ratingQueue=entry.getValue();
			if(ratingQueue==null||ratingQueue.isEmpty())
			{
				continue;
			}
			if(ratingQueue.peek()>rating)
			{
				movies.add(movie);
			}
		}
		
		return movies;
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {

		TreeMap<String,Integer> resultMap=new TreeMap<String,Integer>();
		if(movieRatings==null||movieRatings.isEmpty())
		{
			return resultMap;
		}
		for(Map.Entry<String,PriorityQueue<Integer>> entry:movieRatings.entrySet())
		{
			String movie=entry.getKey();
			if(movie==null||movie.isEmpty())
			{
				continue;
			}
			PriorityQueue<Integer> ratingQueue=entry.getValue();
			if(ratingQueue==null||ratingQueue.isEmpty())
			{
				continue;
			}

			int count=0;
			while ((!ratingQueue.isEmpty())&&ratingQueue.peek() < rating) {
					count++;
					ratingQueue.poll();

			}


			if(count>0) {
				resultMap.put(movie, count);
			}
		}
		for(Map.Entry<String,Integer> entry : resultMap.entrySet())
		{
			String movie=entry.getKey();
			PriorityQueue<Integer> ratingQueue=movieRatings.get(movie);

			if(ratingQueue.size()==0)
			{
				movieRatings.remove(movie);
			}
		}



		
		return resultMap;
	}
}
