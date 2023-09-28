package aed.recursividade.utilizacao;

import aed.recursividade.algoritmos.Fatorial;

public class MainPraticaFatorial {
    public static void main(String[] args) {
        Fatorial.apresentar(5);
        Fatorial.apresentar(0);
        Fatorial.apresentar(-5);
        Fatorial.apresentar(21);
        for (int i = 0; i < 31; i++) {
            Fatorial.apresentar(i);
        }
    }
}
