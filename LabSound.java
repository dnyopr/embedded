package myproject;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;

public class LabSound {

	/**
	 * @param args
	 */
	private static int soundThreshold = 90;
    private static SoundSensor sound = new SoundSensor(SensorPort.S2);
	
    private static  void waitForLoudSound() throws Exception
    {
        int soundLevel;

        Thread.sleep(500);
        do
        {
            soundLevel = sound.readValue();
            LCD.drawInt(soundLevel,4,10,0); 
        }
        while ( soundLevel < soundThreshold );
    }
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		 LCD.drawString("dB level: ",0,0);
	        LCD.refresh();
		   	   
	        while (!Button.ENTER.isDown())
	        {
	            waitForLoudSound();		    			   
	            LCD.drawString("Forward ",0,1);
	            Motor.A.forward();
	       }
	       Motor.A.stop();
	       LCD.clear();
	       LCD.drawString("Program stopped", 0, 0);
	       Thread.sleep(2000); 

	}

}
