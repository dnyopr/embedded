package myproject;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class LabUltrasonic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UltrasonicSensor UltraSonic = new UltrasonicSensor(SensorPort.S4);
		while (!Button.ENTER.isDown()){
			LCD.drawString("Distance cm: ", 0, 0);
			LCD.drawInt(UltraSonic.getDistance(), 4, 0, 1);
			if(UltraSonic.getDistance()>25){
				Motor.A.stop();
			}else{
				Motor.A.setSpeed(1000);
				Motor.A.forward();
			}
		}

	}

}
