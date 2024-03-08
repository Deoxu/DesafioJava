public class CorretorProva {
    public static double calcularNota(String[] respostasAluno, String[] respostasCorretas, double fatorCorrecao) {
        int numQuestoes = respostasCorretas.length;
        int numAcertos = 0;
        int numErros = 0;

        for (int i = 0; i < numQuestoes; i++) {
            if (respostasAluno[i].equalsIgnoreCase(respostasCorretas[i])) {
                numAcertos++;
            } else {
                numErros++;
            }
        }

        if (fatorCorrecao > 0) {
            numAcertos -= numErros / fatorCorrecao;
        }

        numAcertos = Math.max(numAcertos, 0);

        double nota = (double) numAcertos / numQuestoes * 20;

        return nota;
    }
}
