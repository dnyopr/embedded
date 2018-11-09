package myproject;

import lejos.nxt.*;

public class LabMotor1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCD.drawString("LabMortor 1", 0, 0);
		Motor.A.setSpeed(150);
		Motor.A.forward();
		LCD.drawString("FORWARD: 150", 0, 1);
		Button.waitForAnyPress();
		Motor.A.setSpeed(300);
		Motor.A.backward();
		LCD.drawString("BACKWARD: 300", 0, 1);
		Button.waitForAnyPress();
		Motor.A.stop();
	}

}
