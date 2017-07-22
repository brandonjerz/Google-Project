/* Zack Sponaugle and Brandon Jerz
 * CSC 213 Search Engine Project
 */

package main_package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map;
import java.io.Serializable; // Since webpage class is notn serializable by default

final class WebPage implements Serializable{

    private int count;	
	private String URL;	

	public WebPage( int count, String URL) {
        this.count = count;
        this.URL = URL;
    }

    public int getCount() {
        return count;
    }

    public String getURL() {
        return URL;
    }

    public void incrementCount() {
        int old = this.count;
        old += 1;
        int newCount = old;
        this.count = newCount;
    }
    
    @Override
    public String toString(){
		return "\nCount: "+getCount() + "\n URL: "+getURL();
    }

}
