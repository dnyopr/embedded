package myproject;
import lejos.nxt.*;

public class LabLight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LightSensor light = new LightSensor(SensorPort.S3);
		while(true){
			LCD.drawString("gL-value: ", 0, 0);
			LCD.drawInt(light.getLightValue(), 12, 0);
			LCD.drawString("gL-value: ", 0, 1);
			LCD.drawInt(light.getNormalizedLightValue(), 12, 1);
			
		}
	}

}
