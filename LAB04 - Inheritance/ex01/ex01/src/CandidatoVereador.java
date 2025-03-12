public class CandidatoVereador {
    private String nomeC;
    private String dataNasc;
    private String genero;
    private double bens;
    private String reeleicao;
    private int numeroPartido;
    private String numeroTres;
    private String bairro;

    public CandidatoVereador (String nomeC, String dataNasc, String genero, double bens, String reeleicao, int numeroPartido, String numeroTres, String bairro) {
        this.nomeC = nomeC;
        this.dataNasc = dataNasc;
        this.genero = genero;
        this.bens = bens;
        this.reeleicao = reeleicao;
        this.numeroPartido = numeroPartido;
        this.numeroTres = numeroTres;
        this.bairro = bairro;
    }

    public String toString() {
        return "Nome Completo do candidato: " + nomeC + "\nData de Nascimento: " + dataNasc + "\nGênero: " + genero + "\nValor de bens: " + bens + "\nCandidato a reeleição:? " + reeleicao + "\nNúmero do Partido: " + numeroPartido + "\nNúmero de três digitos: " + numeroTres + "\nBairro: " + bairro;
    }
}