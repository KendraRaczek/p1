/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2016 
// PROJECT:          p1
// FILE:             Score.java
//
// Authors: Allison Quick, aquick2, 001; Jon Sharp, jsharp4, 001
//////////////////////////// 80 columns wide //////////////////////////////////
/**
 * This class implements ScoreListADT.  It stores Scores from the Score class in
 * a Score list. It uses methods size(), add(Score s), remove(int i), get(int i), and 
 * expandArray() these acts on the list.
 *
 * No bugs that I am aware of.
 *
 * @author Allison Quick
 */
public class ScoreList implements ScoreListADT {

	private Score[] scores; //will store scores
	private int numScores; //keeps count of scores
	private int pos; // will be used as a index variable, marking position
	
/**
 * This constructor initializes a score list.
 * 
 * PRECONDITION: All scores incoming are assumed to be non-null.
 *
 */
	public ScoreList(){ 
		scores = new Score[10]; //sets a Score list to hold 10 scores
		numScores = 0; //sets original score number to 0
		pos = 0; //sets original position to 0
	} //closes constructor
/** 
 * Returns the number of Scores in the list or zero. 
 * @return num Scores  the number of scores in the list
 * @return 0 if the numScores value is equal to or less than 0
 *
 */
	@Override
	public int size() {
		if (numScores > 0) {
			return numScores;
		} //closes if statement
		return 0;
	}//closes size()
/** 
 * Adds the score to the end of this list. First it double-checks that the 
 * Score does not contain null (if so, will throw IllegalArgumentException()).
 * It then checks to see if the list is full, calling expandArray() if it is.
 * It then adds the score at the end of the list and increments numScores.
 * 
 * @param s a non-null Score to place as the last item in the list.
 * @throws IllegalArgumentException
 */
	@Override
	public void add(Score s) throws IllegalArgumentException {
		if (s == null){
			throw new IllegalArgumentException();
		}//closes first if statement			
		if (scores.length == numScores){
			expandArray();
		} //closes second if statement
		scores[numScores] = s;
		numScores++;
	} //closes add(s)
/**
 * Removes and returns the item at index position i.
 * If i is less than zero or greater than or equal to size(),
 * will throw an IndexOutOfBoundsException. It also shifts scores to fill
 * in gap and update numScores.
 * 
 * @param int i must be greater than or equal to zero and less than size()
 * @return Score sc the item at index i
 * @throws IndexOutOfBoundsException
 */
	@Override
	public Score remove(int i) throws IndexOutOfBoundsException {
		if(i < 0 || i >= numScores){
			throw new IndexOutOfBoundsException();
		} //closes if statement
		Score sc = scores[i]; // saves the score that is being removed
		for (int a = pos; a < numScores-1; a++){
			scores[a] = scores[a+1];
		} //closes for loop
		numScores--;
		return sc;
	} //closes remove(i)
/**
 * Returns (without removing) the item at index position i.
 * If i is less than zero or greater than or equal to size(),
 * will throw an IndexOutOfBoundsException.
 * @param int i must be greater than or equal to zero and less than size()
 * @return the item at index i
 * @throws IndexOutOfBoundsException
 */
	@Override
	public Score get(int i) throws IndexOutOfBoundsException {
		if(i < 0 || i >= numScores){
			throw new IndexOutOfBoundsException();
		} //closes if statement
		return scores[i];
	} //closes get()
/**
 * Void method that is called by the add method to increase the list
 * size by twice the size when called. It creates a new list that contains
 * all of the previous lists' scores but with an increased size.
 * If i is less than zero or greater than size()-1,
 * will throw an IndexOutOfBoundsException.
 */
	private void expandArray(){
		Score[] scores2 = new Score [numScores * 2];
		for(int i = 0; i < numScores; i++){
			scores2[i] = scores[i]; //transfers values to the new list
			scores = scores2; //renames the new list to the previous name
		} //closes for loop
	}//closes expandArray()
} //closes class
