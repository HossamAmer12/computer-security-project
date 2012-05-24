import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Decoder {

	private BufferedReader lineReader; // Reader
	String []line = {"a","s"};
	
	public void reader(String inFile){
		
	// inFile ="C:\\Users\\Michael\\Dropbox\\10th\\1003\\Lab\\Lexical\\Compiler\\Compiler\\src\\P1\\Test.in";
		try {
			
			lineReader = new BufferedReader(new FileReader(inFile));
			line = lineReader();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}
	
	public String [] lineReader(){
		try{
				
		    return  (lineReader.readLine().split(";"));
		      
			}catch (IOException e){
			     return null;
					}
		
	 }
	
	
	
}
