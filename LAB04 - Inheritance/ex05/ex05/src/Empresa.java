public class Empresa {
    public static void main(String[] args) {

    Chefe[] chefes = new Chefe[2];
    Vendedor[] vendedores = new Vendedor[2];
    Operario[] operarios = new Operario[2];
    Horista[] horistas = new Horista[2];

    chefes[0] = new Chefe("Edmilson Júnior", "23/03/1970", 38000.00);
    chefes[1] = new Chefe("Kelvin Oliveira", "10/10/1995", 21000.00);

    vendedores[0] = new Vendedor("Joabe Cristiano", "18/06/1985", 4000.00, 0.1, 2000);
    vendedores[1] = new Vendedor("Ronaldo Nazário", "21/10/1979", 5000.00, 0.09, 3000);

    operarios[0] = new Operario("Donizete Oliveira", "20/11/2003", 3, 1000);
    operarios[1] = new Operario("Russell Westbrook", "19/09/1988", 4, 2000);

    horistas[0] = new Horista("Jobson Almeida", "19/05/1999", 20, 280);
    horistas[1] = new Horista("Caio Prestes", "03/10/2003", 25, 250);

    for (int i = 0; i < 2; i++) {
        System.out.println("Salário dos funcionários " + (i+1));
        System.out.println("Salário do chefe: " + chefes[i].calculaSalarioChefe());
        System.out.println("Salário do vendedor: " + vendedores[i].calculaSalarioVendedor());
        System.out.println("Salário do operário: " + operarios[i].calculaSalarioOperario());
        System.out.println("Salário do horista: " + horistas[i].calculaSalarioHorista());
    }
}
}
