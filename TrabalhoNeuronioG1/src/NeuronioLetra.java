public class NeuronioLetra {
	// Neuronio para 2 entradas

	private double w0; // pesos
	private double w1;

	public double getW0() {
		return w0;
	}

	public double getW1() {
		return w1;
	}

	public double calculaV(int x1) {
		return w0 + w1 * x1;
	} // calcula o campo local induzido

	public int calculaY(int x1) { // aplica a função
		double v = calculaV(x1);

		if (v >= 0)
			return 1;
		return 0;
	}

	public void setW0(double w0) {
		this.w0 = w0;
	}

	public void setW1(double w1) {
		this.w1 = w1;
	}

	public String toString() {
		return "w0 = " + w0 + " w1= " + w1;
	}
}
