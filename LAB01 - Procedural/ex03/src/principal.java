import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;

class Aluno {
    int numeroMatricula;
    char classeSocial;
    double cra;
}

public class principal {

    public static void ex01() {
        Scanner sc = new Scanner(System.in);
        int val1, val2, val3, val4, val5, val6;

        System.out.println("<< Listando um vetor >>");
        System.out.println("Entre com o número 1:");
        val1 = sc.nextInt();

        System.out.println("Entre com o número 2:");
        val2 = sc.nextInt();

        System.out.println("Entre com o número 3:");
        val3 = sc.nextInt();

        System.out.println("Entre com o número 4:");
        val4 = sc.nextInt();

        System.out.println("Entre com o número 5:");
        val5 = sc.nextInt();

        System.out.println("Entre com o número 6:");
        val6 = sc.nextInt();

        System.out.println("Os valores lidos são:");
        System.out.printf("%d %d %d %d %d %d\n", val1, val2, val3, val4, val5, val6);

        sc.close();
    }

    public static void ex02() {
        Scanner sc = new Scanner(System.in);
        int[] vet = new int[6];
        System.out.println("<< Listando um vetor >>");

        for (int i = 0; i < 6; i++) {
            System.out.printf("Entre com o número %d:\n", i + 1);
            vet[i] = sc.nextInt();
        }

        System.out.println("Os valores lidos são:");
        for (int i = 0; i < 6; i++) {
            System.out.printf("%d ", vet[i]);
        }
        System.out.println();

        sc.close();
    }

    public static void ex03() {
        Scanner sc = new Scanner(System.in);
        int[] vet = new int[6];

        System.out.println("<< Listando um vetor em ordem inversa >>");

        for (int i = 0; i < 6; i++) {
            System.out.printf("Entre com o número %d: ", i + 1);
            vet[i] = sc.nextInt();
        }
        
        System.out.println("\nA ordem inversa dos números é:");
        for (int i = 5; i >= 0; i--) {
            System.out.printf("%d ", vet[i]);
        }
        System.out.println();

        sc.close();
    }

    public static void ex04() {
        Scanner sc = new Scanner(System.in);
        int[] vet = new int[6];
        System.out.println("<< Listando um vetor de números pares >>");

        for (int i = 0; i < 6; i++) {
            while (true) {
                System.out.printf("Entre com o número %d: ", i + 1);
                int num = sc.nextInt();

                if (num % 2 == 0) {
                    vet[i] = num;
                    break;
                } else {
                    System.out.println("Erro: Valor inválido\n");
                }
            }
        }

        System.out.println("\nOs números pares digitados foram:");
        for (int i = 0; i < 6; i++) {
            System.out.printf("%d ", vet[i]);
        }
        System.out.println();

        sc.close();
    }

    public static void ex05() {
        Scanner sc = new Scanner(System.in);
        int[] vet = new int[5];
        int maior, menor;
        double soma = 0;

        System.out.println("<< 5 valores >>");

        for (int i = 0; i < 5; i++) {
            System.out.printf("Entre com o número %d: ", i + 1);
            vet[i] = sc.nextInt();
            soma += vet[i];
        }

        maior = menor = vet[0];
        for (int i = 1; i < 5; i++) {
            if (vet[i] > maior) {
                maior = vet[i];
            }
            if (vet[i] < menor) {
                menor = vet[i];
            }
        }

        System.out.println("\nOs números digitados são:");
        for (int num : vet) {
            System.out.printf("%d ", num);
        }

        System.out.printf("\nO maior valor é: %d", maior);
        System.out.printf("\nO menor valor é: %d", menor);
        System.out.printf("\nA média é: %.1f\n", soma / 5);

        sc.close();
    }

    public static void ex06() {
        Scanner sc = new Scanner(System.in);
        int[] vet = new int[5];
        int maior, menor, indiceMaior = 0, indiceMenor = 0;
        double soma = 0;

        System.out.println("<< 5 valores >>");

        for (int i = 0; i < 5; i++) {
            System.out.printf("Entre com o número %d: ", i + 1);
            vet[i] = sc.nextInt();
            soma += vet[i];
        }

        maior = menor = vet[0];
        for (int i = 1; i < 5; i++) {
            if (vet[i] > maior) {
                maior = vet[i];
                indiceMaior = i;
            }
            if (vet[i] < menor) {
                menor = vet[i];
                indiceMenor = i;
            }
        }

        System.out.println("\nOs números digitados são:");
        for (int num : vet) {
            System.out.printf("%d ", num);
        }

        System.out.printf("\nO maior valor é: %d, localizado na posição %d do vetor", maior, indiceMaior + 1);
        System.out.printf("\nO menor valor é: %d, localizado na posição %d do vetor", menor, indiceMenor + 1);
        System.out.printf("\nA média é: %.1f\n", soma / 5);

        sc.close();
    }

    public static void ex07() {
        Scanner sc = new Scanner(System.in);
        int[] notas = new int[5];
        int maiorNota = 0;

        System.out.println("<< Normalizando as notas >>");

        for (int i = 0; i < 5; i++) {
            System.out.printf("Entre com a nota do aluno %d: ", i + 1);
            notas[i] = sc.nextInt();
            if (notas[i] > maiorNota) {
                maiorNota = notas[i];
            }
        }

        System.out.println("\nNotas normalizadas");
        for (int i = 0; i < 5; i++) {
            int notaNormalizada = (notas[i] * 100) / maiorNota;
            System.out.printf("A nota do aluno %d é %d\n", i + 1, notaNormalizada);
        }

        sc.close();
    }

    public static void ex08() {
        Scanner sc = new Scanner(System.in);
        double[] valores = new double[5];
        double soma = 0, media, desvioPadrao = 0;

        System.out.println("<< Média e desvio-padrão >>");

        for (int i = 0; i < 5; i++) {
            System.out.printf("Digite o valor %d: ", i + 1);
            valores[i] = sc.nextDouble();
            soma += valores[i];
        }

        media = soma / 5;

        for (int i = 0; i < 5; i++) {
            desvioPadrao += Math.pow(valores[i] - media, 2);
        }

        desvioPadrao = Math.sqrt(desvioPadrao / (5 - 1));

        System.out.printf("A média é %.2f e o desvio-padrão é %.13f\n", media, desvioPadrao);

        sc.close();
    }
    public static void ex09() {
        Scanner sc = new Scanner(System.in);

        System.out.println("<< Média de n alunos. Máximo 100 alunos >>");
        System.out.print("Entre com o número de alunos: ");
        int numAlunos = sc.nextInt();

        if (numAlunos > 100) {
            System.out.println("Erro! O número máximo de alunos permitido é 100.");
        } else {
            double[] notas = new double[numAlunos];
            double soma = 0;

            for (int i = 0; i < numAlunos; i++) {
                System.out.print("Digite a nota do aluno " + (i + 1) + ": ");
                notas[i] = sc.nextDouble();
                soma += notas[i];
            }

            System.out.println("\nRelatório de Notas");
            for (int i = 0; i < numAlunos; i++) {
                System.out.println("A nota do aluno " + i + " é: " + notas[i]);
            }

            double media = soma / numAlunos;
            System.out.printf("A média da turma é: %.2f\n", media);
        }

        sc.close();
    }

    public static void ex10() {
        Scanner sc = new Scanner(System.in);
        int[] A = new int[3];
        int[] B = new int[3];
        int[] C = new int[3];

        System.out.println("<< Subtração de vetores >>");

        for (int i = 0; i < 3; i++) {
            System.out.print("Digite o valor " + (i + 1) + " de A: ");
            A[i] = sc.nextInt();
        }

        System.out.println();

        for (int i = 0; i < 3; i++) {
            System.out.print("Digite o valor " + (i + 1) + " de B: ");
            B[i] = sc.nextInt();
        }

        for (int i = 0; i < 3; i++) {
            C[i] = A[i] - B[i];
        }

        System.out.print("\nO vetor C, definido como C = A - B é (");
        for (int i = 0; i < 3; i++) {
            System.out.print(C[i]);
            if (i < 2) {
                System.out.print(", ");
            }
        }
        System.out.println(")");

        sc.close();
    }

        public static void ex11() {
            Scanner sc = new Scanner(System.in);
            int[] v = new int[5];
            int[] v1 = new int[5];
            int[] v2 = new int[5];
            int countV1 = 0, countV2 = 0;

            System.out.println("<< Pares e Ímpares >>");

            for (int i = 0; i < 5; i++) {
                System.out.print("Digite o valor " + (i + 1) + ": ");
                v[i] = sc.nextInt();

                if (v[i] % 2 == 0) {
                    v2[countV2++] = v[i];
                } else {
                    v1[countV1++] = v[i];
                }
            }

            System.out.print("\nÍmpares: ");
            for (int i = 0; i < countV1; i++) {
                System.out.print(v1[i]);
                if (i < countV1 - 1) {
                    System.out.print(", ");
                }
            }

            System.out.print("\nPares: ");
            for (int i = 0; i < countV2; i++) {
                System.out.print(v2[i]);
                if (i < countV2 - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println();
            sc.close();
        }

    public static void ex12() {
        Scanner sc = new Scanner(System.in);
        int verde, azul, amarela, vermelha;
        int totalBolinhas;

        System.out.println("<< Probabilidades >>");

        System.out.print("Digite a quantidade de bolinhas\nVerde: ");
        verde = sc.nextInt();
        System.out.print("Azul: ");
        azul = sc.nextInt();
        System.out.print("Amarela: ");
        amarela = sc.nextInt();
        System.out.print("Vermelha: ");
        vermelha = sc.nextInt();

        totalBolinhas = verde + azul + amarela + vermelha;

        double probVerde = (verde * 100.0) / totalBolinhas;
        double probAzul = (azul * 100.0) / totalBolinhas;
        double probAmarela = (amarela * 100.0) / totalBolinhas;
        double probVermelha = (vermelha * 100.0) / totalBolinhas;

        double maxProb = Math.max(Math.max(probVerde, probAzul), Math.max(probAmarela, probVermelha));

        System.out.println("\nProbabilidades");
        System.out.printf("Verde: %.1f%%", probVerde);
        if (probVerde == maxProb) System.out.print(" << Maior probabilidade");
        System.out.println();

        System.out.printf("Azul: %.1f%%", probAzul);
        if (probAzul == maxProb) System.out.print(" << Maior probabilidade");
        System.out.println();

        System.out.printf("Amarela: %.1f%%", probAmarela);
        if (probAmarela == maxProb) System.out.print(" << Maior probabilidade");
        System.out.println();

        System.out.printf("Vermelha: %.1f%%", probVermelha);
        if (probVermelha == maxProb) System.out.print(" << Maior probabilidade");
        System.out.println();

        sc.close();
    }

    public static void ex13() {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[5];

        System.out.println("<< Zerando negativos >>");

        for (int i = 0; i < 5; i++) {
            System.out.print("Entre com o número " + (i + 1) + ": ");
            vetor[i] = sc.nextInt();

            if (vetor[i] < 0) {
                vetor[i] = 0;
            }
        }

        System.out.print("\nZerando os negativos, obtém-se: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(vetor[i] + " ");
        }

        System.out.println();
        sc.close();
    }

    public static void ex14() {
        Scanner sc = new Scanner(System.in);

        System.out.println("<< Universidade X >>");
        System.out.print("Quantos alunos serão cadastrados: ");
        int qtdAlunos = sc.nextInt();

        if (qtdAlunos > 10000 || qtdAlunos <= 0) {
            System.out.println("Erro! O número de alunos deve estar entre 1 e 10000.");
            return;
        }

        Aluno[] alunos = new Aluno[qtdAlunos];

        for (int i = 0; i < qtdAlunos; i++) {
            alunos[i] = new Aluno();

            System.out.print("\nEntre com o número do aluno: ");
            alunos[i].numeroMatricula = sc.nextInt();

            System.out.print("Entre com a classe social do aluno " + alunos[i].numeroMatricula + ": ");
            alunos[i].classeSocial = sc.next().toUpperCase().charAt(0);

            System.out.print("Entre com o CRA do aluno " + alunos[i].numeroMatricula + ": ");
            alunos[i].cra = sc.nextDouble();
        }

        System.out.println("\n==== Alunos Cadastrados ====");
        for (int i = 0; i < qtdAlunos; i++) {
            System.out.printf("Número: %d Classe Social: %c CRA: %.2f%n",
                    alunos[i].numeroMatricula, alunos[i].classeSocial, alunos[i].cra);
        }

        sc.close();
    }

    public static void ex15() {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[8];
        HashSet<Integer> numerosVistos = new HashSet<>();
        HashSet<Integer> repetidos = new HashSet<>();

        System.out.println("<< Valores iguais >>");

        for (int i = 0; i < 8; i++) {
            System.out.print("Entre com o número " + (i + 1) + ": ");
            vetor[i] = sc.nextInt();

            if (!numerosVistos.add(vetor[i])) {
                repetidos.add(vetor[i]);
            }
        }

        System.out.print("\nValores repetidos: ");
        if (repetidos.isEmpty()) {
            System.out.println("Nenhum número se repete.");
        } else {
            int count = 0;
            for (int num : repetidos) {
                System.out.print(num);
                if (++count < repetidos.size()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        sc.close();
    }

    public static void ex16() {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[8];
        HashMap<Integer, Integer> contagem = new HashMap<>();

        System.out.println("<< Valores iguais >>");

        for (int i = 0; i < 8; i++) {
            System.out.print("Entre com o número " + (i + 1) + ": ");
            vetor[i] = sc.nextInt();

            contagem.put(vetor[i], contagem.getOrDefault(vetor[i], 0) + 1);
        }

        System.out.println("\nValores repetidos:");

        boolean temRepetidos = false;
        for (var entry : contagem.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " aparece " + entry.getValue() + " vezes");
                temRepetidos = true;
            }
        }

        if (!temRepetidos) {
            System.out.println("Nenhum número se repete.");
        }

        sc.close();
    }

    public static void main(String[] args) {
        // ex01();
        // ex02();
        // ex03();
        // ex04();
        // ex05();
        // ex06();
        // ex07();
        // ex08();
        // ex09();
        // ex10();
        // ex11();
        // ex12();
        // ex13();
        // ex14();
        // ex15();
        // ex16();

    }
}