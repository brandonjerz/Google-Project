/* Zack Sponaugle, Brandon Jerz, Marrinna Ryan, Imuse Ekpen-Itamah
 * CSC 213 Project Phase 2
 */

package main_package;


import java.io.*;
import java.util.HashMap;

// note: HashMap class is serialized by default
// note: self created WebPage class objects are not serializable by default. So have to implement Serializable in that class.

public class Serialize {
	
	public static void SerializeFHM(){	// check, changed to static for testing
	
	try{
		FileOutputStream fos = new FileOutputStream("googleFHM.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(Organs2.finalHashMap);	// check
		oos.close();
		fos.close();
		System.out.printf("Serialized data is saved in googleFHM.ser");
	}	// end try
	catch(IOException ioe){
		System.out.println("You done goofed.");
		ioe.printStackTrace();
	}	// end catch
	}	// end SerializeFHM
	
}	// end class
