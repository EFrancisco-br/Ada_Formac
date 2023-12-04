package Catalogo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Filme {

    String nome;
    String dataLancamento;
    String orcamento;
    String descricao;
    List<Diretor> diretoresDoFilme = new ArrayList<>();
    List<Ator> atoresDoFilme = new ArrayList<>();

    Filme(){

    }
    Filme(String nome, String dataLancamento, String orcamento, String descricao){
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
    }

    Filme(String nome, String dataLancamento, String orcamento, String descricao, Diretor[] diretoresDoFilme, Ator[] atoresDoFilme){
        this.nome = nome;
        this.dataLancamento = dataLancamento;
        this.orcamento = orcamento;
        this.descricao = descricao;
        for(Diretor dadosDiretor : diretoresDoFilme) {
            this.diretoresDoFilme.add(dadosDiretor);
        }
        for(Ator dadosAtor : atoresDoFilme) {
            this.atoresDoFilme.add(dadosAtor);
        }
    }

    public String getFilmeToPrint(){
        return nome + ", lançado em " + dataLancamento + " - " + descricao;
    }

    public String getFilmeEquipe() {
        String equipe = "Diretor(es): ";
        equipe += getDiretor();
        equipe += " Ator(es): ";
        equipe += getAtor();
        return "'"+nome+"' - "+ " "+equipe;

    }
    public String getDiretor(){
        String diretor = "";
        int conta = 1;
        for(Diretor nomeDiretor : diretoresDoFilme){
            diretor += nomeDiretor.nome;
            if(conta<diretoresDoFilme.size()){
                diretor += ", ";
            }
            conta++;
        }
        return diretor;
    }
    public String getAtor(){
        String ator = "";
        int conta = 1;
        for(Ator nomeAtor : atoresDoFilme){
            ator += nomeAtor.nome;
            if(conta<atoresDoFilme.size()){
                ator += ", ";
            }
            conta++;
        }
        return ator;
    }
    public void filmeFicha(int codigo){

        System.out.println("["+codigo+"] \t"+nome);
        System.out.println("Lançamento..............: "+dataLancamento);
        System.out.println("Orçamento...............: "+orcamento);
        System.out.println("Sinopse.................: "+descricao);
        System.out.println("Diretor(es).............: "+getDiretor());
        System.out.println("Ator(es) principal(is)..: "+getAtor());

    }
}
