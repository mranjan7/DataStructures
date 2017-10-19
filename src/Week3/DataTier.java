package Week3;/*
 * SD2x Homework #8
 * This class represents the Data Tier in the three-tier architecture.
 * Implement the appropriate methods for this tier below.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DataTier {
	
	private String fileName; // the name of the file to read
	
	public DataTier(String inputSource) {
		fileName = inputSource;
	}

	public List<Book> getAllBooks()
	{
		List<Book> result = new ArrayList<Book>();

		if (fileName == null) {
			return result;
		}

		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				try {
					StringTokenizer st = new StringTokenizer(line,"\t");
					String title = st.nextToken();
					String author = st.nextToken();
					int year = Integer.parseInt(st.nextToken());
					Book book = new Book(title, author, year);
					result.add(book);
				}
				catch(Exception e)
				{
					continue;
				}
			}


		} catch (Exception e) {
			//e.printStackTrace();
			return result;
		}
		//System.out.println(result);

		return result;
	}
	

}
