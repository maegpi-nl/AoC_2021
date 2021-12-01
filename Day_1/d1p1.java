/*
 * Compilation: javac d1p1.java
 * Execution: java d1p1
 *
 * Prints both solutions for Day 1 of Advent of Code 2021 given the
 * input data is a textfile named "depthData.txt"
 *
 * @Author Mat
 * @GitGub github.com/maegpi-nl
 * @Date 2021-12-01
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class d1p1 {
    public static void main(String[] args)
    {
	try{
	    File myData = new File("depthData.txt");
	    Scanner depData = new Scanner(myData);
	    ArrayList<Integer> oceanDepth = new ArrayList<Integer>();
	    int counter = 0;
	    int groupCounter = 0;
	    int group1 = 0;
	    int group2 = 0;
	    while(depData.hasNextLine()){
		String data = depData.nextLine();
		int depthVal = Integer.parseInt(data);
		oceanDepth.add(depthVal);		
	    }
	    	for(int i=1;i<oceanDepth.size();i++){
	    if(oceanDepth.get(i) > oceanDepth.get(i-1)) counter++;
	}
		for(int j=3; j<oceanDepth.size(); j++){
		    group1 = 0;
		    group2 = 0;
		    for(int k=0;k<3;k++){
			group1 = group1 + oceanDepth.get(j-k-1);
			group2 = group2 + oceanDepth.get(j-k);
		    }
		    if(group2 > group1) groupCounter++;
		}
	System.out.println("The number of increments is : "+counter+"\nand the number of sums largers than the previous are : "+groupCounter);
	depData.close();
	} catch(FileNotFoundException e){
	    System.out.println(e.getMessage());}
    }
}
