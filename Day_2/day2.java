/*
 * Compilation: javac day2.java
 * Execution: java day2
 *
 * Prints both solutions for Day 2 of Advent of Code 2021 given the
 * input data is a text file named "input.txt"
 *
 * @Author Mat
 * @Github github.com/maegpi-nl
 * @Date 2021-12-02
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
	try {
	    File myData = new File("input.txt");
	    Scanner movementData = new Scanner(myData);
	    String front;
	    Character rear;
	    int movement=0;
	    int vertical=0;
	    int horizontal=0;
	    int aim=0;
	    int depth = 0;
	    while(movementData.hasNextLine()){
		String data=movementData.nextLine();
		front=String.valueOf(data.charAt(0));
		rear=data.charAt(data.length() -1);
		movement=Character.getNumericValue(rear);
		if(front.equals("u")){
		    vertical = vertical - movement;
		    aim = aim - movement;
		}
		else if(front.equals("d")){
		    vertical = vertical + movement;
		    aim = aim + movement;
		}
		else{
		    horizontal = horizontal + movement;
		    depth = depth + (aim*movement);
		}
	    }
	    System.out.println("Part 1\nThe vertical is: "+vertical+"\nthe horizontal is: "+horizontal+"\nand they multiply to: "+vertical*horizontal);
	    System.out.println("Part 2\nThe aim is: "+aim+"\nThe depth is: "+depth+"\nAnd the Horizontal position and depth multiply to: "+depth*horizontal);
	    movementData.close();
	}
	catch(FileNotFoundException e) {
	    System.out.println(e.getMessage());
	}
    }
}
