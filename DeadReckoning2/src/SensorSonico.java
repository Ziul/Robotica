import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class SensorSonico extends Thread {

	private int read=0; 
	public SensorSonico() {
	}

	public void run() {
		UltrasonicSensor sonico = new UltrasonicSensor(SensorPort.S4);

		while (true) {
			sonico.continuous();
			this.read = sonico.getDistance();
			if (this.read !=0) {
				try {
					Thread.sleep(100);
					LCD.drawString(""+this.read,0,5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
