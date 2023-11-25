/*******************************************************
 Programa 50+ Ada & Núclea
 Etapa de formação
 Projeto para Multiplicação de Matrizes Quadradas
 Evandro Francisco
 Novembro de 2023 - v1
 *********************************************************/

import java.util.Scanner;
import java.util.Random;

public class MultiplicaMatrizesQuadradas {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        boolean sair = false;
        final int maxElemento = 9;
        final int minElemento = -9;

        while (!sair) {
            System.out.println();
            System.out.println("-----------------------------------");
            System.out.println("MULTIPLICAÇÃO DE MATRIZES QUADRADAS");
            System.out.println("-----------------------------------");
            System.out.println();
            System.out.print("Informar a dimensão da matriz (0 para sair): ");
            int dim = 0;
            boolean erro = true;
            while (erro) {
                while (!teclado.hasNextInt()) {
                    System.out.print("Dado inválido! Tente novamente: ");
                    teclado.next();
                }
                dim = teclado.nextInt();
                if (dim>=0) {
                    erro = false;
                } else {
                    System.out.print("Você deve entrar com um número inteiro e positivo: ");
                }
            }

            if (dim == 0) {
                sair = true;
            } else {
                int[][] a = new int[dim][dim];
                int[][] b = new int[dim][dim];
                int[][] c = new int[dim][dim];

                a = preencheMatriz(a, maxElemento, minElemento);
                b = preencheMatriz(b, maxElemento, minElemento);

                System.out.println("Matrizes:");
                System.out.println(" A = ");
                mostraMatriz(a);
                System.out.println();
                System.out.println(" B = ");
                mostraMatriz(b);

                System.out.println();
                System.out.println(" A x B = ");
                c = multiplicaMatriz(a, b);
                mostraMatriz(c);
                System.out.println();
                System.out.print("Precione qualquer tecla e <ENTER> para continuar...");
                teclado.next();

            }
        }
        System.out.println("Fim do programa.");
    }

    public static int[][] multiplicaMatriz(int[][] a, int[][] b) {
        int contaOperacao = 0;
        int[][] c = new int[a.length][a[0].length];
        for (int lin=0; lin < a.length; lin++){
            for (int col=0; col < b[0].length; col++){
                for (int ind = 0; ind < b[0].length; ind++) {
                    c[lin][col] += a[lin][ind] * b[ind][col];
                    contaOperacao++;
                }
            }
        }
        System.out.printf("(%,d operações realizadas)\n",contaOperacao);
        return(c);
    }
    public static int[][] preencheMatriz(int[][] m, int maxElemento, int minElemento) {
        Random randomico = new Random();
        for (int lin=0; lin < m.length; lin++) {
            for (int col=0; col < m[0].length; col++) {
                int numero = randomico.nextInt((maxElemento-minElemento+1)+minElemento);
                numero *= (randomico.nextBoolean() ? -1 : 1);   // por algum motivo não vinham valores negativos
                m[lin][col] = numero;
            }
        }
        return(m);
    }

    public static void mostraMatriz(int[][] m) {
        for (int lin=0; lin < m.length; lin++) {
            for (int col=0; col < m[0].length; col++) {
                System.out.printf("\t %5d",m[lin][col]);
            }
            System.out.println();
        }
    }

}
