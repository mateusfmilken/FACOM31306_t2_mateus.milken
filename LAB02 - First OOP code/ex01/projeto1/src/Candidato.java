public class Candidato {
    private String nomeC;
    private String dataNasc;
    private String genero;
    private double bens;
    private boolean reeleicao;
    private int numeroPartido;
    private String cargo;

    public Candidato(String nomeC, String dataNasc, String genero, double bens, boolean reeleicao, int numeroPartido, String cargo) {
        this.nomeC = nomeC;
        this.dataNasc = dataNasc;
        this.genero = genero;
        this.bens = bens;
        this.reeleicao = reeleicao;
        this.numeroPartido = numeroPartido;
        this.cargo = cargo;
    }

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