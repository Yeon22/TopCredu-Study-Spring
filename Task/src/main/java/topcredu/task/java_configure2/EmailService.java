package topcredu.task.java_configure2;

public class EmailService implements MessageService {

	@Override
	public boolean sendMessage(String msg, String rec) {
		System.out.println("Email Sent to" + rec + " with Message=" + msg);
		return true;
	}

}
