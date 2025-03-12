public class CandidatoVereador extends Candidato{
    private String numeroTres;
    private String bairro;

    public CandidatoVereador (String nomeC, String dataNasc, String genero, double bens, String reeleicao, int numeroPartido, String numeroTres, String bairro) {
        super(nomeC, dataNasc, genero, bens, reeleicao, numeroPartido);
        this.numeroTres = numeroTres;
        this.bairro = bairro;
    }

    public String toString() {
        return "Nome Completo do candidato: " + nomeC + "\nData de Nascimento: " + dataNasc + "\nGênero: " + genero + "\nValor de bens: " + bens + "\nCandidato a reeleição:? " + reeleicao + "\nNúmero do Partido: " + numeroPartido + "\nNúmero de três digitos: " + numeroTres + "\nBairro: " + bairro;
    }
}