package Catalogo;
import java.time.LocalDateTime;
public class Pessoa {
    String nome;
    String nascimento;
    String nacionalidade;

    Pessoa() {

    }
    Pessoa(String nome, String nascimento, String nacionalidade){
        this.nome = nome;
        this.nascimento = nascimento;
        this.nacionalidade = nacionalidade;
    }

    public String getPessoaToPrint(){
        return nome + " (" + nascimento + ", " + nacionalidade + ")";
    }
}
