package Flipkart.genericUtility;
import java.util.Date;
import java.util.Random;
/**
 * 
 * @author Rameshwar
 *
 */
public class JavaUtility {
	/**
	 * it is used to genrate random number
	 * 
	 * @return int data
	 * 
	 */
	public int getRandomNumber() {
		Random random = new Random();
		int intranNum = random.nextInt(10000);
		return intranNum;
	}
	/**
	 * 
	 * used to get system data and time in IST Format
	 * 
	 * @return
	 */
	public String getSystemDateandTime() {
		Date date = new Date();
		return date.toString();
	}
	public String getSystemDateWithFormatt() {
		Date date = new Date();
		String dateAndTime = date.toString();
		String YYYY = dateAndTime.split("")[5];
		String DD = dateAndTime.split("")[2];
		int MM = date.getMonth() + 1;
		String finalFormatt = YYYY + "-" + MM + "-" + DD;
		return finalFormatt;
	}
}
