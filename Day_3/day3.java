
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;

public class day3{
    public static ArrayList<String> eleRemover(ArrayList<String> curList, int pos, Character saturation, Character keep)
    {
	int onesCount = 0;
	int twosCount = 0;
	Character overall = '9';
	int counter = curList.size()-1;
	boolean isOne = false;
	if(saturation == '1') isOne = true;
	for(int i=0; i<curList.size(); i++)
	    {
		if(curList.get(i).charAt(pos) == '1') onesCount++;
		else twosCount++;
	    }
	if(onesCount == twosCount)
	    {
		overall = saturation;
	    }
	else
	    {
		if(onesCount > twosCount){
		    if(keep == 'h') overall = '1';
		    else overall = '0';
		}
		else{
		    if(keep == 'h') overall = '0';
		    else overall = '1';
		}
	    }
	final Character finalOverall = overall;
	curList.removeIf(n -> (n.charAt(pos) != finalOverall));
	return curList;
    }
    public static void main(String[] args){
	try{
	    File myData = new File("input.txt");
	    Scanner binData = new Scanner(myData);
	    ArrayList<String> binList = new ArrayList<String>();
	    while(binData.hasNextLine()){
		binList.add(binData.nextLine());
	    }
	    int BINLENGTH = binList.size(); //size of the array
	    int STRINGLENGTH = binList.get(0).length(); //size of the binary string
	    //char binOne = '1';
	    String newBinStr = "";
	    for(int i=0;i < STRINGLENGTH; i++){
		int onesCount = 0;
		for(int j=0; j<BINLENGTH; j++){
		    Character binEle = binList.get(j).charAt(i);
		    if(binEle == '1') onesCount++;
		}
		if(onesCount > (BINLENGTH/2)){
		    newBinStr+="1";
		}
		else{
		    newBinStr+="0";
		}
	    }
	    String epiBin = "";
	    for(int k=0; k<newBinStr.length(); k++){
		if(newBinStr.charAt(k) == '1')epiBin+="0";
		else epiBin += "1";
	    }
	    System.out.println("The answer to part 1 is: "+Integer.parseInt(newBinStr,2)*Integer.parseInt(epiBin,2));

	    //part 2
	    ArrayList<String> coList = new ArrayList<String>();
	    for(String binVal:binList) coList.add(binVal); //copies list for CO scrubbing
	    int posCount = 0;
	    while(binList.size() > 1)
		{
		    binList = eleRemover(binList,posCount,'1','h');
		    posCount++;
		    if(posCount == STRINGLENGTH) posCount = 0;
		}
	    posCount = 0;
	    while(coList.size() > 1)
		{
		    coList = eleRemover(coList,posCount, '0','l');
		    posCount++;
		    if(posCount == STRINGLENGTH) posCount = 0; 
		}
	    System.out.println("The answer to part 2 is : "+Integer.parseInt(binList.get(0),2)*Integer.parseInt(coList.get(0),2));
	}
	catch(FileNotFoundException e){
	    System.out.println(e.getMessage());
	}
    }
}
    
