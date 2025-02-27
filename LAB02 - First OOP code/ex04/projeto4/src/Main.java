public class Main {
    public static void main(String[] args) {

        Candidato c1 = new Candidato("Adenildo José Leodino da Silva", "29/12/1995", "Masculino", 0.00, false, 12 , "Vereador");
        Candidato c2 = new Candidato("Edivan Lucas da Silva", "03/08/1978", "Masculino", 180000.00, true, 45, "Vereador");
        Candidato c3 = new Candidato("Alexandre Gilberto Sobreira", "18/02/1974", "asculino", 71545.05, false, 15, "Prefeito");

        System.out.println("Matrícula: 12321BCC021\nCódigo: 021");
        System.out.println("Município: Colônia Leopoldina 2702108");

        c1.exibirInfo();
        c2.exibirInfo();
        c3.exibirInfo();

    }
}