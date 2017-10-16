package helpers;

public class EmailGenerator {

	// Using Timestamp to generate unique email id every time for signup
	public static long getCurrentTime() {
		java.util.Date date = new java.util.Date();
		long uus = date.getTime();
		return uus;
	}
}
