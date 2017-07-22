/* Zack Sponaugle and Brandon Jerz
 * CSC 213 Search Engine Project
 */

package main_package;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import edu.canisius.linear.Queue;
import edu.canisius.linear.Sequence;
import edu.canisius.web.WebPageParser;

public class Organs2 {
	
	public static HashMap<String, ArrayList<WebPage>> finalHashMap = new HashMap<String, ArrayList<WebPage>>();
	public static ArrayList<String> urlList = new ArrayList<String>();
	
	//public static Sequence results = new Sequence();
	//public static Queue workList = new Queue();
	
	/** ADD Prompt the user for a URL. Your program will need to create an instance of WebPageParser for this URL and then 
	 * call its getText() method to get the text on the page. You will then need to process each word on the page so that 
	 * its contents will be part of your final Dictionary of results (i.e., process each web page like you processed the 
	 * lines of text in the Google lab.)
	 * @param inputURL 
	 * @return 
	 * @throws IOException 
	 */
	public static void addURL(String inputURL) throws IOException{	// changed to static for testing
		
		if (urlList.contains(inputURL)){
			System.out.println("That URL is already in the database.");
		}
		
		else {
		WebPageParser parser;
		parser = new WebPageParser(inputURL);
		System.out.println(parser.getText());	// getText returns an Iterable string list. The list is all the words found on the given URL.
		Iterator<String> iter = parser.getText().iterator();
		
		while (iter.hasNext()){
			String word = iter.next();
			
			if((finalHashMap.containsKey(word))){	// if fHM already contains that word
					boolean webpageFound = false;
				
					ArrayList<WebPage> WebPageList = finalHashMap.get(word);	
					for (int i = 0 ; i < WebPageList.size(); i++){
						if (WebPageList.get(i).getURL().equals(inputURL)) {		// if that particular webpage has already added that word
							WebPageList.get(i).incrementCount();
							webpageFound = true;
						}
					}
					
					if (webpageFound == false) {
						WebPage wp = new WebPage(1, inputURL);
						finalHashMap.get(word).add(wp);
					}
					continue;		
			} // end if
			else{	// else, fHM does not contain that word at all
				WebPage url;
				url = new WebPage(1, inputURL);
				
				ArrayList<WebPage> newList = new ArrayList<WebPage>();
				newList.add(url);
				finalHashMap.put(word, newList);
			} // end else
		} // end while
		urlList.add(inputURL);
		} // end else

	}
		
	
	/** LIST Prompt the user to enter a word to search for. You will then need to scan the Dictionary(s) containing the 
	 * searchable data to find all of the web pages (e.g., URLs) it has processed that contain the word the user entered. 
	 * Your program will need to display in a JTextArea the URL of each page that contains that word. EACH URL SHOULD 
	 * APPEAR AT MOST ONCE. DO NOT PRINT OUT THE NUMBER OF TIMES THAT THE WORD APPEARED ON PAGE.
	 * @return 
	 */
	public ArrayList<String> listURLs(String wordInput) {	
		if(finalHashMap.containsKey(wordInput) == false){
			System.out.println("TESTING (list URL method): The word '" + wordInput + "' is not found in any of the URLs.");
			return null;
		}
		else{
			ArrayList<String> listReturn = new ArrayList<String>();
			ArrayList<WebPage> WebPageList2 = finalHashMap.get(wordInput);	// Create a list of the webpage values associated with the wordInput key
			for (int i = 0 ; i < WebPageList2.size(); i++){
				String partial = WebPageList2.get(i).toString();
				String[] parts = partial.split("\\r?\\n");
				String part3 = parts[2];
				listReturn.add(part3);
			}
			System.out.println("listReturn:" + listReturn);
			return listReturn;		// Returns a list of WebPage objects the word was found on
		}
	}
	
	/** FIND Prompt the user to enter a word to search for. You will then need to scan the Dictionary(s) containing the 
	 * searchable data to find all of the web pages containing the word the user entered. Your program will need to display 
	 * in a JTextArea the URL of each match and the number of times that the word is found on that page.
	 * @return 
	 */
	public ArrayList<String> findURLs(String findWordInput){	
		
		if (finalHashMap.containsKey(findWordInput) == false){	// if the finalHashMap doesn't contain the word in the first place
			System.out.println("TESTING (find URL method): The word '" + findWordInput + "' is not found in any of the URLs.");
			return null;
		}
		else{	
			ArrayList<String> findReturn = new ArrayList<String>();
			ArrayList<WebPage> WebPageList2 = finalHashMap.get(findWordInput);	// Create a list of the webpage values associated with the wordInput key
			for (int i = 0 ; i < WebPageList2.size(); i++){
				String partial = WebPageList2.get(i).toString();
				findReturn.add(partial);
			}
			System.out.println("TESTING findReturn: " + findReturn);
			
			return findReturn;
		}
	}
	
	/** REMOVE Prompt the user to enter the URL of the page that should no longer be included in the search results. 
	 * You will then need to scan the Dictionary(s) containing the searchable data to REMOVE all of the search results 
	 * for that page.
	 */
	public void remove(String URLinput){		//Removed static
		
		for (String key: finalHashMap.keySet()){
			ArrayList<WebPage> WebPageList = finalHashMap.get(key);	
			for (int i = 0 ; i < WebPageList.size(); i++){
				if (WebPageList.get(i).getURL().equals(URLinput)){
					WebPageList.remove(i);
				}
			}
		}
	}
	
	/** The program should end. */
	
	public static void quit(){		// TODO
		//Written in GUI method
	}

}
