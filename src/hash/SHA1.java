package hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author oguzcanpamuk
 *
 */

public class SHA1 {

	
	public static String getSHA1Code(String message) throws NoSuchAlgorithmException{
		
		MessageDigest mdInstance = MessageDigest.getInstance("SHA-1");
		byte[] encryptMessage =mdInstance.digest(message.getBytes());
		StringBuilder strBuilder = new StringBuilder();
		
		for(byte byteValue : encryptMessage){
			strBuilder.append(String.format("%02x", byteValue));
		}
		
		return strBuilder.toString();
	}
	
	
	public static void main(String [] args) throws NoSuchAlgorithmException{
		String hexEncryptMessage=getSHA1Code("oguzpamuk");
		System.out.println(hexEncryptMessage);
	}
}
