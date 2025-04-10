public class Main {
    public static void main(String[] args) {

        Classificavel[] c = new Cliente[3];
        Classificavel[] p = new Produto[3];
        Classificavel[] s = new Servico[3];

        c[0] = new Cliente("Edmilson");
        c[1] = new Cliente("Carlos");
        c[2] = new Cliente("Cesar");

        p[0] = new Produto(149);
        p[1] = new Produto(1);
        p[2] = new Produto(150);

        s[0] = new Servico(150.00);
        s[1] = new Servico(2000.00);
        s[2] = new Servico(151.00);

        Classificador c1 = new Classificador();

        System.out.println("Vetores antes de ordenar:");
        imprimeBonitinho("Clientes", c);
        imprimeBonitinho("Produtos", p);
        imprimeBonitinho("Serviços", s);

        c1.ordena(c);
        c1.ordena(p);
        c1.ordena(s);

        System.out.println("Vetores após a ordenação crescente:");
        imprimeBonitinho("Clientes", c);
        imprimeBonitinho("Produtos", p);
        imprimeBonitinho("Serviços", s);
    }

    public static void imprimeBonitinho(String nomeVetor, Classificavel[] vetor) {
        System.out.println(nomeVetor + ":");
        for (Classificavel item : vetor) {
            System.out.println(item.toString());
        }
        System.out.println();
    }
}