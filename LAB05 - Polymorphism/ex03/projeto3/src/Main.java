public class Main {
    public static void main(String[] args) {
        Universidade u = new Universidade("Universidade Exemplo", "01/01/2000");

        u.adicionarEstudante(new EstudanteGraduacao("Maria", "Rua Maio", "Java is Funny"));
        u.adicionarEstudante(new EstudanteMestrado("Carla", "Rua Primavera", "Medicina",
                "Vacinas de RNA", "Acadêmico", "Estudo dos anticorpos"));
        u.adicionarEstudante(new EstudanteDoutorado("Bruno", "Rua Inverno", "Tecnologia",
                "Processamento de Imagens", "Carros Inteligentes"));
        u.adicionarEstudante(new EstudanteGraduacao("Lucas", "Rua Verão", "Machine Learning"));

        System.out.println("==== Contagem dos Estudantes ====");
        u.contarEstudantes();

        System.out.println("\n==== Lista de Alunos ====");
        u.listarAlunos();

        System.out.println("\n==== Copiando Alunos de Pós-Graduação ====");
        u.copiarPosGraduacao();
    }
}