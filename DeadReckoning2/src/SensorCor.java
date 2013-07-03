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
			LCD.drawString("Color: "+vals.getColor(), 0, 6);
			//LCD.asyncRefresh();
			if(vals.getColor()==7){
				Robo.movimento.pararInstantaneamente();
			}
			else{
			}
		}
	}

}
