package botFils;

import java.util.List;

import twitter4j.HashtagEntity;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

public class BotFils extends Thread {
	for (;;) {
		Boolean Rt = false;
		Twitter twitter = TwitterFactory.getSingleton();
	    List<Status> statuses = twitter.getHomeTimeline();
	    System.out.println("Showing home timeline.");
	    for (Status status : statuses) {
	        if (status.isRetweetedByMe()) continue;
	        long Id = status.getId();
	    	HashtagEntity[] HE = status.getHashtagEntities();
	    	int i = 0;
	    	for (HashtagEntity HEU : HE) {
	    		if(HEU.getText().toLowerCase() == "nuitinfo" | 
	    			HEU.getText().toLowerCase() == "aix")
	    			++i;
	    		if (i == 2) {
	    			twitter.retweetStatus(Id);
	    			Rt = true;
	    		}
	    	}
	        if (Rt == true) break;
	    }
	    if (Rt == true) 
	    	this.sleep(90000);
	    else
	    	this.sleep(10000);
	}
	
	
	
	public static void main(String[] args) {
		BotFils BF = new BotFils();
		BF.run();

	}

}
