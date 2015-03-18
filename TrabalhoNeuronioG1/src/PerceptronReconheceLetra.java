//Exemplo - Rede Perceptron com apenas 1 neuronio
import static java.lang.Math.*;
import java.util.Scanner;

public class PerceptronReconheceLetra {
	public static void main(String args[]) {

		NeuronioLetra neuronio = new NeuronioLetra();

		int X1[][] = new int[4][3]; // ENTRADA
		int D[][] = new int[4][3]; // SAÍDA

		// Conjunto de Treino : LETRA L
		X1[0][0] = 1;
		X1[0][1] = 0;
		X1[0][2] = 0;

		X1[1][0] = 1;
		X1[1][1] = 0;
		X1[1][2] = 0;

		X1[2][0] = 1;
		X1[2][1] = 0;
		X1[2][2] = 0;

		X1[3][0] = 1;
		X1[3][1] = 1;
		X1[3][2] = 1;

		// SAÍDA
		D[0][0] = 1;
		D[0][1] = 0;
		D[0][2] = 0;

		D[1][0] = 1;
		D[1][1] = 0;
		D[1][2] = 0;

		D[2][0] = 1;
		D[2][1] = 0;
		D[2][2] = 0;

		D[3][0] = 1;
		D[3][1] = 1;
		D[3][2] = 1;

		// Treinamento
		int epocas = 0, i, j;
		double y, erro, erroGeral;
		double eta = 1d;
		// eta é a constante (taxa) de aprendizagem

		System.out.println("--- TREINAMENTO LETRA L");
		while (true) {
			epocas++;
			erroGeral = 0;

			System.out.println("Epoca: " + epocas);

			// PERCORRE AS LINHAS
			for (i = 0; i < 4; i++) {

				for (j = 0; j < 3; j++) {

					// propagação
					y = neuronio.calculaY(X1[i][j]);

					// calcula do erro
					erro = D[i][j] - y;

					// ajuste dos pesos
					if (erro != 0) {
						neuronio.setW0(neuronio.getW0() + eta * erro);
						neuronio.setW1(neuronio.getW1() + eta * erro * X1[i][j]);
					}
					System.out.println("Neuronio - pesos: " + neuronio);
					erroGeral = erroGeral + abs(erro);

				}

			}

			// pára quando para todas as entradas o erro for zero
			if (erroGeral == 0)
				break;
		}

		// Conjunto de Treino : LETRA T
		X1[0][0] = 1;
		X1[0][1] = 1;
		X1[0][2] = 1;

		X1[1][0] = 0;
		X1[1][1] = 1;
		X1[1][2] = 0;

		X1[2][0] = 0;
		X1[2][1] = 1;
		X1[2][2] = 0;

		X1[3][0] = 0;
		X1[3][1] = 1;
		X1[3][2] = 0;

		// SAÍDA
		D[0][0] = 1;
		D[0][1] = 1;
		D[0][2] = 1;

		D[1][0] = 0;
		D[1][1] = 1;
		D[1][2] = 0;

		D[2][0] = 0;
		D[2][1] = 1;
		D[2][2] = 0;

		D[3][0] = 0;
		D[3][1] = 1;
		D[3][2] = 0;

		System.out.println("--- TREINAMENTO LETRA T");
		while (true) {
			epocas++;
			erroGeral = 0;

			System.out.println("Epoca: " + epocas);

			// PERCORRE AS LINHAS
			for (i = 0; i < 4; i++) {

				for (j = 0; j < 3; j++) {

					// propagação
					y = neuronio.calculaY(X1[i][j]);

					// calcula do erro
					erro = D[i][j] - y;

					// ajuste dos pesos
					if (erro != 0) {
						neuronio.setW0(neuronio.getW0() + eta * erro);
						neuronio.setW1(neuronio.getW1() + eta * erro * X1[i][j]);
					}
					System.out.println("Neuronio - pesos: " + neuronio);
					erroGeral = erroGeral + abs(erro);

				}

			}

			// pára quando para todas as entradas o erro for zero
			if (erroGeral == 0)
				break;
		}

		// Generalizacao - Teste da rede
		int entrada1, entrada2;
		Scanner dados = new Scanner(System.in);
		System.out.println("\n--- GENERALIZACAO");

		// TESTANDO A REDE
		X1[0][0] = 1;
		X1[0][1] = 0;
		X1[0][2] = 0;

		X1[1][0] = 1;
		X1[1][1] = 0;
		X1[1][2] = 0;

		X1[2][0] = 1;
		X1[2][1] = 0;
		X1[2][2] = 0;

		X1[3][0] = 0;
		X1[3][1] = 0;
		X1[3][2] = 0;

		// PERCORRE AS LINHAS
		for (i = 0; i < 4; i++) {

			for (j = 0; j < 3; j++) {
				// propagação
				System.out.println("Saida POS: "+ i + "-"+ j + " = " + neuronio.calculaY(X1[i][j]));
			}
		}

	}
}
