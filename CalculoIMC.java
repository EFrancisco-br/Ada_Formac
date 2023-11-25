/*******************************************************
Programa 50+ Ada & Núclea
Etapa de formação
Desafio 03 - Cálculo do IMC, Classificação e Peso Ideal
Evandro Francisco
Novembro de 2023 - v2
*********************************************************/

import java.util.Scanner;
import java.lang.Math;

public class CalculoIMC {

    public static void main(String[] args) {

        final double idealIMC = 24.90;

        Scanner entrada = new Scanner(System.in);
        System.out.println("[  CÁLCULO DO IMC, CLASSIFICAÇÃO E PESO  ]");
        System.out.print("Entre com a sua altura em metros (m).: ");
        while (!entrada.hasNextDouble()){
            System.out.print("Altura inválida! Tente novamente: ");
            entrada.next();
        }
        double altura = entrada.nextDouble();
        System.out.print("Entre com o seu peso em quilos (kg)..: ");
        while (!entrada.hasNextDouble()){
            System.out.print("Peso inválido! Tente novamente: ");
            entrada.next();
        }
        double peso = entrada.nextDouble();

        double imc = peso / Math.pow(altura,2);
        System.out.printf("-> O seu IMC é %.1f kg/m².\n", imc);

        ClassificaIMC classifica = getClassificaIMC(imc);

        System.out.println("-> Classificação: " + classifica.nome);

        double pesoIdeal = calculaPeso(altura,idealIMC);
        System.out.printf("-> O seu peso ideal é de %.1f kg.\n", pesoIdeal);

        System.out.printf("-> O seu peso ideal está entre %.1f e %.1f kg.\n", calculaPeso(altura,18.5), calculaPeso(altura, 24.9));

    }

    private static ClassificaIMC getClassificaIMC(double imc) {
        ClassificaIMC classifica;
        if(imc < 18.5) {
            classifica = ClassificaIMC.MAGREZA;
        } else if (imc >= 18.5 && imc <= 24.9) {
            classifica = ClassificaIMC.NORMAL;
        } else if (imc >= 25 && imc <= 29.9) {
            classifica = ClassificaIMC.SOBREPESO;
        } else if (imc >= 30 && imc <= 34.9) {
            classifica = ClassificaIMC.OBESID_G1;
        } else if (imc >= 35 && imc <= 39.9) {
            classifica = ClassificaIMC.OBESID_G2;
        } else if (imc > 39.9) {
            classifica = ClassificaIMC.OBESID_G3;
        } else {
            classifica = ClassificaIMC.INDEFINIDO;
        }
        return classifica;
    }

    enum ClassificaIMC {
        MAGREZA("Magreza"),
        NORMAL("Normal"),
        SOBREPESO("Sobrepeso"),
        OBESID_G1("Obesidade grau I"),
        OBESID_G2("Obesidade grau II"),
        OBESID_G3("Obesidade grau III"),
        INDEFINIDO("Indefinido");

        private final String nome;

        ClassificaIMC(String nome) {
            this.nome = nome;
        }
    }

    public static double calculaPeso(double altura, double imc) {
        return(Math.pow(altura,2) * imc);
    }
}
