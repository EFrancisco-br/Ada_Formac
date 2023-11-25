/*******************************************************
 Programa 50+ Ada & Núclea
 Etapa de formação
 Projeto do Bingo Eletrônico
 Evandro Francisco
 Novembro de 2023 - v2
 *********************************************************/

import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class BingoGame {

    public static void main(String[] args) {

        // regras do jogo
        final int qtdNumerosPorCartela = 5;
        final int numeroFinalDaCartela = 60;
        final int qtdNumeroSorteioPorRodada = 5;
        final boolean mostrarParciais = false;

        // banco de dados
        String bancoDeDadosJogadores = "Oliver-Paty-Bruno-Nicolau-Rocha-Cláudio-Helder-Deyse-Rosivan-Cesar-Evandro-Fabio-" +
                "Marcelo-Jefferson-Daniel-Alex-Otair-Rejane-Edson-Moacyr-Sylas-Clarice-Luiz-Claudio-Paulo-Ademar-Angelo-Dirce";
                //"Rafaela-Nilson-Angela-Carlos-Joaquim-Santos-Maria-Heitor";
        String[] jogadores = {};
        int[][] cartelaJogadores = {};

        Scanner teclado = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println();
            System.out.println();
            System.out.println("+---------------------------------------------------+");
            System.out.println("|                                                   |");
            System.out.println("|          J O G O    J A V A    B I N G O          |");
            System.out.println("|                                                   |");
            System.out.println("| v.2                                   por Evandro |");
            System.out.println("+---------------------------------------------------+");
            System.out.println();
            System.out.println("MENU DE OPÇÕES:");
            System.out.println("1 - Entrar com os jogadores");
            System.out.println("2 - Gerar cartelas");
            System.out.println("3 - Lista jogadores e cartelas");
            System.out.println("4 - Iniciar jogo");
            System.out.println("9 - Sair");
            System.out.println();
            System.out.print("Digite uma opção: ");
            int opc;
            while (!teclado.hasNextInt()) {
                System.out.print("Opção inválide! Tente novamente: ");
                teclado.next();
            }
            opc = teclado.nextInt();

            System.out.println();
            switch (opc) {
                case 1:
                    jogadores=defineJogadores(bancoDeDadosJogadores);
                    break;
                case 2:
                    if (temJogadores(jogadores)) {
                        cartelaJogadores = defineCartelas(jogadores, qtdNumerosPorCartela, numeroFinalDaCartela);
                    } else {
                        System.out.println("Falta definição dos jogadores!!!");
                    }
                       break;
                case 3:
                    if (temJogadores(jogadores)) {
                        if (temCartelas(cartelaJogadores)) {
                            mostraJogadoresECartelas(jogadores, cartelaJogadores);
                        } else {
                            System.out.println("Falta gerar as cartelas!!!");
                        }
                    } else {
                        System.out.println("Falta definição dos jogadores!!!");
                    }
                    break;
                case 4:
                    if (temJogadores(jogadores)) {
                        if (temCartelas(cartelaJogadores)) {
                            executaJogo(jogadores, cartelaJogadores, qtdNumeroSorteioPorRodada, numeroFinalDaCartela, mostrarParciais);
                        } else {
                            System.out.println("Falta gerar as cartelas!!!");
                        }
                    } else {
                        System.out.println("Falta definição dos jogadores!!!");
                    }
                    break;
                case 9:
                    sair = true;
                    break;
                default:
                    System.out.print("Opção inválide! ");
                    break;
            }
            if (!sair) {
                 System.out.print("Precione qualquer tecla e <ENTER> para voltar ao Menu de Opções...");
                 teclado.next();
            }
        }
        System.out.println("+-------------+");
        System.out.println("| FIM DO JOGO |");
        System.out.println("+-------------+");
    }

    public static String[] defineJogadores(String bancoDeDadosJogadores) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("+-------------------------+");
        System.out.println("| ENTRAR COM OS JOGADORES |");
        System.out.println("+-------------------------+");
        System.out.println("BANCO DE DADOS DE JOGADORES (*):");
        System.out.println(bancoDeDadosJogadores);
        System.out.println();
        System.out.println("Entre com os nomes dos jogadores separados por hifen (nome1-nome2-nome3...)");
        System.out.println("Se desejar utilizar os nomes do banco de dados, tecle *");
        System.out.println();
        System.out.print("Nome dos jogadores ou *: ");
        String listaJogadores = teclado.next();
        if (listaJogadores.equals("*")) {
            listaJogadores = bancoDeDadosJogadores;
        }

        String[] jogadores = listaJogadores.split("-");

        System.out.println("Relação de jogadores:");
        int n = 0;
        for (String nome : jogadores) {
            System.out.printf("%s - %s\n",++n,nome);
        }

        return (jogadores);
    }

    public static boolean temJogadores(String[] jogadores) {
        return (jogadores.length != 0);
    }
    public static boolean temCartelas(int[][] cartelas) {
        return (cartelas.length != 0);
    }

    public static int[][] defineCartelas(String[] jogadores, int qtdNumerosPorCartela, int numeroFinalDaCartela) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("+----------------------------------+");
        System.out.println("| DEFINE AS CARTELAS DOS JOGADORES |");
        System.out.println("+----------------------------------+");
        System.out.println();
        System.out.print("Jogadores: ");
        for (int i = 0; i < jogadores.length; i++) {
            System.out.print(jogadores[i]);
            if((i+1)!=jogadores.length){
                System.out.print("-");
            } else {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Entre com os números da cartela separados por ',' e ");
        System.out.println("coloque um hirem para separar os jogadores (1,2,3,4,5-6,7,8,9,1-2,3,4,5,6...)");
        System.out.println("Atenção: a) não pode haver números repetidos na mesma cartela;");
        System.out.println("         b) cada cartela deve ter " + qtdNumerosPorCartela + " numeros");
        System.out.println("         c) o maior número deve ser <= " + numeroFinalDaCartela);
        System.out.println();
        System.out.println("Se desejar o preenchimento automático das cartelas, tecle *");
        System.out.println();
        System.out.print("Cartela dos jogadores ou *: ");
        String numeroDasCartelas = teclado.next();
        int[][] cartelas = new int[jogadores.length][qtdNumerosPorCartela];
        if (numeroDasCartelas.equals("*")) {
            int[] restricaoCartela = new int[]{0};
            for (int pos = 0 ; pos < jogadores.length ; pos++) {
                cartelas[pos] = sorteiaNumeros(qtdNumerosPorCartela, numeroFinalDaCartela, restricaoCartela);
            }
        } else {
            for (int i = 0; i < jogadores.length; i++) {
                Arrays.fill(cartelas[i], 0);
            }

            String[] cartelasDigitadas = numeroDasCartelas.split("-");

            String[][] cartelaEmString = new String [cartelasDigitadas.length][qtdNumerosPorCartela];
            for (int i=0 ; i < cartelaEmString.length ; i++) {
                cartelaEmString[i] = cartelasDigitadas[i].split(",");
            }
            for (int i=0 ; i < jogadores.length; i++) {
                for (int j=0; j < qtdNumerosPorCartela; j++) {
                    cartelas[i][j] = Integer.parseInt(cartelaEmString[i][j]);
                }
            }
        }

        for (int i=0 ; i < jogadores.length; i++) {
            int[]  vetor = cartelas[i];
            Arrays.sort(vetor);
             cartelas[i] = vetor;
        }

        System.out.println("Cartelas definidas com sucesso!");

        return(cartelas);
    }

    public static int[] sorteiaNumeros(int qtdNumeros, int ultimoNumero , int[] restricao) {
        int[] cartela = new int[qtdNumeros];
        Arrays.fill(cartela, 0);
        Random randomico = new Random();
        int posicao = 0;
        while (posicao<qtdNumeros) {
            int sorteio = randomico.nextInt(ultimoNumero);
            boolean erro = false;
            for (int jaSorteado : restricao) {
                if (sorteio == jaSorteado) {
                    erro = true;
                    break;
                }
            }
            if (!erro){
                for (int numero : cartela) {
                    if (numero == sorteio) {
                        erro = true;
                        break;
                    }
                }
            }
            if (!erro){
                cartela[posicao] = sorteio;
                posicao++;
            }
        }
        return (cartela);
    }

    public static void mostraJogadoresECartelas(String[] jogadores, int[][] cartelaJogadores){
        System.out.println("+---------------------------------+");
        System.out.println("| RELACAO DE JOGADORES E CARTELAS |");
        System.out.println("+---------------------------------+");

        for (int i = 0; i < jogadores.length; i++) {
            System.out.print(jogadores[i] + " => ");
            for (int j = 0; j < cartelaJogadores[0].length; j++) {
                System.out.print("\t " + cartelaJogadores[i][j]);
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void executaJogo(String[] jogadores, int[][] cartelaJogadores, int qtdNumeroSorteioPorRodada,
                                   int numeroFinalDaCartela, boolean mostrarParciais){

        Scanner teclado = new Scanner(System.in);
        int qtdJogadores = jogadores.length;
        int qtdNumerosPorCartela = cartelaJogadores[0].length;

        // inicializa vetor de resultado
        int[][] cartelaResultado = new int[qtdJogadores][qtdNumerosPorCartela];
        for (int i = 0; i < qtdJogadores ; i++){
            Arrays.fill(cartelaResultado[i], 0);
        }

        // jogo
        System.out.println("+-------------------+");
        System.out.println("| JOGO DO BINGO!!!! |");
        System.out.println("+-------------------+");
        int rodada = 0;
        boolean ganhador = false;
        boolean sair = false;
        int[] cartelaGanhadora = new int[qtdJogadores];
        Arrays.fill(cartelaGanhadora,0);
        int[] restricaoDeSorteio = new int[numeroFinalDaCartela];
        Arrays.fill(restricaoDeSorteio,0);

        while (! ganhador && ! sair) {

            if (rodada > 0) {
                System.out.println("Ranking:");
                String[] classificacao = fazClassificao(cartelaResultado, jogadores);
                for(int rank = 0; rank < Math.min(3, classificacao.length); rank++) {
                    System.out.printf("%so. lugar: %s\n",rank+1,classificacao[rank]);
                }

                System.out.print("Pressione qualquer tecla + <ENTER> para continuar ou digite X + <ENTER> para abandonar o jogo: ");
                String continua = teclado.nextLine().toUpperCase().trim();
                if (continua.equals("X")) {
                    sair = true;
                }
                System.out.println();
            }

            if (!sair) {
                System.out.print("* RODADA " + ++rodada + " | Números sorteados: ");
                int[] numerosSorteados = sorteiaNumeros(qtdNumeroSorteioPorRodada, numeroFinalDaCartela, restricaoDeSorteio);
                for (int numero : numerosSorteados) {
                    System.out.print(numero + "\t");
                    restricaoDeSorteio[numero-1] = numero;
                }
                System.out.println();
                //System.out.println("Conferindo as cartelas...");
                for (int i = 0; i < qtdJogadores; i++) {
                    for (int j = 0; j < qtdNumerosPorCartela; j++) {
                        for (int k : numerosSorteados) {
                            if (cartelaJogadores[i][j] == k) {
                                cartelaResultado[i][j] = 1;
                            }
                        }
                    }
                    int vencedor = 0;
                    for (int l = 0; l < qtdNumerosPorCartela; l++) {
                        vencedor += cartelaResultado[i][l];
                    }
                    if (vencedor == qtdNumerosPorCartela) {
                        ganhador = true;
                        cartelaGanhadora[i] = 1;
                    }
                }

                if (mostrarParciais) {
                    System.out.println("Resultado atualizado:");
                    mostraResultado(jogadores, cartelaJogadores, cartelaResultado, qtdNumerosPorCartela);
                }

            }
        }

        // resultado do jogo
        if(ganhador) {
            System.out.println("ATENÇÃO!!!! TEMOS UM, OU MAIS, GANHADOR(ES):");
            for (int l = 0; l < qtdJogadores; l++) {
                if (cartelaGanhadora[l] > 0) {
                    System.out.println("Jogador(a): " + jogadores[l]);
                }
            }
            System.out.println("PARABÉNS!!!!");
            System.out.println();
            System.out.print("Para ver as estatísticas do jogo precione X e <ENTER>: ");
            String continua = teclado.nextLine().toUpperCase().trim();
            if (continua.equals("X")){
                System.out.println("-----------------------------------------");
                System.out.println("ESTATISTICAS DO JOGO:");
                System.out.println();
                System.out.println("Total de rodadas: " + rodada);
                System.out.println("Vencedores:");
                for (int l = 0; l < qtdJogadores; l++) {
                    if (cartelaGanhadora[l] > 0) {
                        System.out.print("Jogador(a): " + jogadores[l] + " | Números da cartela:");
                        for (int numero : cartelaJogadores[l]){
                            System.out.print(" " + numero);
                        }
                        System.out.println();
                    }
                }
                System.out.println();
                System.out.println();
                System.out.println("Números sorteados:");
                for (int n : restricaoDeSorteio ) {
                    if (n!=0) {
                        System.out.print(" " + n);
                    }
                }
                System.out.println();
                System.out.println();
                System.out.println("Ranking geral dos jogadores:");

                String[] classificacao = fazClassificao(cartelaResultado, jogadores);

                for(String classific : classificacao) {
                    System.out.println(classific);
                }

                System.out.println("-----------------------------------------");

            }
        } else {
            System.out.println("Jogo interrompido sem ganhadores!");
        }
    }
    public static void mostraResultado(String[] jogador, int[][] cartela, int[][] resultado, int qtdNumerosCartela) {
        int seq = 1;
        for (String nome : jogador) {
            System.out.println(seq + " - " + nome);
            for (int n = 0 ; n < qtdNumerosCartela; n++) {
                System.out.print("\t" + cartela[seq-1][n]);
            }
            System.out.println();
            for (int n = 0 ; n < qtdNumerosCartela; n++) {
                String textoRes = "_";
                if(resultado[seq-1][n]==1) {
                    textoRes = "X";
                }
                System.out.print("\t" + textoRes);
            }
            System.out.println();
            System.out.println();
            seq++;
        }
    }

    public static String[] fazClassificao(int[][] cartelaResultados, String[] jogadores){
        int[] pontosTotais = new int[jogadores.length];
        int qtdNumerosPorCartela = cartelaResultados[0].length;
        for (int i=0 ; i < jogadores.length ; i++){
            for (int j=0 ; j < qtdNumerosPorCartela ; j++){
                pontosTotais[i]+=cartelaResultados[i][j];
            }
        }
        String[] vetorRetorno = new String[jogadores.length];
        int posClassific = 0;
        for (int pontos = qtdNumerosPorCartela ; pontos >=0 ; pontos--) {
            for ( int k=0; k < pontosTotais.length ; k++){
                if (pontosTotais[k] == pontos) {
                    vetorRetorno[posClassific++] = jogadores[k] + " " + pontos + " pontos";
                }
            }
        }
        return (vetorRetorno);
    }

}
