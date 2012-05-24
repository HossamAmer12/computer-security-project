
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Encoder {

	
	BufferedReader userInput;
	
	public Encoder()
	{
		userInput = new BufferedReader (new InputStreamReader(System.in));
		
	}
	
	public String getPassword()
	{
		String password = "";
		try
		{
			System.out.println("Enter a password:");
	        password = userInput.readLine();	
	        userInput.close();
	        
	        return password;
			
		}
		catch(Exception e)
		{
			return e.toString();
		}
	}
		
	public String generateSalt(){
		String salt = "";
		for(int i=0 ; i < 10; i++)
			salt += (char)(97+Math.random()*26);
		return salt;
	}
	
	public void encrypt(String password){
	
		String salt = generateSalt();
	}
		
	public static void writeInPasswordFile(String hashedPassword, String salt){
		String outFile = "/Users/michaelmkamal/Documents/workspace/Security Project/src/passwordFile.out";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
			writer.write(hashedPassword + ":" + salt);
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void run(){
		
		encrypt(getPassword());
		
		writeInPasswordFile("Apple", "GUC");

	}
}
