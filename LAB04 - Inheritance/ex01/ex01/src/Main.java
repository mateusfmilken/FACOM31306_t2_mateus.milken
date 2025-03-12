public class Main {
    public static void main(String[] args) {
        CandidatoVereador c1 = new CandidatoVereador("Adenildo José Leodino da Silva", "29/12/1995", "Masculino", 0.00, "Não", 12 , "111", "Joaquim Gomes");
        CandidatoPrefeito c2 = new CandidatoPrefeito("Alexandre Gilberto Sobreira", "18/02/1974", "Masculino", 71545.05, "Não", 15, "Luciana Luna", 15);
        System.out.println("Município: Colônia Leopoldina");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}
