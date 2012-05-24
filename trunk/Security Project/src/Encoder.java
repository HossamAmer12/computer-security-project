import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class Encoder {
	
	
	public String generateSalt(){
		String salt = "";
		for(int i=0 ; i < 10; i++)
			salt += (char)(97+Math.random()*26);
		return salt;
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
	
	public static void main(String[]args){
		//System.out.println(generateSalt());
		writeInPasswordFile("Apple", "GUC");
	}
}
