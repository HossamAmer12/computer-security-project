import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.sound.sampled.Line;


public class Decoder {

	private BufferedReader lineReader; // Reader
	private BufferedReader dictionaryReader; // Reader
	public static String []line = {""};
	public static String dictionary = "";

	
	public void reader(){
		
	String inFile = System.getProperty("user.dir") +"/passwordFile.out";
	String dicFile = System.getProperty("user.dir") +"/passwordDictionary.dic";
	
		try {
			
			lineReader = new BufferedReader(new FileReader(inFile));
			dictionaryReader = new BufferedReader(new FileReader(dicFile));
			
		 } catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}
	
	public void lineReader(){
		try{
				
		      line =(lineReader.readLine().split(":"));
		      
			}catch (IOException e){
			     
					}
		
	 }
	
	public String dictinoryReader(){
		try{
				
		     return (dictionaryReader.readLine());
		      
			}catch (IOException e){
				e.printStackTrace();
			    return null;
					}
		
	 }
	
	public String Decode (){

		for(int i = 0; i < line[1].length(); i++){
			line[0] = line[0].replaceFirst(""+line[1].charAt(i), "");
		}
		String o = line[0];
		
		while(true){
	       
			dictionary =  dictinoryReader();
			String password = dictionary;
			 String original = o;
			
			 if(dictionary == null){
				 return "This Password is not in the dictionary";
			 }
			 
			 if(original.length() != dictionary.length()){
			  continue;
			 }
			
			for(int i = 0; i<original.length(); i++){
				for(int j = 0; j<dictionary.length(); j++){
				if(original.charAt(i) == dictionary.charAt(j)){
					dictionary = dictionary.replaceFirst(""+dictionary.charAt(j), "");
				}
				 }
				
			}
		
			if(dictionary.length() == 0) {
				return "The Password is :" + password;
			}
			
			
			
		}
	}
	public Decoder(){
		reader();
	    lineReader();
	   

	    System.out.println(Decode());
	    
	}
	
	public static void main (String [] args){
	
		new Decoder();
		
		
	}
}
