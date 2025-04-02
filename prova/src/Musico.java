import java.util.Scanner;

public class Musico {
    private String nome;
    private String papel;
    private int experiencia;
    private int remuneracao;

    public Musico(String nome, String papel, int experiencia, int remuneracao) {
        this.nome = nome;
        this.papel = papel;
        this.experiencia = experiencia;
        this.remuneracao = remuneracao;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setPapel(String papel){
        this.papel = papel;
    }

    public String getPapel(){
        return this.papel;
    }

    public void setExperiencia(int experiencia){
        this.experiencia = experiencia;
    }

    public int getExperiencia(){
        return this.experiencia;
    }

    public void setRemuneracao(int remuneracao){
        this.remuneracao = remuneracao;
    }

    public int getRemuneracao(){
        return this.remuneracao;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\nPapel: " + this.papel + "\nExperiência (em anos): " + this.experiencia + "\nRemuneracao (reais/hora) " + this.remuneracao;
    }
}


