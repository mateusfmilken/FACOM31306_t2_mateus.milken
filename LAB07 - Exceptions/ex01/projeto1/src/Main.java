public class Main {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("Robmilson","123211230932", 18000.00, 23000.0);
        double p1 = 0;
        System.out.println(f1.toString());
        System.out.println("Salário modificado: " + f1.aumentaSalario(p1));
        Funcionario f2 = new Funcionario("Eduardo", "12341234561", 5000.00, 6400.00);
        double p2 = 4000;
        System.out.println(f2.toString());
        System.out.println("Salário modificado: " + f2.aumentaSalario(p2));
    }
}