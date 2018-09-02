/*
 * Kristian Mentor
 * CISC 1115 
 * HW3: Exam Statistics
 */
import java.io.*;
import java.util.Scanner;

public class ExamStats {

public static void main(String[] args) throws FileNotFoundException {
//Create scanner to get user input
Scanner studentInfo = new Scanner(System.in);
		
//Sending my output into an output file.
PrintWriter outputFile = new PrintWriter("D:/EclipseWorkspace/Exam Statistics/output.txt");
outputFile.println("\t \t \t \tExam Statistics");
outputFile.println("=================================================");
outputFile.flush(); //you must flush the data being sent to the output file.
int ID, numCorrect, numWrong, amtStudents=0;
int highestPercentageID=0000,highestGradeID=0000,highestGrade=0; 
double highestPercentage=0.000;
		
System.out.println("\t\tWelcome to the Exam Statistics Calculator");
System.out.println("====================================================="
+"=========================");
		
System.out.println("Please enter the student's 4 Digit ID. (Note: 0000 will stop the program.) :");
ID=studentInfo.nextInt();
while(ID!=0000) 
{ 
amtStudents++;//increase the amount of students by 1.
//Enter the info for the students' exam.
System.out.println("Enter the # of correct answers: ");
numCorrect=studentInfo.nextInt();
System.out.println("Enter the # of wrong answers: ");
numWrong=studentInfo.nextInt();

//Test to see if the number of questions entered is greater than 50.
if(numCorrect+numWrong>50)System.out.println("Error! There are 50 questions, you entered "+ (numCorrect+numWrong));
else{
System.out.println("Student Info Received.");
System.out.println("\n"); //Make a space between each entry
outputFile.println("ID: " +ID);
outputFile.println(numCorrect+" Correct "+ numWrong+ " Incorrect");
outputFile.println("Total Answered: "+ (numCorrect+numWrong));
outputFile.println("Amount of questions Omitted: "+ (50-(numCorrect+numWrong)));
outputFile.println("Grade Received: "+(numCorrect*2)+"/100");		

//Test to see if no questions were answered, if none were answered, skip the rest of the testing.
if(numCorrect+numWrong==0) outputFile.println("No Questions Answered. ");
else {		
if(numCorrect>numWrong) outputFile.println("More correct answers than wrong answers.");
else if(numCorrect<numWrong) outputFile.println("More wrong answers than correct answers.");
else outputFile.println("Equal amount of correct and wrong answers.");
double percentage=(double)numCorrect/(numCorrect+numWrong);
			
			
outputFile.printf("Correct Answer percentage:  %.3f \n" ,percentage);
if(50-(numCorrect+numWrong)<10) outputFile.println("Less than 10 questions Omitted.");
else outputFile.println("10 or more questions omitted.");
//test for the highest percentage/grade.
if(percentage>highestPercentage) {highestPercentageID=ID;highestPercentage=percentage;}
if(numCorrect*2>highestGrade) {highestGradeID=ID; highestGrade=numCorrect*2;}
	}
outputFile.println("=================================================");
outputFile.flush();
}		
//begin the process for adding the next student.
System.out.println("Please enter the student's ID. (Note: 0000 will stop the program.) :");
ID=studentInfo.nextInt();
    }
outputFile.printf("The highest grade was " +highestGrade+ "/100, scored by Student ID#"+highestGradeID);
outputFile.println( );
outputFile.printf("The highest percentage was %.3f, scored by Student ID#%d",
highestPercentage,highestPercentageID);
System.out.println("Amount of Students Entered: "+amtStudents);
System.out.println("Now Exiting Program...");

//close file stream/printer
outputFile.close();
studentInfo.close();
}

}
