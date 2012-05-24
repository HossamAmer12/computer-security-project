import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.sound.sampled.Line;


public class Decoder {

	private BufferedReader lineReader; // Reader
	public static String []line = {"a","s"};
	
	public void reader(){
		
	String inFile = System.getProperty("user.dir") +"/passwordFile.out";
		try {
			
			lineReader = new BufferedReader(new FileReader(inFile));
			line = lineReader();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}
	
	public String [] lineReader(){
		try{
				
		    return  (lineReader.readLine().split(":"));
		      
			}catch (IOException e){
			     return null;
					}
		
	 }
	
	public String Decode (String [] s){
		
		return "";
	}
	public Decoder(){
		
		reader();
		
		
	}
	
	public static void main (String [] args){
	
		new Decoder();
		System.out.println(line[0]);
	}
}
