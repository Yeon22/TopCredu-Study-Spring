package topcredu.task.java_configure2;


public class TwitterService implements MessageService {

	@Override
	public boolean sendMessage(String msg, String rec) {
		System.out.println("Twitter message Sent to = " + rec + " with Message = " + msg);
		return true;
	}

}
