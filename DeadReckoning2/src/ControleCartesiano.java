public class ControleCartesiano {

	public ControleCartesiano() {
	}

	// Classe para calculos de distancia entre pontos e os angulos
	public float calcularDistancia(float X, float Y, float X1, float Y1) {
		float dist;
		float som;
		som = (float) (Math.pow(X1 - X, 2) + Math.pow(Y1 - Y, 2));
		dist = (float) Math.sqrt(som);
		return dist;
	}

	public float calcularAngulo(float X, float Y, float X1, float Y1) {
		float angulo;
		float div;

		div = (Y - Y1) / (X - X1);

		angulo = (float) Math.atan(div);
		angulo = (float) ((angulo * 180) / Math.PI);
		return angulo;
	}

}
