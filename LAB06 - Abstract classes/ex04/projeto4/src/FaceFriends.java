import java.util.*;

public class FaceFriends {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Contato> contatos = new ArrayList<>();

        int opcao;
        do {
            System.out.println("O que deseja fazer?\n1- Inserir Contato\n2- Imprimir Todos\n3- Imprimir Familia\n4- Imprimir Amigos\n5- Imprimir Trabalho\n6- Imprimir Melhor Amigo/Irmão/Colega\n7- Buscar Contato por Índice\n0- Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Tipo (1-Familia, 2-Amigos, 3-Trabalho): ");
                    int tipo = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Apelido: "); String ap = scanner.nextLine();
                    System.out.print("Nome: "); String n = scanner.nextLine();
                    System.out.print("Email: "); String e = scanner.nextLine();
                    System.out.print("Aniversário: "); String aniv = scanner.nextLine();

                    if (tipo == 1) {
                        System.out.print("Parentesco: "); String p = scanner.nextLine();
                        contatos.add(new Familia(ap, n, e, aniv, p));
                    } else if (tipo == 2) {
                        System.out.print("Grau (1-Melhor amigo, 2-Amigo, 3-Conhecido): "); int g = scanner.nextInt();
                        contatos.add(new Amigos(ap, n, e, aniv, g));
                    } else if (tipo == 3) {
                        System.out.print("Tipo no trabalho: "); String t = scanner.nextLine();
                        contatos.add(new Trabalho(ap, n, e, aniv, t));
                    }
                }
                case 2 -> contatos.forEach(Contato::imprimirContato);
                case 3 -> contatos.stream().filter(c -> c instanceof Familia).forEach(Contato::imprimirContato);
                case 4 -> contatos.stream().filter(c -> c instanceof Amigos).forEach(Contato::imprimirContato);
                case 5 -> contatos.stream().filter(c -> c instanceof Trabalho).forEach(Contato::imprimirContato);
                case 6 -> {
                    for (Contato c : contatos) {
                        if (c instanceof Amigos a && a.getGrau() == 1) a.imprimirContato();
                        else if (c instanceof Familia f && f.getParentesco().equalsIgnoreCase("irmão")) f.imprimirContato();
                        else if (c instanceof Trabalho t && t.getTipo().equalsIgnoreCase("colega")) t.imprimirContato();
                    }
                }
                case 7 -> {
                    System.out.print("Digite o índice do contato: ");
                    int idx = scanner.nextInt();
                    if (idx >= 0 && idx < contatos.size()) {
                        Contato c = contatos.get(idx);
                        if (c instanceof Familia) System.out.println("Contato é da Família");
                        else if (c instanceof Amigos) System.out.println("Contato é um Amigo");
                        else if (c instanceof Trabalho) System.out.println("Contato é do Trabalho");
                        c.imprimirContato();
                    } else System.out.println("Índice inválido");
                }
            }
        } while (opcao != 0);

        scanner.close();
    }
}