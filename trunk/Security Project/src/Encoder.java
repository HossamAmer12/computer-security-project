

public class Encoder {
	
	
	public String generateSalt(){
		String salt = "";
		for(int i=0 ; i < 10; i++)
			salt += (char)(97+Math.random()*26);
		return salt;
	}
	
	public static void main(String[]args){
		//System.out.println(generateSalt());
		
	}
}
