package at.ac.tuwien.swa;

import java.io.File;
import java.util.Date;


public class ServerConnection {
	
	private Integer coins;
	

	public ServerConnection() {
		super();
	}
	
	public boolean verifyLogin(String username, char[] password) {
		
		return true;
	}
	
	public void logout() {
		
	}
	
	public String[] createFingerprint(File file) {

		String[] test = new String[4];
		
		//song name
		test[0] = "Paint It Black";
		//author
		test[1] = "The Rolling Stones";
		//duration
		test[2] = "3m 47s";
		//tags
		test[3] = "rock, classic, pop, hit, rolling stones, paint it black";
		
		return test;
	}
	
	public void update() {
		
	}
	
	public Object[][] getHistory() {
		
		 Object[][] data = {
	        		{
	        			new Date(),	new Integer(2296), new Integer(2196),
	        			"Somefile.mp3", "The Rolling Stones - Paint It Black"
	        		}
	        };
		 return data;
	}
	
	public Integer getCoins() {
		
		return this.coins;
	}
	
}
