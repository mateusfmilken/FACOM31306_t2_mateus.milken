public class Main {
    public static void main(String[] args) {

        Candidato[] vetorCandidato = new Candidato[3];
        vetorCandidato[0] = new Candidato();
        vetorCandidato[1] = new Candidato();
        vetorCandidato[2] = new Candidato();

        vetorCandidato[0].setNomeC("Adenildo José Leodino da Silva");
        vetorCandidato[0].setDataNasc("29/12/1995");
        vetorCandidato[0].setGenero("Masculino");
        vetorCandidato[0].setBens(0.00);
        vetorCandidato[0].setReeleicao(false);
        vetorCandidato[0].setNumeroPartido(12);
        vetorCandidato[0].setCargo("Vereador");

        vetorCandidato[1].setNomeC("Edivan Lucas da Silva");
        vetorCandidato[1].setDataNasc("03/08/1978");
        vetorCandidato[1].setGenero("Masculino");
        vetorCandidato[1].setBens(180000.00);
        vetorCandidato[1].setReeleicao(true);
        vetorCandidato[1].setNumeroPartido(45);
        vetorCandidato[1].setCargo("Vereador");

        vetorCandidato[2].setNomeC("Alexandre Gilberto Sobreira");
        vetorCandidato[2].setDataNasc("18/02/1974");
        vetorCandidato[2].setGenero("Masculino");
        vetorCandidato[2].setBens(71545.05);
        vetorCandidato[2].setReeleicao(false);
        vetorCandidato[2].setNumeroPartido(15);
        vetorCandidato[2].setCargo("Prefeito");

        for (Candidato candidato: vetorCandidato) {
            candidato.exibirInfo();
        }
    }
}
