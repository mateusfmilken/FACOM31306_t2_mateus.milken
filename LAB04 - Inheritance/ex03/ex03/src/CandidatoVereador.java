public class CandidatoVereador extends Candidato{
    private String numeroTres;
    private String bairro;

    public CandidatoVereador (String nomeC, String dataNasc, String genero, double bens, String reeleicao, int numeroPartido, String numeroTres, String bairro) {
        super(nomeC, dataNasc, genero, bens, reeleicao, numeroPartido);
        this.numeroTres = numeroTres;
        this.bairro = bairro;
    }

    public CandidatoVereador(Candidato candidato, String numeroTres, String bairro) {
        super(candidato.getNomeC(), candidato.getDataNasc(), candidato.getGenero(), candidato.getBens(), candidato.getReeleicao(), candidato.getNumeroPartido());
        this.numeroTres = numeroTres;
        this.bairro = bairro;
    }

    public String toString() {
        return super.toString() + "\nNúmero de três digitos: " + numeroTres + "\nBairro: " + bairro;
    }
}