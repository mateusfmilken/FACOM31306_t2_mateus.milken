import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Candidato c1 = new Candidato();
        c1.setNomeC("Adenildo José Leodino da Silva");
        c1.setDataNasc("29/12/1995");
        c1.setGenero("Masculino");
        c1.setBens(0.00);
        c1.setReeleicao(false);
        c1.setNumeroPartido(12);
        c1.setCargo("Vereador");

        Candidato c2 = new Candidato();
        c2.setNomeC("Edivan Lucas da Silva");
        c2.setDataNasc("03/08/1978");
        c2.setGenero("Masculino");
        c2.setBens(180000.00);
        c2.setReeleicao(true);
        c2.setNumeroPartido(45);
        c2.setCargo("Vereador");

        Candidato c3 = new Candidato();
        c3.setNomeC("Alexandre Gilberto Sobreira");
        c3.setDataNasc("18/02/1974");
        c3.setGenero("Masculino");
        c3.setBens(71545.05);
        c3.setReeleicao(false);
        c3.setNumeroPartido(15);
        c3.setCargo("Prefeito");

        System.out.println("Matrícula: 12321BCC021\nCódigo: 021");
        System.out.println("Município: Colônia Leopoldina 2702108");

        c1.exibirInfo();
        c2.exibirInfo();
        c3.exibirInfo();

        String resposta;
        do {
            System.out.print("Deseja alterar algum candidato? (s/n): ");
            resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
                System.out.print("Qual candidato deseja alterar? (1, 2 ou 3): ");
                int escolha = scanner.nextInt();
                scanner.nextLine(); 

                Candidato candidatoSelecionado;
                if (escolha == 1) {
                    candidatoSelecionado = c1;
                } else if (escolha == 2) {
                    candidatoSelecionado = c2;
                } else if (escolha == 3) {
                    candidatoSelecionado = c3;
                } else {
                    System.out.println("Opção inválida.");
                    continue;
                }

                // Alterando valores do candidato escolhido
                System.out.print("Novo nome: ");
                candidatoSelecionado.setNomeC(scanner.nextLine());

                System.out.print("Nova data de nascimento: ");
                candidatoSelecionado.setDataNasc(scanner.nextLine());

                System.out.print("Novo gênero: ");
                candidatoSelecionado.setGenero(scanner.nextLine());

                System.out.print("Novo valor de bens: R$");
                candidatoSelecionado.setBens(scanner.nextDouble());
                scanner.nextLine(); 

                System.out.print("Nova situação de reeleição (sim/não): ");
                String reeleicaoInput = scanner.nextLine();
                candidatoSelecionado.setReeleicao(reeleicaoInput.equalsIgnoreCase("sim"));

                System.out.print("Novo número do partido: ");
                candidatoSelecionado.setNumeroPartido(scanner.nextInt());
                scanner.nextLine(); 

                System.out.print("Novo cargo: ");
                candidatoSelecionado.setCargo(scanner.nextLine());

                // Exibindo informações após a alteração
                System.out.println("\nInformações após atualização:");
                candidatoSelecionado.exibirInfo();
            }
        } while (resposta.equalsIgnoreCase("s"));

        System.out.println("Nenhuma alteração feita. Encerrando programa.");
        scanner.close();
    }
}
