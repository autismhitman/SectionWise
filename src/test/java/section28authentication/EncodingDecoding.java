package section28authentication;

import java.util.Base64;

public class EncodingDecoding {

	public static void main(String[] args) {
		 
		String username ="navin:password";
		String base64Encoded = Base64.getEncoder().encodeToString(username.getBytes());
        System.out.println(base64Encoded);
        
        byte[] decodedText= Base64.getDecoder().decode(base64Encoded);
        System.out.println(new String(decodedText));
	}

}
