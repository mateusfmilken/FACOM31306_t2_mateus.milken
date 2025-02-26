public class Candidato {
    public String nomeC;
    public String dataNasc;
    public String genero;
    public double bens;
    public boolean reeleicao;
    public int numeroPartido;
    public String cargo;

    public void exibirInfo() {
        System.out.println("\n-----------------------------");
        System.out.println("\nNome: " + nomeC);
        System.out.println("Data de nascimento: " + dataNasc);
        System.out.println("Gênero da pessoa: " + genero);
        System.out.println("Valor em bens: R$" + bens);
        System.out.println("Candidato à Reeleição: " + (reeleicao ? "Sim" : "Não"));
        System.out.println("Número do partido: " + numeroPartido);
        System.out.println("Cargo pretendido: " + cargo);
        System.out.println("\n-----------------------------");

    }
}
