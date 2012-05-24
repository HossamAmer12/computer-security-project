
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Encoder {

	
	BufferedReader userInput;
	boolean correct;
	
	public Encoder()
	{
		correct = false;
		userInput = new BufferedReader (new InputStreamReader(System.in));
		
	}
	
	public String getPassword()
	{
		String password = "";
		try
		{
			System.out.println("Enter a password:");
			password = userInput.readLine();
			
			if(!password.contains(" "))
				correct = true;
			
			while(!correct){
				System.out.println("Password cannot contain spaces, Enter a password:");
				password = userInput.readLine();
				
				if(!password.contains(" "))
					correct = true;
	        }
			
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
	
		String hashPassword = "";
		String salt = generateSalt();
		String hashTempString = password + salt;
		int stringLength = hashTempString.length();
		char [] hash = new char[password.length()+salt.length()];
		//char [] hash = new char[password.length()+salt.length()];
		ArrayList<String> hashTemp = new ArrayList<String>();
		
		for(int i = 0; i < stringLength; i++){
			hash[i]=hashTempString.charAt(i);
		}
		
		hashTemp.add(hashTempString.substring(0, stringLength/4));
		hashTemp.add(hashTempString.substring(stringLength/4, stringLength/2));
		hashTemp.add(hashTempString.substring(stringLength/2, (stringLength*3)/4));
		hashTemp.add(hashTempString.substring((stringLength*3)/4, stringLength));
		
		hashTempString = hashTemp.get(0) + hashTemp.get(2) + hashTemp.get(3) + hashTemp.get(1); 
		
		hashTemp = new ArrayList<String>();
		
		hashTemp.add(hashTempString.substring(0, stringLength/6));
		hashTemp.add(hashTempString.substring(stringLength/6, (2*stringLength)/6));
		hashTemp.add(hashTempString.substring((2*stringLength)/6, stringLength/2));
		hashTemp.add(hashTempString.substring(stringLength/2, (2*stringLength)/3));
		hashTemp.add(hashTempString.substring((2*stringLength)/3, (5*stringLength)/6));
		hashTemp.add(hashTempString.substring((5*stringLength)/6, stringLength));
		
		hashTempString = hashTemp.get(3) + hashTemp.get(5) + hashTemp.get(1) + hashTemp.get(4) + hashTemp.get(0) + hashTemp.get(2);
		hashTemp = new ArrayList<String>();
		
		hashTemp.add(hashTempString.substring(0, stringLength/2));
		hashTemp.add(hashTempString.substring(stringLength/2, stringLength));
		hashPassword = hashTemp.get(1) + hashTemp.get(0);
		
		writeInPasswordFile(hashPassword, salt);
		
	}
		
	public static void writeInPasswordFile(String hashedPassword, String salt){
		String outFile = "/Users/michaelmkamal/Documents/workspace/Security Project/passwordFile.out";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outFile,true));
			writer.write(hashedPassword + ":" + salt);
			writer.newLine();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void run(){
		
		encrypt(getPassword());
		
		//writeInPasswordFile("Apple", "GUC");

	}
}
