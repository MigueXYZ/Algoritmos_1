package aed.analisecomplexidade.utilizacao;


import aed.analisecomplexidade.algoritmos.JogoTorresHanoi;

public class MainPraticaHanoi {
    public static void main(String[] args) {
        int[] ns = {5, 4, 0, 3};
        for (int n : ns) {
            JogoTorresHanoi.apresentar(n);
        }

    }
}
