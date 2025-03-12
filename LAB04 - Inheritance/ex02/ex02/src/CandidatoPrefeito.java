public class CandidatoPrefeito extends Candidato {
    private String nomeV;
    private int partidoV;

    public CandidatoPrefeito(String nomeC, String dataNasc, String genero, double bens, String reeleicao, int numeroPartido, String nomeV, int partidoV) {
        super(nomeC, dataNasc, genero, bens, reeleicao, numeroPartido);
        this.nomeV = nomeV;
        this.partidoV = partidoV;
    }
    public String toString() {
        return "Nome Completo do candidato: " + nomeC + "\nData de Nascimento: " + dataNasc + "\nGênero: " + genero + "\nValor de bens: " + bens + "\nCandidato a reeleição:? " + reeleicao + "\nNúmero do Partido: " + numeroPartido + "\nNome do candidato a vice: " + nomeV + "\nPartido do vice: " + partidoV;
    }
}
