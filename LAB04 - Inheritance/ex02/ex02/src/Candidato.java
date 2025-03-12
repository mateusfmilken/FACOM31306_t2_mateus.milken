public class Candidato {
    protected String nomeC;
    protected String dataNasc;
    protected String genero;
    protected double bens;
    protected String reeleicao;
    protected int numeroPartido;

    public Candidato (String nomeC, String dataNasc, String genero, double bens, String reeleicao, int numeroPartido) {
    this.nomeC = nomeC;
    this.dataNasc = dataNasc;
    this.genero = genero;
    this.bens = bens;
    this.reeleicao = reeleicao;
    this.numeroPartido = numeroPartido;
    }

    public String toString() {
        return "Nome Completo do candidato: " + nomeC + "\nData de Nascimento: " + dataNasc + "\nGênero: " + genero + "\nValor de bens: " + bens + "\nCandidato a reeleição:? " + reeleicao + "\nNúmero do Partido: " + numeroPartido;
    }

}