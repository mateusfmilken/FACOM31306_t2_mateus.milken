import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual conceito deseja testar?\n1 - Associação\n2 - Agregação\n3 - Composição\n0 - Sair\n");

        int opcao = sc.nextInt();

        switch (opcao) {
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------
            case 1:

                System.out.print("Esse é o exemplo de programa com associação. Os objetos não dependem de si para existir: o carro pode existir sem o dono e vice-versa.\n");

                Veiculo[] v1 = new Veiculo[2];
                Veiculo[] v2 = new Veiculo[1];
                v1[0] = new Veiculo("HFU8J97", "Volkswagen", "Gol", "Cinza");
                v1[1] = new Veiculo("NIL6A78", "Mercedes", "AMG-64", "Prata");
                v2[0] = new Veiculo("OQO8B77", "Chevrolet", "Corsa", "Preto");

                Dono[] vetorDono = new Dono[2];
                vetorDono[0] = new Dono("Neto", 59, "0000000000", v1);
                vetorDono[1] = new Dono("Ronaldo", 48, "1234567890", v2);

                for (int i = 0; i < 2; i++) {
                    System.out.printf(vetorDono[i].toString());
                    if (i == 0) {
                        for (int j = 0; j < 2; j++) {
                            System.out.printf(v1[j].toString());
                        }
                    }
                    if (i == 1) {
                    System.out.printf(v2[0].toString());
                    }
                }

            break;
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------
            case 2:

                System.out.print("Esse é o exemplo de programa com agregação. Os alunos não dependem da turma para existir, mas fazem parte dela.\n");

                int qtdA = 10;

                Estudante[]  e= new Estudante[qtdA];
                e[0] = new Estudante(18, "Carlos");
                e[1] = new Estudante(20, "Otávio");
                e[2] = new Estudante(19, "Maria Clara");
                e[3] = new Estudante(25, "Gilmar");
                e[4] = new Estudante(16, "Justin");
                e[5] = new Estudante(23, "Ja'Marr");
                e[6] = new Estudante(28, "Aaron");
                e[7] = new Estudante(17, "Kevin");
                e[8] = new Estudante(21, "Westbrook");
                e[9] = new Estudante(22, "Amon-Ra");

                Turma[] vetorTurma = new Turma[1];
                vetorTurma[0] = new Turma("Cálculo 2 BCC - 2024/2", 10, e);

                System.out.printf(vetorTurma[0].toString());

                for (int i = 0; i < 10; i++) {
                    System.out.printf(e[i].toString());
                }

            break;
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------
            case 3:
                System.out.print("Esse é o exemplo de programa com composiçao. O departamento depende da escola para existir.\n");

                Departamento[] d1 =  new Departamento[2];
                d1[0] = new Departamento("Limpeza", 15);
                d1[1] = new Departamento("Direção", 5);

                Escola[] vetorEscola = new Escola[1];
                vetorEscola[0] = new Escola("Maria de Nazaré", "Varginha", d1);

                System.out.printf(vetorEscola[0].toString());
                for (int i = 0; i < 2; i++) {
                    System.out.printf(d1[i].toString());
                }
            break;
// --------------------------------------------------------------------------------------------------------------------------------------------------------------------
            case 0: System.out.println("Saindo..."); return;
        }
    }
}

