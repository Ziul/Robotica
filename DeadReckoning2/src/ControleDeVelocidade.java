import lejos.nxt.Battery;
import lejos.nxt.Button;

public class ControleDeVelocidade extends Thread {

	private int velocidadeAtual = 100;
	private final int pad = 20;

	public ControleDeVelocidade() {

	}

	// Thread para permitir o controle de velocidade nos botões
	public void run() {

		while (true) {
			if (Button.ESCAPE.isDown()) {
				System.exit(0);
			}
			if (Button.RIGHT.isDown()) {
				if (velocidadeAtual + pad < Battery.getVoltage() * 100) {
					velocidadeAtual += pad;
				}
			}

			if (Button.LEFT.isDown()) {
				if (velocidadeAtual - pad > 0) {
					velocidadeAtual -= pad;
				}
			}

		}
	}
}
