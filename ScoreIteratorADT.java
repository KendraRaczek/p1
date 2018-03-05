/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017 
// PROJECT:          Program 1
// FILE:             ScoreIteratorADT.java
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
* This interface is an ADT that runs ScoreIterator.   It contains the methods
* next() and hasNext(). 
*
* @author Allison Quick, Michael Yang, Lindsey Bohr, Jon Sharp, Faust Shi, 
* Michael Yang, Kendra Raczek
*/
public interface ScoreIteratorADT {
/** 
 * This returns the next Score.
 * @throws NoSuchElementException if there is not an Element to iterate.
 */
	public Score next() throws NoSuchElementException;
/** 
 * This returns a boolean value whether there is a Score in the list.
 */
	public boolean hasNext();
} //closes interface
