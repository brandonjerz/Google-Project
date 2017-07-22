/* Zack Sponaugle, Brandon Jerz, Marrinna Ryan, Imuse Ekpen-Itamah
 * CSC 213 Project Phase 2
 */

package main_package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BatchAdd {
	
	/** Read in a text file that contains a URL on each line and process it.  This is essentially 
		a different way to get data into your program.  Assume there is one URL per line.  
		Create your own file to test this with – call it URL.txt 
	The function to upload this file should be called BATCH ADD.  If the file doesn’t exist 
		make sure to generate an error message. 
 	NOTES:  using files with Eclipse can be a total pain, the URL file will need to be a 
		resource for you.
	**/
	
	public static void BatchAdd() throws IOException{
		
		try {
			// Open file
			File file = new File("BatchAdd_URL_TestFile.txt");		// connect to GUI?
			// Construct a FileReader to read file
			FileReader fileReader = new FileReader(file);
			// Feed FileReader to a BufferedReader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			// Construct StringBuffer
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			// BufferedReader is read line by line
			while ((line = bufferedReader.readLine()) != null) {
				Organs2.addURL(line); // new
				
			} // end while
			// Close FileReader
			fileReader.close();
			// Print statement for testing purposes
			System.out.println("Final Hash Map:" + Organs2.finalHashMap);	// connect to GUI?
			} // end try
		catch (IOException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}	// end catch
	} // end BatchAdd method

}	// end Class
