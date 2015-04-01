package com.trabalho.reconhece.letra.exercicio7;

//Exemplo - Rede Perceptron com apenas 1 neuronio
import static java.lang.Math.*;

import java.util.Scanner;

public class PerceptronReconheceLetra {

	static NeuronioLetra neuronio1 = new NeuronioLetra();
	static NeuronioLetra neuronio2 = new NeuronioLetra();

	public static void main(String args[]) {

		int letra[][] = new int[4][3]; // ENTRADA

		// Conjunto de Treino : LETRA L
		letra = getPadraoL();
		treinar(letra, 0, neuronio1);
		treinar(letra, 0, neuronio2);

		// Conjunto de Treino : LETRA T
		letra = getPadraoT();
		treinar(letra, 1, neuronio1);
		treinar(letra, 1, neuronio2);

		// Conjunto de Treino : LETRA O
		letra = getPadraoO();
		treinar(letra, 0, neuronio1);
		treinar(letra, 1, neuronio2);

		// Conjunto de Treino : LETRA U
		letra = getPadraoU();
		treinar(letra, 1, neuronio1);
		treinar(letra, 0, neuronio2);

		// Realiza os testes na rede
		testaRede();

	}

	private static void testaRede() {

		int letra[][]; // ENTRADA

		// Generalizacao - Teste da rede
		int entrada1;
		Scanner dados = new Scanner(System.in);
		System.out.println("\n--- GENERALIZACAO");

		while (true) {
			
			int retornoNeuronio1 = -1;
			int retornoNeuronio2 = -1;
			
			// digita novas entradas
			System.out.println("\n*** Digite -100 para encerrar ***");
			System.out.print("DIGITE \n 0 PARA L;\n 1 PARA T;\n 2 PARA O;\n 3 PARA U;\n 4 PARA Z;\nENTRE:_ ");
			entrada1 = dados.nextInt();
			if (entrada1 == -100)
				break;

			if (entrada1 == 0) {
				// TESTA A LETRA L
				letra = getPadraoL();
				retornoNeuronio1 = testaEntrada(letra, neuronio1);
				retornoNeuronio2 = testaEntrada(letra, neuronio2);

			} if (entrada1 == 1) {

				// TESTA A LETRA T
				letra = getPadraoT();
				retornoNeuronio1 = testaEntrada(letra, neuronio1);
				retornoNeuronio2 = testaEntrada(letra, neuronio2);

			} if (entrada1 == 2) {

				// TESTA A LETRA O
				letra = getPadraoO();
				retornoNeuronio1 = testaEntrada(letra, neuronio1);
				retornoNeuronio2 = testaEntrada(letra, neuronio2);

			} if (entrada1 == 3) {

				// TESTA A LETRA U
				letra = getPadraoU();
				retornoNeuronio1 = testaEntrada(letra, neuronio1);
				retornoNeuronio2 = testaEntrada(letra, neuronio2);

			}
			
			if (entrada1 == 4) {

				// TESTA A LETRA T
				letra = getPadraoZ();
				retornoNeuronio1 = testaEntrada(letra, neuronio1);
				retornoNeuronio2 = testaEntrada(letra, neuronio2);

			}
			
			// VERIFICA A SAIDA
			if(retornoNeuronio1 == 0 && retornoNeuronio2 == 0) System.out.println("\nLETRA INFORMADA L");
			if(retornoNeuronio1 == 1 && retornoNeuronio2 == 1) System.out.println("\nLETRA INFORMADA T");
			if(retornoNeuronio1 == 0 && retornoNeuronio2 == 1) System.out.println("\nLETRA INFORMADA O");
			if(retornoNeuronio1 == 1 && retornoNeuronio2 == 0) System.out.println("\nLETRA INFORMADA U");

		}

	}

	public static int testaEntrada(int[][] letra, NeuronioLetra neuronio) {
		// TESTA LETRA DE ENTRADA
		int saida = neuronio.calculaY(letra[0][0], letra[0][1], letra[0][2], letra[1][0],
									  letra[1][1], letra[1][2], letra[2][0], letra[2][1],
									  letra[2][2], letra[3][0], letra[3][1], letra[3][2]);

		return saida;
	}

	public static int[][] getPadraoL() {
		return new int[][] { { 1, 0, 0 }, { 1, 0, 0 }, { 1, 0, 0 }, { 1, 1, 1 } };
	}

	public static int[][] getPadraoT() {
		return new int[][] { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
	}

	public static int[][] getPadraoO() {
		return new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
	}

	public static int[][] getPadraoU() {
		return new int[][] { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
	}
	
	public static int[][] getPadraoZ() {
		return new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
	}

	public static void treinar(int x1[][], int letra, NeuronioLetra neuronio) {

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
				y = neuronio.calculaY(x1[0][0], x1[0][1], x1[0][2], x1[1][0],
						x1[1][1], x1[1][2], x1[2][0], x1[2][1], x1[2][2],
						x1[3][0], x1[3][1], x1[3][2]);

				// calcula do erro
				erro = letra - y;

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

	}

}
