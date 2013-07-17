import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;


public class SensorCor implements Runnable{
	
//	public SensorCor(MovimentacaoBasica movimento){
//		this.movimento = movimento;
//	}
	
	
	
	@Override
	public void run() {
		ColorSensor cs = new ColorSensor(SensorPort.S3);
		while(true){
			ColorSensor.Color vals = cs.getColor();
			StringBuffer read =new StringBuffer( "Color: "+vals.getColor());
			LCD.drawString(read.substring(0), 0, 6);
			read.delete(0, read.length());
		}
	}

}
