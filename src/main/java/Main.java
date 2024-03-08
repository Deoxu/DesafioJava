import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] respostasCorretas = {"V", "F", "V", "F", "V", "F", "V", "F", "V", "F", "V", "F", "V", "F", "F", "V", "V", "F", "V", "V"};

        final int MAX_ALUNOS = 50;
        final int MAX_QUESTOES = 20; 

        double fatorCorrecao = -1;
        System.out.print("Insira o fator de correção (3 para ativar, 0 para desativar): ");
        fatorCorrecao = scanner.nextDouble();

        String[][] respostasAlunos = new String[MAX_ALUNOS][MAX_QUESTOES];

 int numAlunos = 0;

        while (numAlunos < MAX_ALUNOS) {
            System.out.println("Aluno " + (numAlunos + 1) + ":");
            System.out.println("Insira as respostas dos alunos (V para verdadeiro, F para falso):");
            for (int j = 0; j < respostasCorretas.length; j++) {
                System.out.print("Questão " + (j + 1) + ": ");
                respostasAlunos[numAlunos][j] = scanner.next().toUpperCase();
            }


            System.out.print("Deseja inserir respostas para outro aluno? (s/n): ");
            String continuar = scanner.next().toLowerCase();
            if (continuar.equals("n")) {
                break;
            }

            numAlunos++;
        }

        System.out.println("\nNotas dos alunos:");
        for (int i = 0; i < numAlunos + 1; i++) {
            double nota = CorretorProva.calcularNota(respostasAlunos[i], respostasCorretas, fatorCorrecao);
            System.out.println("Aluno " + (i + 1) + ": " + nota + " em 20.0");
        }
    }
}