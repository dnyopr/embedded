package myproject;
import lejos.nxt.Button;
import lejos.nxt.LCD;

public class LabLCD {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LCD.drawString("Hello There", 0, 0);
		LCD.drawInt((int) 500, 0, 1);
		Button.waitForAnyPress();
		Thread.sleep(1000);
	}
}
