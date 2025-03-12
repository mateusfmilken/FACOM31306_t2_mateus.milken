public class Main {
    public static void main(String[] args) {

        Candidato candidato = new Candidato ("Adenildo José Leodino da Silva", "29/12/1995", "Masculino", 0.00, "Não", 12);
        CandidatoVereador c1 = new CandidatoVereador(candidato, "111", "Joaquim Gomes");
        CandidatoPrefeito c2 = new CandidatoPrefeito("Alexandre Gilberto Sobreira", "18/02/1974", "Masculino", 71545.05, "Não", 15, "Luciana Luna", 15);
        System.out.println("Município: Colônia Leopoldina");
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println("O erro em toString acontece pois ele não pode receber diretamente os atributos da classe Candidato, então precisamos utilizar o comando super para que ele imprima os atributos de Candidato normalmente, quando eles estão privados.")
    }
}
