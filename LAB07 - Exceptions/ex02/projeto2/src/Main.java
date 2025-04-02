public class Main {
    public static void main(String[] args) {
        Operacao op = new Operacao();

        System.out.println("Teste 1: 6 / 2");
        op.iniciarOperacao(6, 2);

        System.out.println("\nTeste 2: 10 / 0");
        op.iniciarOperacao(10, 0);
    }
}
