//Exemplo - Rede Perceptron com apenas 1 neuronio
import static java.lang.Math.*;
import java.util.Scanner;

public class PerceptronRendaDivida {
	public static void main(String args[]) {
		Neuronio neuronio = new Neuronio();

		int x1[] = new int[21]; // 1a entrada
		int x2[] = new int[21]; // 2a entrada
		int d[] = new int[21]; // saida desejada
		int contErros = 0;
		int contAcertos = 0;

		// Conjunto de Treino : renda x dívida

		populaVetores(x1, x2, d);

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
			for (i = 0; i < x1.length; i++) {

				// propagação
				y = neuronio.calculaY(x1[i], x2[i]);

				// calcula do erro
				erro = d[i] - y;

				// ajuste dos pesos
				if (erro != 0) {
					contErros++;
					neuronio.setW0(neuronio.getW0() + eta * erro);
					neuronio.setW1(neuronio.getW1() + eta * erro * x1[i]);
					neuronio.setW2(neuronio.getW2() + eta * erro * x2[i]);
				} else {
					contAcertos++;
				}
				System.out.println("Neuronio - pesos: " + neuronio);
				erroGeral = erroGeral + abs(erro);
			}

			// pára quando para todas as entradas o erro for zero
			if (erroGeral == 0)
				break;
		}
		System.out.println("Total de erros: " + contErros);
		System.out.println("Total de acertos: " + contAcertos);
		
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
			System.out.println("Saida Gerada pela rede: "
					+ neuronio.calculaY(entrada1, entrada2));
		}
	}

	public static void populaVetores(int[] x1, int[] x2, int[] d) {
		
		// Treinamento
		x1[0] = 2800;
		x2[0] = 550;
		d[0] = 1;

		x1[1] = 1300;
		x2[1] = 500;
		d[1] = 0;

		x1[2] = 1400;
		x2[2] = 80;
		d[2] = 1;

		x1[3] = 500;
		x2[3] = 200;
		d[3] = 0;

		x1[4] = 1100;
		x2[4] = 270;
		d[4] = 0;

		x1[5] = 1800;		
		x2[5] = 450;
		d[5] = 1;

		x1[6] = 2400;
		x2[6] = 650;
		d[6] = 1;

		x1[7] = 1950;
		x2[7] = 600;
		d[7] = 1;

		x1[8] = 450;
		x2[8] = 70;
		d[8] = 0;

		x1[9] = 2750;
		x2[9] = 730;
		d[9] = 1;

		x1[10] = 850;
		x2[10] = 90;
		d[10] = 0;

		x1[11] = 1300;
		x2[11] = 200;
		d[11] = 0;

		x1[12] = 2100;
		x2[12] = 750;
		d[12] = 1;

		x1[13] = 900;
		x2[13] = 300;
		d[13] = 0;

		x1[14] = 2700;
		x2[14] = 250;
		d[14] = 1;
		
		// Generalizacao - Teste da rede - Entrada no teclado
		/*
		x1[15] = 1600;
		x2[15] = 500;
		d[15] = 0;

		x1[16] = 1900;
		x2[16] = 150;
		d[16] = 1;

		x1[17] = 2500;
		x2[17] = 800;
		d[17] = 1;

		x1[18] = 1600;
		x2[18] = 700;
		d[18] = 0;

		x1[19] = 2300;
		x2[19] = 500;
		d[19] = 1;

		x1[20] = 2100;
		x2[20] = 250;
		d[20] = 1;
		 */
	}

}
