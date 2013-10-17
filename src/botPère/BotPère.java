package botPère;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

public class BotPère extends Thread {
	for (;;) {
		
	
	Twitter twitter = TwitterFactory.getSingleton();
    Status status = twitter.updateStatus("Lolilol");
    System.out.println("Successfully updated the status to [" + status.getText() + "].");
    this.sleep(90000);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BotPère BP = new BotPère();
		BP.run();
	}

}
