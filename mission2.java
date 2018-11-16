package mission;

import lejos.nxt.*;

public class mission2 {

	/**
	 * @param args
	 */private static int soundThreshold = 60;
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
	                                             
	        while(true){

	    		LightSensor light = new LightSensor(SensorPort.S3);
	        	waitForLoudSound();
	        	TouchSensor touch = new TouchSensor(SensorPort.S1);
	    	
	        	while (!touch.isPressed())
	        	{ 	
	    			UltrasonicSensor UltraSonic = new UltrasonicSensor(SensorPort.S4);
	    			
	        		LCD.drawString("gN-value: ", 0, 1);
        			LCD.drawInt(light.getNormalizedLightValue(), 12, 1);
        			LCD.drawString("dist: ", 0, 2);
        			LCD.drawInt(UltraSonic.getDistance(), 12, 2);

                	
	    			if(UltraSonic.getDistance()<40){
        				Motor.A.setSpeed(50);
        				Motor.B.setSpeed(50);
        			}else{
	    			Motor.A.setSpeed(250);
        			Motor.B.setSpeed(250);}
	    			Motor.A.forward();
	    			Motor.B.forward();
	    			
	            	while(light.getNormalizedLightValue() > 400){
	            		
	        			Motor.A.stop();
	            		Motor.B.setSpeed(100);
	            		Motor.B.forward();
	            		
	            	}
	        	}
	        
		       Motor.A.stop();
		       Motor.B.stop();
		       System.exit(0);
	       }

		}

}
