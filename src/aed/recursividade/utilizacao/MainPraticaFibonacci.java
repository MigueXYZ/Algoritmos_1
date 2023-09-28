package aed.recursividade.utilizacao;

import aed.recursividade.algoritmos.Fibonacci;

public class MainPraticaFibonacci {
    public static void main(String[] args) {
        Fibonacci.apresentar(5);
        Fibonacci.apresentar(0);
        Fibonacci.apresentar(-10);
        Fibonacci.apresentar(40);
        Fibonacci.apresentar(45);
        for (int i = 4; i < 21; i++) {
            Fibonacci.apresentar(i);
        }
    }
}
