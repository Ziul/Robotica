import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class MovimentacaoBasica {
	
	private float diametroDaRoda = (float) 4.15; 
	private float tamanhoDoEixo =  (float) 10.05;
	DifferentialPilot rotator = new DifferentialPilot(diametroDaRoda, tamanhoDoEixo, Motor.B,
			Motor.C);

	public MovimentacaoBasica() {
	}

	public synchronized void  moverParaFrente(double dist) {
		rotator.setTravelSpeed(8);
		rotator.travel(dist);
	}

	public void moverParaTras() {
		Motor.B.backward();
		Motor.C.backward();
	}

	public void pararInstantaneamente() {
		Motor.B.stop(true);
		Motor.C.stop(true);
	}

	public void definirVelocidade(int velocidade) {
		Motor.B.setSpeed(velocidade);
		Motor.C.setSpeed(velocidade);
		rotator.setRotateSpeed(velocidade);
	}

	
	public void girarAngulo(float angulo){
		rotator.arc(0, angulo);
	}
	
	public float qtdPercorrida(){
		return rotator.getMovement().getDistanceTraveled();
	}
}
