/*
CS 1115
Kristian Mentor
HW 5:  Bowling Scores
 */

import java.util.*;
import java.io.*;


class BowlingScores
{
	public static void main (String[] args) throws java.lang.Exception
	{

		int score1, score2, score3, validity;
		int amtGroups=0, amtInvalid=0, amtValid=0;
		//open file for input
		//open file for output
		PrintWriter outputFile= new PrintWriter("D:/EclipseWorkspace/hw5/src/output.txt");
		Scanner inputFile = new Scanner(new File("D:/EclipseWorkspace/hw5/src/input.txt"));
		//utilizing hasNextLine method to test for empty lines.
		//once an empty line is encountered, while loop ends.
		System.out.println("Printing Table Start\n");
		
		outputFile.println("\t \t \t \t Bowling Scores");
		outputFile.println("===============================================");
		outputFile.println(" ||||=||||=||||=||||=||||=||||=||||=||||=|||| ");
		outputFile.println("===============================================");
		while (inputFile.hasNextLine()){ 
			System.out.println("Entering Score 1\n");
			score1=inputFile.nextInt();
			
			System.out.println("Entering Score 2\n ");
			score2=inputFile.nextInt();
			
			System.out.println("Entering Score 3\n ");
			score3=inputFile.nextInt();

			validity=validGroup(score1,score2,score3, outputFile);
			if(validity==1){
				amtGroups++;
				amtValid++;
				outputFile.println("Group#: "+ amtGroups);
				outputFile.println("Score 1: ");
				oneGameScore(score1, outputFile);
				outputFile.println("\nScore 2: ");
				oneGameScore(score2, outputFile);
				outputFile.println("\nScore 3: ");
				oneGameScore(score3, outputFile);
				outputFile.println("\nAverage Score:" + avg3Score(score1,score2,score3));
				oneGameScore(avg3Score(score1,score2,score3), outputFile);
				outputFile.println("\n\n");
				outputFile.flush();
			}
			else {amtInvalid++;amtGroups++;}
			
		}
		inputFile.close();
		outputFile.println("Total amount of processed Groups: " + amtGroups);
		outputFile.println("Amount of Invalid Groups: " +amtInvalid);
		outputFile.println("Amount of Valid Groups: " +amtValid);
		outputFile.println("===============================================");
		outputFile.println(" ||||=||||=||||=||||=||||=||||=||||=||||=|||| ");
		outputFile.println("===============================================");
		System.out.println(" Program finished.");
	
		outputFile.close();
	}

	public static int validGroup(int score1, int score2, int score3, PrintWriter outputFile)
	//Test to see if the group of scores passed in is valid.
	//Returns 1 if valid, 0 if not.
	{
		int boolResult=1; //Initialized to true
		if((score1>300) | (score1<0) )
		{
			outputFile.println("Score 1 is invalid.");
			outputFile.println(score1+ " is out of the 0-300 range.");
			boolResult=0;
		}

		if((score2>300) | (score2<0) )
		{
			outputFile.println("Score 2 is invalid.");
			outputFile.println(score2+ " is out of the 0-300 range.");
			boolResult=0;
		}

		if((score3>300) | (score3<0) )
		{
			outputFile.println("Score 3 is invalid.");
			outputFile.println(score3+ " is out of the 0-300 range.");
			boolResult=0;
		}

		if(boolResult==0){outputFile.println("This group is invalid.\n"); }
		else {outputFile.println("This group is valid.");}
		outputFile.flush();
		return boolResult;
		
	}

	public static void oneGameScore(int score,PrintWriter outputFile)
	//Calculates game rating based on score.  Prints the rating.
	{
		//we know the score is less than or equal to 300.
		if(score>=250) outputFile.print( score + "-- Professional Game!!!");
		if(score>=200 & score<=249) outputFile.print( score + "-- Excellent Game!");
		if(score>=140 & score<=199) outputFile.print(score+ "-- Very Good Game.");
		if(score>=100 & score<=139) outputFile.print(score+ "-- Good Game.");
		if(score>=50 & score<=99) outputFile.print(score+ "-- Poor Game.");
		if(score<50) outputFile.print(score+ "-- Horrible Game. Shame.");
		outputFile.flush();
	}

	public static int avg3Score(int score1, int score2, int score3)
	//calculates the average of the 3 scores.
	{
		int average= (score1+score2+score3)/3 + (score1+score2+score3)%3;
		return average;

	}

}


