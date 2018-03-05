/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2016 
// PROJECT:          p1
// FILE:             Score.java
//
// Authors: Allison Quick, aquick2, 001
//////////////////////////// 80 columns wide //////////////////////////////////
/**
 * This class is called by ScoreList.  creates a score to be stored in the ScoreList.
 * It can retrieve the name, points earned, max points possible, the category, and the 
 * percentage.
 *
 * No bugs that I am aware of.
 *
 * @author Allison Quick
 */
public class Score {
	private String assmtName; // Will hold assignment's name
	private double ptsEarned; // Will hold a double of points earned
	private double ptsPossible; // Will hold the total points possible
	
/**
 * This constructor initializes a score. It first checks that there aren't
 * null assignment names and that the values are greater than zero and 
 * points earned does not exceed points possible (will throw IllegalArgumentException
 * in any of these cases). 
 * Assigns parameters to the assmtName, ptsEarned, and ptsPossible within this class.
 * 
 * @param String assmtName string that represents the assignment's name
 * @param int ptsEarned an integer that represents points earned
 * @param int ptsPossible an integer that represents maximum points possible
 * @throws IllegalArgumentException
 */
	public Score(String assmtName, int ptsEarned, int ptsPossible) {
		if(assmtName == null) {
			throw new IllegalArgumentException();
		} //closes if statement that checks if the name is null
		if(ptsPossible < 0 || ptsEarned < 0 || ptsEarned > ptsPossible){
			throw new IllegalArgumentException();
		} //closes if statement that is checking the values meet specifications
		this.assmtName= assmtName;
		this.ptsEarned=ptsEarned;
		this.ptsPossible=ptsPossible;
	}// closes constructor
/**
 * This constructor is the same as the previous for Score but will accept doubles rather
 * than integers.
 * It initializes a score. It first checks that there aren't
 * null assignment names and that the values are greater than zero and 
 * points earned does not exceed points possible (will throw IllegalArgumentException
 * in any of these cases). 
 * Assigns parameters to the assmtName, ptsEarned, and ptsPossible within this class.
 * 
 * @param String assmtName string that represents the assignment's name
 * @param int ptsEarned an integer that represents points earned
 * @param int ptsPossible an integer that represents maximum points possible
 * @throws IllegalArgumentException
 */
	public Score(String assmtName, double ptsEarned, double ptsPossible){
		if(assmtName== null) {
			throw new IllegalArgumentException();
		}		
		if(ptsPossible <0 || ptsEarned < 0 || ptsEarned > ptsPossible){
			throw new IllegalArgumentException();
		}
		this.assmtName= assmtName;
		this.ptsEarned=ptsEarned;
		this.ptsPossible=ptsPossible;
	} //closes constructor
/**
 * Returns the name for the Score/ assignment.
 * 
 * @returns assmtName name of the assignment
 */
	public String getName()  {
		
		return assmtName;
	} //close getName()
/**
 * Returns the points earned for the Score/ assignment.
 * 
 * @returns ptsEarned the points that was earned on the assignment
 */
	public double getPoints() {
		return ptsEarned;
	} //closes getPoints()
/**
 * Returns the total points possible for the Score/ assignment.
 * 
 * @returns ptsPossible the points that were possible on the assignment
 */	
	public double getMaxPossible(){
		return ptsPossible;
		}//closes getMaxPossible
/**
 * Returns the first letter of the assignment name, representing the category
 * 
 * @returns catLetter  first letter of the assmtName, which is the category
 */
	public String getCategory() {
		//takes first letter of assmtName and sets to catLetter
		String catLetter= assmtName.substring(0,1);
		return catLetter;
		}//closes getCategory
/**
 * Returns the percentage for the Score/ assignment by dividing points
 * earned by points possible and multiplying by 100.
 * 
 * @returns percent  the percent that was received on the assignment
 */
	public double getPercent(){
		double percent = 100 * ptsEarned/ptsPossible;
		return percent;
		} //closes getPercent()
} //closes the class
