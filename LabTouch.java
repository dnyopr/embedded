package myproject;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class LabTouch {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LCD.drawString("LabTouch", 0, 0);
		TouchSensor touch = new TouchSensor(SensorPort.S1);
		while(true){
			Motor.A.setSpeed(2000);
			Motor.A.forward();
			Motor.B.setSpeed(2000);
			Motor.B.forward();
			if(touch.isPressed()){
				LCD.drawString("S1 is Pressed", 2, 3);
				//Button.waitForAnyPress();
				System.exit(0);
			}
		}
		
	}

}
