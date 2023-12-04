/*******************************************************
 Programa 50+ Ada & Núclea
 Etapa de formação
 Projeto de cadastro de filmes
 Evandro Francisco
 Dezembro de 2023 - v1
 *********************************************************/

package Catalogo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalogo {

    public static void main(String[] args){

        //CatalogoFilme catalogo = new CatalogoFilme();

        List<Filme> filmes = new ArrayList<>();
        List<Diretor> diretores = new ArrayList<>();
        List<Ator> atores = new ArrayList<>();

        //======================================================================================================================
        // popula dados
        Ator ator1 = new Ator("Sam Worthington", "02/08/1976", "Australiano");
        atores.add(ator1);
        Ator ator2 = new Ator("Zoe Saldana", "19/06/1978", "Norte-americana");
        atores.add(ator2);
        Ator ator3 = new Ator("Sigourney Weaver", "08/10/1979", "Norte-americana" );
        atores.add(ator3);
        Ator ator4 = new Ator("Kate Winslet", "05/10/1975", "Britânica");
        atores.add(ator4);
        Ator ator5 = new Ator("Laura Dern", "10/02/1967", "Norte-americana");
        atores.add(ator5);
        Ator ator6 = new Ator("Jeff Goldblum", "22/10/1952", "Norte-americana" );
        atores.add(ator6);
        Ator ator7 = new Ator("Sam Neill", "14/09/1947", "Neozelandês");
        atores.add(ator7);
        Ator ator8 = new Ator("Leonardo DiCaprio", "11/11/1974", "Norte-americano");
        atores.add(ator8);
        Diretor diretor1 = new Diretor("James Cameron", "16/08/1954", "Canadense");
        diretores.add(diretor1);
        Diretor diretor2 = new Diretor("Juan Antônio Garcia Bayona", "09/05/1975", "Espanhol");
        diretores.add(diretor2);
        Diretor diretor3 = new Diretor("Colin Trevorrow", "13/09/1976", "Norte-americano");
        diretores.add(diretor3);
        Diretor diretor4 = new Diretor("Steven Spielberg", "18/12/1949", "Norte-americano");
        diretores.add(diretor4);
        Diretor diretor5 = new Diretor("Joe Johnston", "13/05/1950", "Norte-americano");
        diretores.add(diretor5);

        Ator[] atoresAvatar = {ator1, ator2, ator3, ator4};
        Diretor[] diretoresAvatar = {diretor1};
        Filme filmeAvatar = new Filme("Avatar", "18/12/2009", "$237.000.000,00 USD",
                "No mundo alienígena de Pandora seres azuis vivem em harmonia até que...", diretoresAvatar, atoresAvatar);
        filmes.add(filmeAvatar);

        Ator[] atoresJurassic = {ator5, ator6, ator7};
        Diretor[] diretoresJurassic = {diretor2, diretor3, diretor4, diretor5 };
        Filme filmeJurassic = new Filme("Jurassic Park", "25/06/1993", "$63.000.000,00 USD",
                "Parque temático habitado por dinossauros famintos.", diretoresJurassic, atoresJurassic);
        filmes.add(filmeJurassic);

        Ator[] atoresTitanic = {ator4, ator8};
        Diretor[] diretoresTitanic = {diretor1};
        Filme filmeTitanic = new Filme("Titanic", "16/01/1998", "$200.000.000,00 USD",
                "O barco afundou....", diretoresTitanic, atoresTitanic);
        filmes.add(filmeTitanic);
        //======================================================================================================================

        boolean sair = false;
        Scanner entrada = new Scanner(System.in);
        Scanner dados = new Scanner(System.in);
        int codigo;

        while(!sair) {

            System.out.println();
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|                                                             |");
            System.out.println("|      C A T A L O G O   D E   F I L M E S   -   J A V A      |");
            System.out.println("|                                                             |");
            System.out.println("| v1 - dez2023                          por Evandro Francisco |");
            System.out.println("+-------------------------------------------------------------+");
            System.out.println();
            System.out.println("Menu de opções:");
            System.out.println("1 - Cadastrar filmes");
            System.out.println("2 - Cadastrar atores");
            System.out.println("3 - Cadastrar diretores");
            System.out.println("4 - Associar filme a atores e diretores");
            System.out.println("5 - Buscar filme");
            System.out.println("6 - Lista catálogo de filmes");
            System.out.println("9 - Sair do programa");
            System.out.println();
            System.out.print("Entre com a opção: ");
            while(!entrada.hasNextInt()) {
                System.out.print("Opção inválida! Tente novamente com números de 1 a 5 ou 9 para sair: ");
                entrada.next();
            }
            int opc = entrada.nextInt();
            switch(opc) {
                case 1:
                    Filme filme = new Filme();
                    System.out.println();
                    System.out.println("+----------------------+");
                    System.out.println("|CADASTRO DE NOVO FILME|");
                    System.out.println("+----------------------+");
                    System.out.print("Nome do filme: ");
                    filme.nome = dados.nextLine();
                    System.out.print("Data de lançamento: ");
                    filme.dataLancamento = dados.nextLine();
                    System.out.print("Orçamento: ");
                    filme.orcamento = dados.nextLine();
                    System.out.print("Sinopse do filme: ");
                    filme.descricao = dados.nextLine();
                    filmes.add(filme);
                    System.out.println();
                    System.out.println("*** Relação de filmes cadastrados ***");
                    for (Filme filmeDados : filmes){
                        System.out.println(filmeDados.getFilmeToPrint());
                    }
                    System.out.println();
                    break;
                case 2:
                    Ator ator = new Ator();
                    System.out.println();
                    System.out.println("+---------------------+");
                    System.out.println("|CADASTRO DE NOVO ATOR|");
                    System.out.println("+---------------------+");
                    System.out.print("Nome do(a) ator(iz): ");
                    ator.nome = dados.nextLine();
                    System.out.print("Nascimento: ");
                    ator.nascimento = dados.nextLine();
                    System.out.print("Nacionalidade: ");
                    ator.nacionalidade = dados.nextLine();
                    atores.add(ator);
                    System.out.println();
                    listaAtores(atores);
                    System.out.println();
                    break;
                case 3:
                    Diretor diretor = new Diretor();
                    System.out.println();
                    System.out.println("+------------------------+");
                    System.out.println("|CADASTRO DE NOVO DIRETOR|");
                    System.out.println("+------------------------+");
                    System.out.print("Nome do(a) diretor(a): ");
                    diretor.nome = dados.nextLine();
                    System.out.print("Nascimento: ");
                    diretor.nascimento = dados.nextLine();
                    System.out.print("Nacionalidade: ");
                    diretor.nacionalidade = dados.nextLine();
                    diretores.add(diretor);
                    System.out.println();
                    listaDiretores(diretores);
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("+--------------------------+");
                    System.out.println("|ASSOCIA ATORES E DIRETORES|");
                    System.out.println("+--------------------------+");
                    System.out.println();
                    System.out.println("*** Relação de filmes cadastrados ***");
                    codigo = 0;
                    for (Filme filmeDados : filmes){
                        codigo++;
                        System.out.println("  ["+codigo+"] \t"+filmeDados.getFilmeEquipe());
                    }
                    System.out.println();
                    int codigoFilme = 0;
                    do {
                        System.out.print("Entre com o número do filme (0 para sair): ");
                        codigoFilme = entrada.nextInt();
                    } while (codigoFilme<0 || codigoFilme>filmes.size());

                    if(!(codigoFilme==0? true : false)) {
                        Filme filmeSelecionado = filmes.get(codigoFilme-1);
                        System.out.println();
                        System.out.println("*** Ficha do filme selecionado:");
                        filmeSelecionado.filmeFicha(codigoFilme);
                        System.out.println();
                        System.out.println("=> ASSOCIAR ATOR(ES) AO FILME");
                        listaAtores(atores);
                        int codigoAtor = 0;
                        do {
                            System.out.print("Entre com o número do ator para associar ao filme '"+filmeSelecionado.nome+"' (0 para sair): ");
                            codigoAtor = entrada.nextInt();
                            if(codigoAtor>0 && codigoAtor<=atores.size()){
                                Ator atorSelecionado = atores.get(codigoAtor-1);
                                filmeSelecionado.atoresDoFilme.add(atorSelecionado);
                            }
                        } while (codigoAtor>0 && codigoAtor<=atores.size());
                        System.out.println();
                        System.out.println("*** Ficha atualizada do filme:");
                        filmeSelecionado.filmeFicha(codigoFilme);
                        System.out.println();
                        System.out.println("=> ASSOCIAR DIRETOR(ES) AO FILME");
                        listaDiretores(diretores);
                        int codigoDiretor = 0;
                        do {
                            System.out.print("Entre com o número do diretor para associar ao filme '"+filmeSelecionado.nome+"' (0 para sair): ");
                            codigoDiretor = entrada.nextInt();
                            if(codigoDiretor>0 && codigoDiretor<=diretores.size()){
                                Diretor diretorSelecionado = diretores.get(codigoDiretor-1);
                                filmeSelecionado.diretoresDoFilme.add(diretorSelecionado);
                            }
                        } while (codigoDiretor>0 && codigoDiretor<=diretores.size());
                        System.out.println();
                        System.out.println("*** Ficha atualizada do filme:");
                        filmeSelecionado.filmeFicha(codigoFilme);
                        System.out.println();
                        System.out.println("Dados atualizados com sucesso!");
                        System.out.println();
                    }
                    break;
                case 5:
                    System.out.println();
                    System.out.println("+-----------------------+");
                    System.out.println("|BUSCA FILME NO CATÁLOGO|");
                    System.out.println("+-----------------------+");
                    System.out.print("Nome do filme: ");
                    String nomeFilme = dados.nextLine().toUpperCase();
                    boolean erro = true;
                    codigo = 0;
                    System.out.println();
                    for(Filme dadosFilme : filmes){
                        codigo ++;
                        if(dadosFilme.nome.toUpperCase().equals(nomeFilme)){
                            dadosFilme.filmeFicha(codigo);
                            erro = false;
                            System.out.println();
                        }
                    }
                    if(erro) {
                        System.out.println("Nome do filme não localizado no catálogo!");
                    }
                    break;
                case 6:
                    System.out.println();
                    System.out.println("+------------------+");
                    System.out.println("|CATALOGO DE FILMES|");
                    System.out.println("+------------------+");
                    System.out.println();
                    codigo = 0;
                    for (Filme filmeDados : filmes){
                        codigo++;
                        filmeDados.filmeFicha(codigo);
                        System.out.println("-------------------------------------------------------------------------------------------------------");
                    }
                    System.out.println();
                    break;
                case 9:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            if(!sair) {
                System.out.print("Precione qualquer tecla e <ENTER> para voltar ao Menu de opções...");
                entrada.next();
            }

        }
        System.out.println();
        System.out.println("+--------------------+");
        System.out.println("| PROGRAMA ENCERRADO |");
        System.out.println("+--------------------+");
        System.out.println();
    }

    public static void listaAtores(List<Ator> atores){
        System.out.println("*** Relação de autores cadastrados ***");
        int conta = 0;
        for (Ator atorDados : atores){
            conta++;
            System.out.println("["+conta+"]\t"+atorDados.getPessoaToPrint());
        }
    }
    public static void listaDiretores(List<Diretor> diretores){
        System.out.println("*** Relação de diretores cadastrados ***");
        int conta = 0;
        for (Diretor diretorDados : diretores){
            conta++;
            System.out.println("["+conta+"]\t"+diretorDados.getPessoaToPrint());
        }
    }
}
