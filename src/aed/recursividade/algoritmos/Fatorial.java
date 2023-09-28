package aed.recursividade.algoritmos;

public class Fatorial {
    public static double executar(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("fatorial(" + n + ") = argumento inválido : deve ser maior ou igual a 0");
        }
        return executarRecursivo(n);
    }

    private static double executarRecursivo(int n) {
        return n < 2 ? 1 : n * executarRecursivo(n - 1);
    }

    public static void apresentar(int n){
        try {
            System.out.println("Fatorial("+n+") = " +executar(n));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}