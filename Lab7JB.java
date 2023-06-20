/**
 * Author: Jamari B
 * Description: create a program that calculates the average, variance, and standard deviation from the input 
 * file it receives. From those values, the program should calculate the percent of all values that are 
 * higher than the averages
 * Date: 11/29/2022
 */

import java.util.Scanner;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;

public class Lab7JB {

	public static void main(String[] args) {
		
		//construct object and set to null
		FileDialog fd = null; 
		fd = new FileDialog(fd, "Hello", FileDialog.LOAD);
		fd.setVisible(true);
		
		/**
		 * the what and where of the FileDialog
		 */
		String fileName = fd.getFile();
		String pathName = fd.getDirectory();
		
		String fullName = pathName + fileName; 
		
		File myFile = new File(fullName); 
		
		Scanner reader; //declare scanner 
		
		/**
		 * try to assign scanner to file
		 */
		try
		{
			reader = new Scanner(myFile); 
			
		}	
		/**
		 * 
		 * @param if file not found, print error
		 * @return nothing
		 */
		catch(FileNotFoundException err)
		{
			System.out.println("User error on read file!");
			System.out.println(err);
			return;
		}
		
		//stores the length of values from input file
		int size = reader.nextInt(); 
		//stores the values in array
		double [] values = new double [size]; 
		//declare sum variable
		double sum = 0; 
		//declare number of scores
		int numScores = 0;

		/**
		 * while scanner has values from input, read the values into the array and 
		 * increment the number of scores
		 * 
		 */
		while (reader.hasNextDouble())
		{
			//declare next score and initialize it to values from input file
			double nextScore = reader.nextDouble();
			/**
			 * if number of scores is greater than array length, set array to nextScore and increment
			 * number of scores
			 */
			if (numScores < values.length)
			{
				values[numScores] = nextScore;
				numScores++; 
			}
		}
		
			/**
			 * sum stores the values in array that are added together 
			 */
			for (int i = 0; i < numScores; i++)
			{
				sum += values[i];
				
			}
			
			//declare and initialize mean to sum divided by the number of scores
			double mean = sum/numScores;
			//declare and initialize deviation to 0
			double sDevSum = 0; 
			//declare and initialize aboveMean to be used for counter
			double aboveMean = 0;
			
			//standard deviation
			/**
			 *set the standard deviation equal to the squared result of the values in the array
			 *minus the mean
			 * keep track of the aboveMean by incrementing it
			 */
			for (int i = 0; i < numScores; i++)
			{
				sDevSum += ((values[i]-mean)*(values[i]-mean));
				//count those above the mean 
				if (values[i] > mean)
				{
					aboveMean++;
				}
				
			}
			
			//declare and initialize the percentage
			double percentAbove = (aboveMean / numScores)*100;
			//declare and initialize the variance 
			double variance = sDevSum/numScores; 
			//declare and initialize the standard deviation
			double standDev = Math.sqrt(variance);
			
			
			//print statements that format the variable 
			System.out.printf("average:   %4.3f\n", mean); 
			System.out.printf("variance: %4.3f\n", variance);
			System.out.printf("std. dev.: %4.3f\n", standDev);
			System.out.printf("percent:   %4.3f%%\n", percentAbove);
			

		//close scanner
		reader.close();
		
		//close FileDiloag
		fd.dispose();

	}

}
