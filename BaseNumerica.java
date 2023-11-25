/*******************************************************
 Programa 50+ Ada & Núclea
 Etapa de formação
 Projeto do Mudança de Base Numérica
 Evandro Francisco
 Novembro de 2023 - v1
 *********************************************************/


public class BaseNumerica {

    public static void main(String[] args){

        System.out.println();
        System.out.println("FUNÇÕES DE MUDANÇA DE BASE NUMERICA");
        System.out.println("-----------------------------------");
        System.out.println();

        System.out.println("Exemplo de DECIMAIS:");
        int decimal;
        decimal = 25;
        System.out.printf("%s em decimal equivale a %s em binario \n",decimal, decimalParaOutraBase(decimal, 2));
        decimal = 3821;
        System.out.printf("%s em decimal equivale a %s em octal \n",decimal, decimalParaOutraBase(decimal, 8));
        decimal = 1214;
        System.out.printf("%s em decimal equivale a %s em hexadecimal \n",decimal, decimalParaOutraBase(decimal, 16));
        System.out.println();

        System.out.println("Exemplo de BINARIOS:");
        int binario;
        binario = 11001;
        System.out.printf("%s em binario equivale a %s em decimal \n",binario, binarioParaOutraBase(binario, 10));
        binario = 101010111;//10111; //100110;
        System.out.printf("%s em binario equivale a %s em octal \n",binario, binarioParaOutraBase(binario, 8));
        binario = 1101; //10011100; //11101;
        System.out.printf("%s em binario equivale a %s em hexadecimal \n",binario, binarioParaOutraBase(binario, 16));
        System.out.println();

        System.out.println("Exemplo de HEXADECIMAL:");
        String hexadecimal;
        hexadecimal = "B105";
        System.out.printf("%s em hexadecimal equivale a %s em decimal \n",hexadecimal, hexadecimalParaOutraBase(hexadecimal, 10));
        hexadecimal = "D2";
        System.out.printf("%s em hexadecimal equivale a %s em binario \n",hexadecimal, hexadecimalParaOutraBase(hexadecimal, 2));
        hexadecimal = "4AB";
        System.out.printf("%s em hexadecimal equivale a %s em octal \n",hexadecimal, hexadecimalParaOutraBase(hexadecimal, 8));

    }

    public static String hexadecimalParaOutraBase(String hexad, int base){
        int tam = hexad.length();
        int numero = 0;
        int valor = 0;

        for (int n = tam; n>0 ; n--){
            String letra = hexad.substring(tam-n, tam-n+1);
            numero = hexadecimalDeLetraParaNumero(letra);
            int potencia = (int)(Math.pow(16,(n-1)));
            valor += (numero*potencia);
        }

        String retorno = "";
        if(base==10) {
            retorno = String.valueOf(valor);
        } else if (base == 2) {
            retorno = decimalParaOutraBase(valor, 2);
        } else if (base == 8) {
            retorno = decimalParaOutraBase(valor, 8);
        }

        return(retorno);
    }

    public static String binarioParaOutraBase(int binario, int base){
        String binSTR =  String.valueOf(binario);
        int tam = binSTR.length();
        int valor = 0;

        for (int n = tam ; n>0 ; n--) {
            int potencia = (int)(Math.pow(2,(n-1)));
            int unidade = Integer.parseInt(binSTR.substring(tam-n, tam-n+1));
            valor += (potencia*unidade);
        }

        String retorno = "";
        if(base==10) {
            retorno = String.valueOf(valor);
        } else if (base == 8) {
            retorno = decimalParaOutraBase(valor, 8);
        } else if (base == 16) {
            retorno = decimalParaOutraBase(valor, 16);
        }

        return(retorno);

    }
    public static String decimalParaOutraBase(int decimal, int base){
        int resto = 0;
        int numero = decimal;
        String resInvertido = "";
        String letra = "";
        if(decimal>base) {
            do {
                resto = numero % base;
                if (resto > 10 && base == 16) {
                    letra = hexadecimalDeNumeroParaLetra(resto);
                    resInvertido += letra;
                } else {
                    resInvertido += resto;
                }
                numero = numero / base;
            } while (numero > base);
        } else {
            resto = numero % base;
        }

        if(resto>0){
            if(base==16){
                letra = hexadecimalDeNumeroParaLetra(resto);
                resInvertido += letra;
            } else {
                resInvertido += (numero % base);
            }
        }
        String resCorreto = "";
        for(int i = resInvertido.length()-1; i >= 0 ; i--) {
            resCorreto += resInvertido.substring(i,i+1);
        }

        return(resCorreto);

    }

    public static String hexadecimalDeNumeroParaLetra(int numero) {
        String letra="";
        if (numero == 10) {
            letra += "A";
        } else if (numero == 11) {
            letra += "B";
        } else if (numero == 12) {
            letra += "C";
        } else if (numero == 13) {
            letra += "D";
        } else if (numero == 14) {
            letra += "E";
        } else if (numero == 15) {
            letra += "F";
        }
        return(letra);

    }

    public static int hexadecimalDeLetraParaNumero(String letra) {
        int numero = 0;
        if (letra.equals("A")) {
            numero = 10;
        } else if (letra.equals("B")) {
            numero = 11;
        } else if (letra.equals("C")) {
            numero = 12;
        } else if (letra.equals("D")) {
            numero = 13;
        } else if (letra.equals("E")) {
            numero = 14;
        } else if (letra.equals("F")) {
            numero = 15;
        } else {
            numero = Integer.parseInt(letra);
        }

        return(numero);

    }

}
