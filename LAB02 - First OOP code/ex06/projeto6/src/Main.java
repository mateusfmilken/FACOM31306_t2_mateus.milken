public class Main {
    public static void main(String[] args) {

        Candidato[] vetorC1 = new Candidato[3];
        Candidato[] vetorC2 = new Candidato[5];

        vetorC1[0] = new Candidato("Adenildo José Leodino da Silva", "29/12/1995", "Masculino", 0.00, false, 12, "Vereador");
        vetorC1[1] = new Candidato("Edivan Lucas da Silva", "03/08/1978", "Masculino", 180000.00, true, 45, "Vereador");
        vetorC1[2] = new Candidato("Alexandre Gilberto Sobreira", "18/02/1974", "asculino", 71545.05, false, 15, "Prefeito");

        vetorC2[0] = new Candidato("José Abelha Neto", "09/05/1963", "Masculino", 171137.79, true, 40, "Vereador");
        vetorC2[1] = new Candidato("Alessandra Rosselli Alencar Boeri", "24/08/1979", "Feminino", 2581890.00, false, 45, "Vereadora");
        vetorC2[2] = new Candidato("Adonis Marcos de Souza", "14/05/1984", "Masculino", 807331.92, true, 23, "Vereador");
        vetorC2[3] = new Candidato("Adriane Barbosa Nogueira Lopes", "26/06/1976", "Feminino", 670436.24, false, 11, "Prefeita");
        vetorC2[4] = new Candidato("José Airton Saraiva", "11/01/1957", "Masculino", 685854.64,false,70, "Vereador");

        Eleicao[] vetorEleicao = new Eleicao[2];

        vetorEleicao[0] = new Eleicao("Colônia Leopoldina", 11244, vetorC1);
        vetorEleicao[1] = new Eleicao("Campo Grande", 646198, vetorC2);

        for (Eleicao eleicao : vetorEleicao) {
            eleicao.exibirInfoEleicao();
            eleicao.maisRico();
        }
    }
}