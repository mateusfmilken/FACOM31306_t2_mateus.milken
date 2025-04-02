import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de Duetos: ");
        int quantidadeDuetos = scanner.nextInt();
        scanner.nextLine();
        Dueto[] d = new Dueto[quantidadeDuetos];

        for (int i = 0; i < quantidadeDuetos; i++) {
            System.out.println("Cadastro do dueto " + (i + 1) + ":");
            System.out.print("Nome do dueto: ");
            String nomeTime = scanner.nextLine();

            System.out.println("Cadastro dos titulares:");
            System.out.println("Digite o nome do músico 1:");
            String m1 = scanner.nextLine();
            System.out.println("Digite o papel do músico 1:");
            String p1 = scanner.nextLine();
            System.out.println("Digite a experiência (em anos) do músico 1:");
            int e1 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digite a remuneração (reais/hora) do músico 1:");
            int r1 = scanner.nextInt();
            scanner.nextLine();
            Musico titular1 = new Musico(m1, p1, e1, r1);
            System.out.println("Digite o nome do músico 2:");
            String m2 = scanner.nextLine();
            System.out.println("Digite o papel do músico 2:");
            String p2 = scanner.nextLine();
            System.out.println("Digite a experiência (em anos) do músico 2:");
            int e2 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Digite a remuneração (reais/hora) do músico 2:");
            int r2 = scanner.nextInt();
            scanner.nextLine();
            Musico titular2 = new Musico(m2, p2, e2, r2);

            System.out.print("O time tem substituto? (s/n): ");
            char opcao = scanner.next().charAt(0);
            scanner.nextLine();

            if (opcao == 's' || opcao == 'S') {
                System.out.println("Digite o nome do músico substituto:");
                String ms = scanner.nextLine();
                System.out.println("Digite o papel do músico substituto:");
                String ps = scanner.nextLine();
                System.out.println("Digite a experiência (em anos) do músico substituto:");
                int es = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Digite a remuneração (reais/hora) do músico substituto:");
                int rs = scanner.nextInt();
                scanner.nextLine();
                Musico substituto = new Musico(ms, ps, es, rs);
                d[i] = new Dueto(nomeTime, titular1, titular2, substituto);
            } else {
                d[i] = new Dueto(nomeTime, titular1, titular2);
            }
        }

        System.out.println("\nInformações dos times cadastrados:");
        Dueto duetoMaiorMedia = null;
        double maiorMedia = 0;

        for (Dueto dueto : d) {
            System.out.println(dueto);
            System.out.println("------------------------------");

            if (dueto.calcularRemuneracao() > maiorMedia) {
                maiorMedia = dueto.calcularRemuneracao();
                duetoMaiorMedia = dueto;
            }
        }

        if (duetoMaiorMedia != null) {
            System.out.println("\nDueto com maior remuneração média:");
            System.out.println(duetoMaiorMedia);
        }

        for (int i = 0; i < quantidadeDuetos; i++){
        d[i] = null;
        scanner.close();
    }
    }
}