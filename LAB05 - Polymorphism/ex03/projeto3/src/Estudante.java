public class Estudante {
    private String nome;
    private String endereco;

    public Estudante(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public void print() {
        System.out.println("Estudante{" + "nome='" + nome + '\'' + ", endereco='" + endereco + '\'' + '}');
    }

    public String getNome() {
        return nome;
    }
}