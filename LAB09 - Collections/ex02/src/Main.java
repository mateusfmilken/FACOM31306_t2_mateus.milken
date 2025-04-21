import java.util.*;

public class Main {
    public static void main(String[] args) {
        Deque<Estudante> filaDupla = new ArrayDeque<>();

        EstudanteGraduacao eg = new EstudanteGraduacao("Maria", "Rua Maio", "Java is funny");
        EstudanteDoutorado ed = new EstudanteDoutorado("Bruno", "Rua Inverno", "Tecnologia", "Processamento de Imagens", "Carros Inteligentes");

        filaDupla.addFirst(eg);       
        filaDupla.offerLast(ed);

        System.out.println("Deque após inserções:");
        for (Estudante est : filaDupla) {
            est.print();
        }

        System.out.println("\nPrimeiro elemento (getFirst):");
        try {
            Estudante primeiro = filaDupla.getFirst();  // lança exceção se vazio
            primeiro.print();
        } catch (NoSuchElementException e) {
            System.out.println("Deque está vazio! (getFirst)");
        }

        System.out.println("\nÚltimo elemento (peekLast):");
        Estudante ultimo = filaDupla.peekLast();
        if (ultimo != null) {
            ultimo.print();
        } else {
            System.out.println("Deque está vazio! (peekLast)");
        }

        System.out.println("\nRemovendo primeiro (removeFirst):");
        try {
            Estudante removido = filaDupla.removeFirst();
            removido.print();
        } catch (NoSuchElementException e) {
            System.out.println("Não foi possível remover: deque vazio!");
        }

        System.out.println("\nRemovendo restante (pollLast):");
        Estudante outroRemovido = filaDupla.pollLast();
        if (outroRemovido != null) {
            outroRemovido.print();
        } else {
            System.out.println("Deque estava vazio na tentativa de pollLast.");
        }

        System.out.println("\nTentando acessar primeiro de deque vazio (getFirst):");
        try {
            Estudante falha = filaDupla.getFirst();  // exceção esperada aqui
            falha.print();
        } catch (NoSuchElementException e) {
            System.out.println("Exceção capturada: deque está vazio ao chamar getFirst().");
        }
    }
}