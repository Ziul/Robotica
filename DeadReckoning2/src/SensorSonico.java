import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class SensorSonico extends Thread {

	public SensorSonico() {
	}


	/*
	 * Thread para leitura do sensor sonico caso haja algum obstaculo o robo
	 * fara um retangulo de 30 cm de largura e 50 cm de altura para contorna-lo
	 * e voltar� a posi��o inicial(eu espero)
	 */
	public void run() {
		UltrasonicSensor sonico = new UltrasonicSensor(SensorPort.S4);

		while (true) {
			sonico.continuous();
			// instancia
			StringBuffer read =new StringBuffer( ""+sonico.getDistance());
				try {
					Thread.sleep(100);
					LCD.drawString(read.substring(0) ,0,0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			// deleta instancia
			read.delete(0, read.length());

		}	
	}

}
