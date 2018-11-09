package myproject;
import lejos.nxt.*;

public class LabMotor3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCD.drawString("LacMotor 3", 0, 1);
		Button.waitForAnyPress();
		LCD.clear();
		Motor.A.rotate(90);
		LCD.drawInt(Motor.A.getTachoCount(), 0, 0);

		Motor.B.rotate(90);
		LCD.drawInt(Motor.B.getTachoCount(), 0, 0);
		Motor.A.rotateTo(0);
		LCD.drawInt(Motor.A.getTachoCount(), 0, 1);
		Button.waitForAnyPress();
		for(;;){
			MotorPort.A.controlMotor(80, 1);
			if(Motor.A.getTachoCount()>2000){
				MotorPort.A.controlMotor(0, 4);
				Button.waitForAnyPress();
				MotorPort.A.resetTachoCount();
			}
			LCD.drawString("Motor A: ", 0, 2);
			LCD.drawInt(MotorPort.A.getTachoCount(), 10, 2);
			LCD.refresh();
		}
	}

}
