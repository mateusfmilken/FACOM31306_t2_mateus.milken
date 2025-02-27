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


    public void maisRico() {
    Candidato candidatoMR = vetorCandidato[0];
    double total = 0;

        for (Candidato candidato : vetorCandidato) {
            total = candidato.getBens() + total;
            if (candidato.getBens() > candidatoMR.getBens()){
                candidatoMR = candidato;
            }
        }

        double percentual = (candidatoMR.getBens()/total) * 100;
        System.out.println("\nCandidato mais rico:\n");
        candidatoMR.exibirInfo();
        System.out.printf("Percentual de bens em relação ao total: %.2f%%\n", percentual);
    }
}