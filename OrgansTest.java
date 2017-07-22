/* Zack Sponaugle and Brandon Jerz 
 * CSC 213 Search Engine Project
 */

package main_package;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.junit.Test;

public class OrgansTest {
	
	@Test
	public void testListURLsWordNotFound() throws IOException{
		Organs2 google1 = new Organs2();
		
		google1.addURL("https://www.facebook.com/?_rdr");
		google1.addURL("https://twitter.com/");
		
		assertNull(google1.listURLs("dog"));
	}
	
	@Test
	public void testListURLwordFound() throws IOException{
		Organs2 google2 = new Organs2();
		
		google2.addURL("https://www.facebook.com/?_rdr");
		google2.addURL("https://twitter.com/");
		
		assertNotNull(google2.listURLs("sign"));
	}
	
	@Test
	public void testListURLwordFoundActualReturn() throws IOException{
		Organs2 google3 = new Organs2();
	
		google3.addURL("https://www.facebook.com/?_rdr");
		google3.addURL("https://twitter.com/");
		
		ArrayList<String> listReturn = new ArrayList<String>();
		listReturn.add(" URL: https://www.facebook.com/?_rdr");
		listReturn.add(" URL: https://twitter.com/");		// Notice the space at the beginning!
		assertEquals(listReturn, google3.listURLs("sign"));
	}
	
	@Test
	public void testFindURLsWordNotFound() throws IOException{
		Organs2 google4 = new Organs2();
		
		google4.addURL("https://www.facebook.com/?_rdr");
		google4.addURL("https://twitter.com/");
		
		assertNull(google4.findURLs("dog"));
	}
	
	@Test
	public void testFindURLwordFound() throws IOException{
		Organs2 google5 = new Organs2();
		
		google5.addURL("https://www.facebook.com/?_rdr");
		google5.addURL("https://twitter.com/");
		
		assertNotNull(google5.findURLs("sign"));
	}
	
	@Test
	public void testFindURLwordFoundActualReturn() throws IOException{
		Organs2 google6 = new Organs2();
	
		google6.addURL("https://www.facebook.com/?_rdr");
		google6.addURL("https://twitter.com/");
		
		ArrayList<String> findReturn = new ArrayList<String>();
		findReturn.add("\nCount: 6 \n URL: https://www.facebook.com/?_rdr");
		findReturn.add("\nCount: 5 \n URL: https://twitter.com/");
		assertEquals(findReturn, google6.findURLs("sign"));
	}	
}
