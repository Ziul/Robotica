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
			if(vals.getColor()==7){
				Robo.movimento.pararInstantaneamente();
				Robo.movimento.moverParaFrente(7);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else{
			}
			read.delete(0, read.length());
		}
	}

}
