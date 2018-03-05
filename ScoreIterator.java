/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017 
// PROJECT:          Program 1
// FILE:             ScoreIterator.java
//
// TEAM:    Team 35 Java Badgers
// Authors: Allison Quick, Michael Yang, Lindsey Bohr, Jon Sharp,
// Faust Shi, Michael Yang, Kendra Raczek
// Author1: Allison Quick, aquick2@wisc.edu, aquick2, LEC 001
// Author2: Michael Yang, yang363@wisc.edu, yang363, LEC 001
// Author3: Lindsey Bohr, bohr@wisc.edu, bohr, LEC 001
// Author4: Jon Sharp, jsharp4@wisc.edu, jsharp4, LEC 001
// Author5: Faust Shi, shi86@wisc.edu, shi86, LEC 001
// Author6: Kendra Raczek, raczek@wisc.edu, LEC 001
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.NoSuchElementException;
/**
 * This class is an indirect access iterator that implements ScoreIteratorADT.  
 * When called, this class requires a ScoreList and a given category to iterate.
 * Once the end of the ScoreList is reached, a NoSuchElementException is thrown.
 *
 * Bugs: none known
 *
 * @author Allison Quick, Michael Yang, Lindsey Bohr, Jon Sharp, Faust Shi, 
 * Michael Yang, Kendra Raczek
 */
public class ScoreIterator implements ScoreIteratorADT {
	private ScoreList myList;
	private int position;
	private String category;

	/**
	* Constructs a ScoreIterator from a given list and category
	* @param Scorelist of students scores
	* @param String of score category to iterate through
	*/
	public ScoreIterator(ScoreList list, String category) {
		myList = list;
		this.category = category;
		position = 0;
	}

	/**
	 * Returns true iff there are more items in the collection
	 * 
	 * @returns true iff there are more items in the collection
	 */
	public boolean hasNext() {
		int pointer = position;
		while (pointer < myList.size() && (myList.get(pointer) == null || 
				!myList.get(pointer).getCategory().equals(category))) {
			pointer++;
		}
		return pointer < myList.size();
	}

	/**
	 * Returns the next Score in the collection AND
	 * advances the position of the iterator.
	 * a NoSuchElementException is thrown once the iterator reaches 
	 * end of available scores.
	 * 
	 * @returns the next Score in the collection
	 */
	public Score next() {
		try {
			if (!hasNext()) throw new NoSuchElementException();
			for (int i = position; i < myList.size(); ++i) {
				position++;
				if (myList.get(i).getCategory().equals(category))
					return myList.get(i);

			}
			return null;
		}
		catch (NoSuchElementException e) {
			System.out.println("There are no more available scores.");
		}
		return null;

	}
} //end of score iterator class