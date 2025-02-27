public class Eleicao {
    private String nomeM;
    private int numeroV;
    private Candidato[] vetorCandidato;

    public Eleicao(String nomem, int numerov, Candidato[] c) {
        nomeM = nomem;
        numeroV = numerov;
        vetorCandidato = c;
    }

    public void exibirInfoEleicao() {
        System.out.println("\n-----------------------------");
        System.out.println("Nome do município: + NomeM");
        System.out.println("Número de votantes: + numeroV");
        System.out.println("Candidatos:");
        for (Candidato candidato : vetorCandidato) {
            candidato.exibirInfo();
        }
    }
}