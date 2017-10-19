package Week1And2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {

	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {

		List<Sentence> result = new ArrayList<Sentence>();

		if (filename == null) {
			return result;
		}

		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				int firstIndexOfWS = line.indexOf(' ');
				if (firstIndexOfWS == -1) {
					continue;
				}

				String scoreSt = line.substring(0, firstIndexOfWS);
				int score=0;
				try {
					score = Integer.parseInt(scoreSt);

				} catch (NumberFormatException nfe) {
					//nfe.printStackTrace();
					continue;
				}
				if(score<-2||score>2)
				{
					continue;
				}
				String text = line.substring(firstIndexOfWS);
				if (text.isEmpty()) {
					continue;
				}
				Sentence sentence = new Sentence(score, text.trim());
				result.add(sentence);

			}


		} catch (IOException e) {
			//e.printStackTrace();
			return result;
		}
		//System.out.println(result);
		
		return result;

	}
	
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {

		Set<Word> result=new HashSet<Word>();

		if(sentences==null||sentences.isEmpty())
		{
			return result;
		}

		ArrayList<Word> wordList=new ArrayList<Word>();
		for(Sentence sentence : sentences)
		{
			if(sentence==null)
			{
				continue;
			}
			StringTokenizer st=new StringTokenizer(sentence.getText());
			while (st.hasMoreElements())
			{
				String wordSt=st.nextToken();
				wordSt=wordSt.toLowerCase();
				if((wordSt.charAt(0)+"").matches("[^a-z]"))
				{
					continue;
				}
				Word word=new Word(wordSt);
				if(wordList.contains(wordSt))
				{
					wordList.get(wordList.indexOf(word)).increaseTotal(sentence.getScore());
				}
				else {
					word.increaseTotal(sentence.getScore());
					wordList.add(word);
				}
			}
		}
		result=new HashSet<Word>(wordList);
		//System.out.println(result);
		return result;

	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		Map<String,Double> result=new HashMap<String,Double>();
		if(words==null||words.isEmpty())
		{
			return result;
		}
		for(Word word : words)
		{
			if(word==null)
			{
				continue;
			}
			result.put(word.getText(),word.calculateScore());
		}
		
		return result;

	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {
		double result=0;
		if(wordScores==null||wordScores.isEmpty()||sentence==null||sentence.isEmpty())
		{
			return result;
		}
		StringTokenizer st=new StringTokenizer(sentence);
		int count=0;
		while (st.hasMoreTokens())
		{
			String wordSt=st.nextToken();
			wordSt=wordSt.toLowerCase();
			if((wordSt.charAt(0)+"").matches("[^a-z]"))
			{
				continue;
			}
			double wordScore=wordScores.get(wordSt)==null?0:wordScores.get(wordSt);
			result=result+wordScore;
			count++;
		}
		if(count==0)
		{
			return 0;
		}
		return result/count;

	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
