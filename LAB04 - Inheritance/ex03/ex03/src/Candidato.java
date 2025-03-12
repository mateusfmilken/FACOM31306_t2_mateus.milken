public class Candidato {
    private String nomeC;
    private String dataNasc;
    private String genero;
    private double bens;
    private String reeleicao;
    private int numeroPartido;

    public Candidato (String nomeC, String dataNasc, String genero, double bens, String reeleicao, int numeroPartido) {
        this.nomeC = nomeC;
        this.dataNasc = dataNasc;
        this.genero = genero;
        this.bens = bens;
        this.reeleicao = reeleicao;
        this.numeroPartido = numeroPartido;
    }

    public String getNomeC() {
        return nomeC;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public String getGenero() {
        return genero;
    }

    public double getBens() {
        return bens;
    }

    public String getReeleicao() {
        return reeleicao;
    }

    public int getNumeroPartido() {
        return numeroPartido;
    }


    public String toString() {
        return "Nome Completo do candidato: " + nomeC + "\nData de Nascimento: " + dataNasc + "\nGênero: " + genero + "\nValor de bens: " + bens + "\nCandidato a reeleição:? " + reeleicao + "\nNúmero do Partido: " + numeroPartido;
    }
}
