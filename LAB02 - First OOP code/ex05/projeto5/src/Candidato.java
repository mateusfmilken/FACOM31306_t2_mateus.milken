public class Candidato {
    private String nomeC;
    private String dataNasc;
    private String genero;
    private double bens;
    private boolean reeleicao;
    private int numeroPartido;
    private String cargo;

    public Candidato (String nomec, String datanasc, String Genero, double Bens, boolean Reeleicao, int numeropartido, String Cargo) {
        nomeC = nomec;
        dataNasc = datanasc;
        genero = Genero;
        bens = Bens;
        reeleicao = Reeleicao;
        numeroPartido = numeropartido;
        cargo = Cargo;
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nomeC);
        System.out.println("Data de nascimento: " + dataNasc);
        System.out.println("Gênero da pessoa: " + genero);
        System.out.println("Valor em bens: R$" + bens);
        System.out.println("Candidato à Reeleição: " + (reeleicao ? "Sim" : "Não"));
        System.out.println("Número do partido: " + numeroPartido);
        System.out.println("Cargo pretendido: " + cargo);
        System.out.println("\n-----------------------------");
    }
}