public class Main {
    public static void main(String[] args) {

       Candidato c1 = new Candidato();
       Candidato c2 = new Candidato();
       Candidato c3 = new Candidato();

       c1.nomeC = "Adenildo José Leodino da Silva";
       c1.dataNasc = "29/12/1995";
       c1.genero = "Masculino";
       c1.bens = 0.00;
       c1.reeleicao = false;
       c1.numeroPartido = 12;
       c1.cargo = "Vereador";

       c2.nomeC = "Edivan Lucas da Silva";
       c2.dataNasc = "03/08/1978";
       c2.genero = "masculino";
       c2.bens = 180000.00;
       c2.reeleicao = true;
       c2.numeroPartido = 45;
       c2.cargo = "Vereador";

       c3.nomeC = "Alexandre Gilberto Sobreira";
       c3.dataNasc = "18/02/1974";
       c3.genero = "Masculino";
       c3.bens = 71545.05;
       c3.reeleicao = false;
       c3.numeroPartido = 15;
       c3.cargo = "Prefeito";

       System.out.println("Matrícula: 12321BCC021\nCódigo: 021");
       System.out.println("Município: Colônia Leopoldina 2702108");
       c1.exibirInfo();
       c2.exibirInfo();
       c2.exibirInfo();
    }
}
