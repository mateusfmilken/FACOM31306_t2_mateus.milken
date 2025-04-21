import java.util.*;

public class Main {
    public static void main(String[] args) {

        EstudanteGraduacao eg = new EstudanteGraduacao("Maria", "Rua Maio", "Java is funny");
        EstudanteDoutorado epd2 = new EstudanteDoutorado("Bruno", "Rua Inverno", "Tecnologia", "Processamento de Imagens", "Carros Inteligentes");
        EstudanteMestrado epm2 = new EstudanteMestrado("Carla", "Rua Primavera", "Medicina", "Vacinas de RNA", "academico", "Anticorpos");
        Estudante e = new Estudante("Carlos", "Rua 1o de Abril");

        List<Estudante> listaEstudantes = new ArrayList<>(); // fazendo ordenação por ArrayList (lista)

        listaEstudantes.add(eg);
        listaEstudantes.add(epd2);
        listaEstudantes.add(epm2);
        listaEstudantes.add(e);

        System.out.println("Antes da ordenação:");
        for (Estudante est : listaEstudantes) {
            est.print();
        }

        Collections.sort(listaEstudantes);

        System.out.println("\nDepois da ordenação por nome:");
        for (Estudante est : listaEstudantes) {
            est.print();
        }

        listaEstudantes.remove(1);
        System.out.println("\nApós remover o segundo elemento:");
        for (Estudante est : listaEstudantes) {
            est.print();
        }

        Stack<Estudante> pilhaEstudantes = new Stack<>(); // fazendo ordenação por pilhas

        pilhaEstudantes.push(eg);
        pilhaEstudantes.push(epm2);

        System.out.println("\nTopo da pilha:");
        pilhaEstudantes.peek().print();

        Estudante retirado = pilhaEstudantes.pop();
        System.out.println("\nEstudante removido da pilha:");
        retirado.print();

        System.out.println("\nPilha restante:");
        for (Estudante est : pilhaEstudantes) {
            est.print();
        }
    }
}