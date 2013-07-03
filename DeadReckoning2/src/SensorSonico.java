import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

public class SensorSonico extends UltrasonicSensor implements Runnable {

	//MovimentacaoBasica movimento;

	public SensorSonico() {
		super(SensorPort.S4);
	}

//	public SensorSonico(MovimentacaoBasica movimento) {
//		super(SensorPort.S4);
//		this.movimento = movimento;
//	}

	/*
	 * Thread para leitura do sensor sonico caso haja algum obstaculo o robo
	 * fara um retangulo de 30 cm de largura e 50 cm de altura para contorna-lo
	 * e voltará a posição inicial(eu espero)
	 */
	public void run() {
		while (true) {
			continuous();
			if (getDistance() < 25) {
				Robo.movimento.girarAngulo(-90);
				Robo.movimento.moverParaFrente(30);
				Robo.movimento.girarAngulo(90);
				Robo.movimento.moverParaFrente(30);
				Robo.movimento.girarAngulo(90);
				Robo.movimento.moverParaFrente(30);
				Robo.movimento.girarAngulo(-90);
			}
		}
	}

}
