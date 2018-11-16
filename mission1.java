package mission;

import lejos.nxt.*;

public class mission1 {

	/**
	 * @param args
	 */
	
	private static int soundThreshold = 60;
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
	
    
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LCD.drawString("dB level: ",0,0);
        LCD.refresh();
        
        boolean turn = false;
                                             
        while(true){

    		LightSensor light = new LightSensor(SensorPort.S3);
        	waitForLoudSound();
    	
        	while (!Button.ENTER.isDown())
        	{ 	
            	LCD.drawString("Forward ",0,1);
    			LCD.drawString("gL-value: ", 0, 2);
    			LCD.drawInt(light.getLightValue(), 12, 2);
    			LCD.drawString("gN-value: ", 0, 3);
    			LCD.drawInt(light.getNormalizedLightValue(), 12, 3);
    			

            	if(light.getNormalizedLightValue() < 400){
            		turn = true;
            	}
            	while(turn){
            		light = new LightSensor(SensorPort.S3);
                	LCD.drawString("Forward ",0,1);
        			LCD.drawString("gL-value: ", 0, 2);
        			LCD.drawInt(light.getLightValue(), 12, 2);
        			LCD.drawString("gN-value: ", 0, 3);
        			LCD.drawInt(light.getNormalizedLightValue(), 12, 3);

            		Motor.B.stop();
        			Motor.A.rotate(450);
        			turn =false;
            	}
            	Motor.A.setSpeed(300);
    			Motor.A.forward();
    			Motor.B.setSpeed(300);
    			Motor.B.forward();
    	   				 
       }
        
       Motor.A.stop();
       Motor.B.stop();
       LCD.clear();
       LCD.drawString("Program stopped", 0, 0);
       Thread.sleep(2000); 
       }

	}

}
