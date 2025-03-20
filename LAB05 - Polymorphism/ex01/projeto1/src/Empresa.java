public class Empresa {
    public static void main(String[] args) {

        Funcionario[] funcionarios = new Funcionario[4];

        funcionarios[0] = new Chefe("Edmilson Júnior", "23/03/1970", 38000.00);

        funcionarios[1] = new Vendedor("Joabe Cristiano", "18/06/1985", 4000.00, 0.1, 2000);

        funcionarios[2] = new Operario("Donizete Oliveira", "20/11/2003", 3, 1000);

        funcionarios[3] = new Horista("Jobson Almeida", "19/05/1999", 20, 280);

        System.out.println("Salário dos funcionários: ");
        System.out.println("Salário do chefe: " + funcionarios[0].getSalario());
        System.out.println("Salário do vendedor: " + funcionarios[1].getSalario());
        System.out.println("Salário do operário: " + funcionarios[2].getSalario());
        System.out.println("Salário do horista: " + funcionarios[3].getSalario());
    }
}