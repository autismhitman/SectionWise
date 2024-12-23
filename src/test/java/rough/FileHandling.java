package rough;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHandling {

	public static void main(String[] args) {
		 
		File file;
		FileWriter fw;
		FileReader fr;
		 
		try {
			
			 file = new File(System.getProperty("user.dir")+File.separator+" a.txt");
			 fw = new FileWriter(file);
			 fr = new FileReader(file);
			for( int i=97; i<=122; i++) {
				char c = (char) (i);
				 fw.append(c);
			
			}
			
			for( int i=65; i<=90; i++) {
				char c = (char) (i);
				 fw.append(c);
				  
			}
			 
			fw.close();
			fw.close();
			
			int i ;
			while ((i=fr.read())!=-1) {
				System.out.println((char) i);
			}
			
			fr.close();
			 file.delete();
			 
		}
		catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		 
			
			 
		 
		
		
			
		
	}

}
