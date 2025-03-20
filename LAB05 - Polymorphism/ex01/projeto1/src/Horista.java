public class Horista extends Funcionario {
    public double valorHora;
    public double totalHoras;
    public double salario;

    public Horista(String nome, String dataNasc, double valorHora, double totalHoras) {
        super(nome, dataNasc);
        this.valorHora = valorHora;
        this.totalHoras = totalHoras;
        this.salario = valorHora * totalHoras;
    }

    public double getSalario() {
        return salario;
    }

}