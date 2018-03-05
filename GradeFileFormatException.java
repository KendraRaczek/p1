/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017 
// PROJECT:          Program 1
// FILE:             GradeFileFormatException.java
//
// TEAM:    Team 35 Java Badgers
// Authors: Allison Quick, Michael Yang
// Author1: Allison Quick, aquick2@wisc.edu, aquick2, LEC 001
// Author2: Michael Yang, yang363@wisc.edu, yang363, LEC 001
//
//////////////////////////// 80 columns wide //////////////////////////////////
/**
 * This class defines a GradeFileFormatException.  The Exception extends from 
 * the Extension class.  When called, this class will send back an 
 * Exception message. It has two constructors, based on how the class is 
 * called.
 *
 * @author Allison Quick, Michael Yang
 */
public class GradeFileFormatException extends Exception {
	/**
	 * This constructor sends back an exception method when called by
	 * another class. There are no parameters.
	 * 
	 */
	public GradeFileFormatException () {
		super();
	}
	
	/**
	 * This constructor sends back an exception method when called by
	 * another class. 
	 * 
	 * @param String msg allows the class that calls GradeFileFormatException
	 * to insert and returns a specific message when the exception occurs.
	 * 
	 */
	public GradeFileFormatException(String msg) {
		super(msg);
	}
	
} //end of FradeFileFormatException class