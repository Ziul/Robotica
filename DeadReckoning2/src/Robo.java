import java.util.ArrayList;

import lejos.nxt.Button;
import lejos.nxt.LCD;

public class Robo {
static MovimentacaoBasica movimento = new MovimentacaoBasica();

	// Inicialização da thread de controle de velocidade nos botões
	ControleDeVelocidade controleVel = new ControleDeVelocidade();
	Thread controleVelocidade = new Thread(controleVel);

	// Inicialização da thread de leitura do sensor sonico
	SensorSonico senSonic = new SensorSonico();
	Thread sensorSonico = new Thread(senSonic);

	// Inicialização da thread de leitura da cor
	SensorCor senCor = new SensorCor();
	Thread sensorCor = new Thread(senCor);

	// Instanciação dos objetos com as respectivas coordenadas medidas
	ControleCartesiano controle = new ControleCartesiano();
	Coordenadas coordenadas1 = new Coordenadas(0, 0);
	Coordenadas coordenadas2 = new Coordenadas(15, 68);
	Coordenadas coordenadas3 = new Coordenadas(43.5, 129.73);
	Coordenadas coordenadas4 = new Coordenadas(115, 83);
	
	
	public void funcionaRobo() throws InterruptedException {
		// Impressão do resultado do calculo de coordenadas no LCD
		LCD.setAutoRefresh(true);
		LCD.clear();
		LCD.drawString(
				" "
						+ controle.calcularAngulo(coordenadas1.getX(),
								coordenadas1.getY(), coordenadas2.getX(),
								coordenadas2.getY()), 0, 1);
		LCD.drawString(
				" "
						+ controle.calcularDistancia(coordenadas1.getX(),
								coordenadas1.getY(), coordenadas2.getX(),
								coordenadas2.getY()), 0, 2);
		LCD.drawString(
				" "
						+ (90 - controle.calcularAngulo(coordenadas2.getX(),
								coordenadas2.getY(), coordenadas3.getX(),
								coordenadas3.getY())), 0, 3);

		//LCD.asyncRefresh();

		
		while (!Button.ESCAPE.isDown()) {

			controleVelocidade.start();
		//	sensorSonico.start();
		//	sensorCor.start();

			// Inicio da movimentação para cumprir o percurso
			movimento.girarAngulo(90 - controle.calcularAngulo(
					coordenadas1.getX(), coordenadas1.getY(),
					coordenadas2.getX(), coordenadas2.getY()));
			movimento.moverParaFrente(controle.calcularDistancia(
					coordenadas1.getX(), coordenadas1.getY(),
					coordenadas2.getX(), coordenadas2.getY()));
	
			movimento.girarAngulo(-(90 - controle.calcularAngulo(
					coordenadas1.getX(), coordenadas1.getY(),
					coordenadas2.getX(), coordenadas2.getY())));

			movimento.girarAngulo(90 - controle.calcularAngulo(
					coordenadas2.getX(), coordenadas2.getY(),
					coordenadas3.getX(), coordenadas3.getY()));
			movimento.moverParaFrente(controle.calcularDistancia(
					coordenadas2.getX(), coordenadas2.getY(),
					coordenadas3.getX(), coordenadas3.getY()));
			
			movimento.girarAngulo(-(90 - controle.calcularAngulo(
					coordenadas2.getX(), coordenadas2.getY(),
					coordenadas3.getX(), coordenadas3.getY())));
			movimento.girarAngulo(90 - controle.calcularAngulo(
					coordenadas3.getX(), coordenadas3.getY(),
					coordenadas4.getX(), coordenadas4.getY()));
			movimento.moverParaFrente(controle.calcularDistancia(
					coordenadas3.getX(), coordenadas3.getY(),
					coordenadas4.getX(), coordenadas4.getY()));

			controleVelocidade.interrupt();
		//sensorSonico.interrupt();
		//	sensorCor.interrupt();
			
		}
	}
}
