public class CandidatoPrefeito {
    private String nomeC;
    private String dataNasc;
    private String genero;
    private double bens;
    private String reeleicao;
    private int numeroPartido;
    private String nomeV;
    private int partidoV;


    public CandidatoPrefeito(String nomeC, String dataNasc, String genero, double bens, String reeleicao, int numeroPartido, String nomeV, int partidoV) {
        this.nomeC = nomeC;
        this.dataNasc = dataNasc;
        this.genero = genero;
        this.bens = bens;
        this.reeleicao = reeleicao;
        this.numeroPartido = numeroPartido;
        this.nomeV = nomeV;
        this.partidoV = partidoV;
    }
    public String toString() {
        return "Nome Completo do candidato: " + nomeC + "\nData de Nascimento: " + dataNasc + "\nGênero: " + genero + "\nValor de bens: " + bens + "\nCandidato a reeleição:? " + reeleicao + "\nNúmero do Partido: " + numeroPartido + "\nNome do candidato a vice: " + nomeV + "\nPartido do vice: " + partidoV;
    }
}
