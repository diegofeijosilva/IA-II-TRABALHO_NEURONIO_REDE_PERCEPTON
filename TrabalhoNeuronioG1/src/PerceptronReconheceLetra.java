//Exemplo - Rede Perceptron com apenas 1 neuronio
import static java.lang.Math.*;

import java.util.Scanner;

public class PerceptronReconheceLetra {
	public static void main(String args[]) {

		NeuronioLetra neuronio = new NeuronioLetra();

		int x1[][] = new int[4][3]; // ENTRADA
		int D[][] = new int[4][3]; // SAÍDA

		// Conjunto de Treino : LETRA L
		x1[0][0] = 1;
		x1[0][1] = 0;
		x1[0][2] = 0;

		x1[1][0] = 1;
		x1[1][1] = 0;
		x1[1][2] = 0;

		x1[2][0] = 1;
		x1[2][1] = 0;
		x1[2][2] = 0;

		x1[3][0] = 1;
		x1[3][1] = 1;
		x1[3][2] = 1;

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
		int epocas = 0, i;
		double y, erro, erroGeral;
		double eta = 1d;
		// eta é a constante (taxa) de aprendizagem

		System.out.println("--- TREINAMENTO");
		while (true) {
			epocas++;
			erroGeral = 0;

			System.out.println("Epoca: " + epocas);
			for (i = 0; i < 1; i++) {

				// propagação
				y = neuronio.calculaY(  x1[0][0], x1[0][1], x1[0][2], 
										x1[1][0], x1[1][1], x1[1][2], 
										x1[2][0], x1[2][1], x1[2][2], 
										x1[3][0], x1[3][1], x1[3][2]);

				// calcula do erro
				erro = 1 - y;

				// ajuste dos pesos
				if (erro != 0) {
					neuronio.setW0(neuronio.getW0() + eta * erro);
					
					neuronio.setW1(neuronio.getW1() + eta * erro * x1[0][0]);
					neuronio.setW2(neuronio.getW2() + eta * erro * x1[0][1]);
					neuronio.setW3(neuronio.getW3() + eta * erro * x1[0][2]);
					
					neuronio.setW4(neuronio.getW4() + eta * erro * x1[1][0]);
					neuronio.setW5(neuronio.getW5() + eta * erro * x1[1][1]);
					neuronio.setW6(neuronio.getW6() + eta * erro * x1[1][2]);
					
					neuronio.setW7(neuronio.getW7() + eta * erro * x1[2][0]);
					neuronio.setW8(neuronio.getW8() + eta * erro * x1[2][1]);
					neuronio.setW9(neuronio.getW9() + eta * erro * x1[2][2]);
					
					neuronio.setW10(neuronio.getW10() + eta * erro * x1[3][0]);
					neuronio.setW11(neuronio.getW11() + eta * erro * x1[3][1]);
					neuronio.setW12(neuronio.getW12() + eta * erro * x1[3][2]);
					
				}
				System.out.println("Neuronio - pesos: " + neuronio);
				erroGeral = erroGeral + abs(erro);
			}

			// pára quando para todas as entradas o erro for zero
			if (erroGeral == 0)
				break;
		}

		// Generalizacao - Teste da rede
		int entrada1, entrada2;
		Scanner dados = new Scanner(System.in);
		System.out.println("\n--- GENERALIZACAO");

		while (true) {
			// digita novas entradas
			System.out.println("Digite -100 para encerrar");
			System.out.print("Digite a entrada (x1): ");
			entrada1 = dados.nextInt();
			if (entrada1 == -100)
				break;

			System.out.print("Digite a entrada (x2): ");
			entrada2 = dados.nextInt();
			if (entrada2 == -100)
				break;

			// propagação
			//System.out.println("Saida Gerada pela rede: "+ neuronio.calculaY(entrada1, entrada2));
		}

	}
}
