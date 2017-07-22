/* Zack Sponaugle, Brandon Jerz, Marrinna Ryan, Imuse Ekpen-Itamah
 * CSC 213 Project Phase 2
 */

package main_package;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class Deserialize {
	
   public static void DeserializeFHM() {	// changed to static for testing
	   
	  HashMap<String, ArrayList<WebPage>> fhm = null; // check
      
	  try {
         FileInputStream fis = new FileInputStream("googleFHM.ser");
         ObjectInputStream ois = new ObjectInputStream(fis);
         fhm = (HashMap) ois.readObject();
         ois.close();
         fis.close();
      } // end try
      catch(IOException ioe){
    	  
         ioe.printStackTrace();
         return;
      }	//end first catch
      catch(ClassNotFoundException c){
         System.out.println("Class not found");
         c.printStackTrace();
         return;
      } // end second catch
	  
	  System.out.println("Deserializied Hashmap..");
	  // Display content using iterator
	  Set set = fhm.entrySet();
	  Iterator it = set.iterator();
	  while(it.hasNext()){
		  Map.Entry mentry = (Map.Entry)it.next();
		  System.out.print("word (key): " + mentry.getKey() + " \n Array List of WebPage Objects (Value): ");
		  System.out.println(mentry.getValue() + "\n");
	  }	// end while
      
    }	// end method
}	// end class
