package hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Istenilen uzunluktaki veriyi 128bitlik veri haline getirir
 * @author oguzcanpamuk
 *
 */

public class MD5 {

	
	public static String getMD5Code(String message) throws NoSuchAlgorithmException{
		
		MessageDigest mdInstance = MessageDigest.getInstance("MD5");
		byte[] encryptMessage =mdInstance.digest(message.getBytes());
		StringBuilder strBuilder = new StringBuilder();
		
		for(byte byteValue : encryptMessage){
			strBuilder.append(String.format("%02x", byteValue));
		}
		
		return strBuilder.toString();
	}
	
	
	public static void main(String [] args) throws NoSuchAlgorithmException{
		String hexEncryptMessage=getMD5Code("oguzpamuk");
		System.out.println(hexEncryptMessage);
	}
}
