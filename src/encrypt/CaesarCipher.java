package encrypt;

import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author oguzcanpamuk
 *
 *	Girilen anahtar degere göre verdigimiz metni en ilkel yontemle sifreler
 *	Sifreleme yapilirken verilen metin anahtar degere göre kaydirilir
 *	Ornek olarak abc key=1 iken bcd seklinde sifrelenir 
 *	Buyuk kucuk harf duyarlidir 
 */

public class CaesarCipher {
	
	public static String encrypt(String message,int key){
		
		StringBuilder encryptMessage = new StringBuilder();
		//key degeri 26dan buyukse mod alarak kucult,sebebi alfabede 26dan fazla karakter olmamasi
		key = key % 26;
		
		//string parcalama islemi yapiyoruz
		for(char element : message.toCharArray()){
			
			//bizim icin sadece alfabe onemli
			if(Character.isLetter(element)){
				//ascii karakterine gore islem yapiyoruz 
				if(Character.isLowerCase(element)){
					encryptMessage.append((char) ('a' + (element + key - 'a') % 26 ));
				}else{
					encryptMessage.append((char) ('A' + (element + key - 'A') % 26 ));
				}
			}else{
				encryptMessage.append(element);
			}
		}
		
		return encryptMessage.toString();
	}
	
	
	public static String decrypt(String message,int key){
		return (encrypt(message, 26-key));
	}
	
	public static void main(String [] args) throws NoSuchAlgorithmException{
		String message = "abcd";
		int key = 2;
		String encryptMessage = encrypt(message, key);
		String decryptMessage = decrypt(encryptMessage,key);
		System.out.println("Sifrelenecek mesaj : " +message);
		System.out.println("Sifreleme sonucu   : " +encryptMessage);
		System.out.println("Deşifreleme sonucu : " +decryptMessage);
	}
	
}


