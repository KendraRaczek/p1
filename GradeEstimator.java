/////////////////////////////////////////////////////////////////////////////
// Semester:         CS367 Spring 2017 
// PROJECT:          Program 1
// FILE:             GradeEstimator.java
//
// TEAM:    Team 35 Java Badgers
// Authors: Allison Quick, Michael Yang, Lindsey Bohr
// Author1: Jon Sharp, jsharp4@wisc.edu, jsharp4, LEC 001
// Author2: Allison Quick, aquick2@wisc.edu, aquick2, LEC 001
// Author3: Lindsey Bohr, bohr@wisc.edu, bohr, LEC 001
// Author4: Faust Shi, shi@wisc.edu, shi, LEC 001
// Author5: Michael Yang, yang363@wisc.edu, yang363, LEC 001
//Author6: Kendra Raczek, raczek@wisc.edu, raczek, LEC 001
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.io.*;
import java.util.*;
/**
 * This class is the main class of the program that is used to estimate a grade
 * based on a file of various assignments, grades, and benchmarks. Methods in
 * this class include: main, createGradeEstimatorFromFile, getEstimateReport, 
 * formatChecker, and isNumber. 
 *
 * Bugs: none known
 *
 * @author Jon Sharp, Allison Quick, Michael Yang, Lindsey Bohr, Kendra Raczek,
 *Faust Shi
 */

/**
 * constructor for a GradeEstimator instance.
 */
public class GradeEstimator {
	private ScoreList scorelist;
	private ArrayList<String> category;
	private ArrayList<String> weigh;
	private ArrayList<String> grade;
	private ArrayList<String> thre;
	
	/**
	 * The main method harbors all actions of the grade estimation, eventually
	 * printing out the grade estimation. It calls methods 
	 * createGradeEstimatorFromFile and getEstimatorReport.
	 * 
	 * @throws FileNotFoundException
	 * @throws GradeFileFormatException
	 * @param args 
	 */
	public static void main(String[] args) {
		GradeEstimator estimator;
		
		
		GradeEstimator test = new GradeEstimator();
		test.grade.add("A");
		test.grade.add("C");
		test.grade.add("F");
		
		test.thre.add("85");
		test.thre.add("67");
		test.thre.add("0");
		
		test.category.add("homework");
		test.category.add("program");
		test.category.add("exam");
		
		test.weigh.add("30");
		test.weigh.add("78");
		test.weigh.add("100");
		
		test.scorelist.add(new Score("e1", 78, 100));
		test.scorelist.add(new Score("h1", 29, 30));
		test.scorelist.add(new Score("h2", 27, 29));
		test.scorelist.add(new Score("e2", 88, 100));
		test.scorelist.add(new Score("p1", 170, 200));
		test.scorelist.add(new Score("p2", 45, 210));
		test.scorelist.add(new Score("p3", 165, 210));
		
		System.out.print(test.getEstimateReport());
		
//		try {
//			if (args.length != 1) {
//				estimator = createGradeEstimatorFromFile(Config.GRADE_INFO_FILE_FORMAT_EXAMPLE);
//				System.out.println(Config.USAGE_MESSAGE);
//			}
//
//			else {
//				estimator = createGradeEstimatorFromFile(args[0]);
//			}
//			System.out.println(estimator.getEstimateReport());
//
//		} catch (FileNotFoundException e) {
//			System.out.println("File not found.");
//		} catch (GradeFileFormatException e) {
//			System.out.println("Incorrect file format.");
//		}
//
	}

	private GradeEstimator () {
		scorelist = new ScoreList();
		category = new ArrayList<String>();
		weigh = new ArrayList<String>();
		grade = new ArrayList<String>();
		thre = new ArrayList<String>();
	}
	
	/**
	 * The createGradeEstimatorFromFile method takes in a file and transforms
	 * it into the various subdivisions including name of assignment, points
	 * received, and points possible. This method is called in main.
	 * 
	 * @throws FileNotFoundException
	 * @throws GradeFileFormatException
	 * @param gradeInfo
	 * @return GradeEstimator()
	 */
	public static GradeEstimator createGradeEstimatorFromFile( String grades )
			throws FileNotFoundException, GradeFileFormatException { 

		File gradeInfo = new File(grades);
		Scanner scan = new Scanner(gradeInfo); 

		GradeEstimator estimator = new GradeEstimator();
		String names; 
		double points; 
		double possible; 
		if (gradeInfo == null)
			throw new FileNotFoundException();
		if (!estimator.formatChecker(gradeInfo))
			throw new GradeFileFormatException();

		return estimator;
	}
	
	/**
	 * The getEstimateReport method sets up the Estimate Report as a String
	 * to be printed out in main.
	 * 
	 * @return report
	 */
	public String getEstimateReport(){
		int curr = 0;
		double sum = 0.0;
		double weightedSum = 0.0;
		int count = 0;
		double totalGrade = 0.0;
		String g = "";
		String str = "";
		
		for (int i = 0; i < scorelist.size(); ++i) {
			Double percentScore = scorelist.get(i).getPercent();
			str += scorelist.get(i).getName() + "\t" + String.format("%5.2f", percentScore) + "\n";
		}
		 str += "Grade estimate is based on " + scorelist.size() + " scores\n";
		for (int i = 0; i < category.size(); i++){
			sum = 0.0;
			count = 0;
			ScoreIterator itr = new ScoreIterator(scorelist, category.get(i).substring(0,1));
			while (itr.hasNext()) {
				Score s = itr.next();
				sum += s.getPercent();
				count++;
			}
			sum = sum / count;
			double weight = Double.parseDouble(weigh.get(i));
			weightedSum = sum * weight / 100;
			totalGrade += weightedSum;
			str +=  String.format("%7.2f", weightedSum) + "% = " +
					String.format("%5.2f", sum) + "% of " + String.format("%2.0f", weight) + 
					"% for " + category.get(i) + "\n";
			curr = str.length();
		}
		for (int i = 0; i< thre.size(); i++){
			if (totalGrade >=  Double.parseDouble(thre.get(i))) {
				g = grade.get(i);
				break;
			}
		}
		str += "--------------------------------\n" + String.format("%7.2f", totalGrade) +
				"% weighted percent\n" + "Letter Grade Estimate: " + g;
				String report = str.toString();
		return report;
	}
	
	/**
	 * The formatChecker method takes in a String and checks to see if it is
	 * in the deesired format. This is called in createGradeEstimatorFromFile.
	 * 
	 * @param gradeInfo
	 * @return true iff gradeInfo is in the preferred format
	 */
	private boolean formatChecker  (File gradeInfo) throws FileNotFoundException {
		Scanner scnr = new Scanner(gradeInfo);
		Scanner line1 = new Scanner(scnr.nextLine());
		String next = "";
		while (line1.hasNext()) {
			next = line1.next();
			if (next.charAt(0) == '#') {
				break;
			}
			if (next.charAt(0) < 'A' || next.charAt(0) > 'Z') {
System.out.print("A");
				return false;
			}
			grade.add(next);
		}

		Scanner line2 = new Scanner(scnr.nextLine());
		while (line2.hasNext()) {
			next = line2.next();
			if (next.charAt(0) == '#') {
				break;
			}
			if (!isNumber(next)) {
System.out.print("B");
				return false;
			}
			thre.add(next);
		}

		Scanner line3 = new Scanner(scnr.nextLine());
		ArrayList<String> cate = new ArrayList<String>();
		while (line3.hasNext()) {
			next = line3.next();
			if (next.charAt(0) == '#') {
				break;
			}
			if (cate.contains(next.substring(0,1))) {
System.out.print("C");
				return false;
			}
			if (!cate.contains(next.substring(0,1)))
			cate.add(next.substring(0,1));
			category.add(next);
		}

		Scanner line4 = new Scanner(scnr.nextLine());
		while (line4.hasNext()) {
			next = line4.next();
			if (next.charAt(0) == '#') {
				break;
			}
			if (!isNumber(next)) {
System.out.print("D");
				return false;
			}
			weigh.add(next);
		}

		String assignmentName = "";
		double points = 0;
		double maxPoints = 0;
		while(scnr.hasNext()) {
			Scanner scoreLine = new Scanner(scnr.nextLine());
			assignmentName = scoreLine.next();
			next = scoreLine.next();

			if (!isNumber(next)) {
System.out.print("E");
				return false;
			}
			points = Double.parseDouble(next);

			next = scoreLine.next();

			if (!isNumber(next)) {
System.out.print("F");
				return false;
			}
			maxPoints = Double.parseDouble(next);

			scorelist.add(new Score(assignmentName, points, maxPoints));
		}

		if (grade.size() != thre.size()) {
System.out.print("G");
			return false;
		}
		return true;

	}
	
	/**
	 * The isNumber method checks to see if the String is a number.
	 * This method is called in formatChecker.
	 * 
	 * @param str
	 * @return true iff the str is a number
	 */
	private static boolean isNumber(String str){ 
		for (int i = 0; i < str.length(); i++)
		if (!Character.isDigit(str.charAt(i)) && !(str.charAt(i) == '.'))
			return false;
	return true;
	}
}
