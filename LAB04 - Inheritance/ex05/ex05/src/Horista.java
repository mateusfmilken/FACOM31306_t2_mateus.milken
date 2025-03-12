public class Horista extends Funcionario {
    public double valorHora;
    public double totalHoras;

    public Horista(String nome, String dataNasc, double valorHora, double totalHoras) {
        super(nome, dataNasc);
        this.valorHora = valorHora;
        this.totalHoras = totalHoras;
    }

    public double calculaSalarioHorista() {
        double salarioH = valorHora * totalHoras;
        return salarioH;
    }

}
