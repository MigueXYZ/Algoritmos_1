package aed.recursividade.algoritmos;

public class Fibonacci {
    public static long executar(int n){
        if (n<0) {
            throw new IllegalArgumentException("Fibonacci("+n+"): é um argumento inválido!");
        }
        return executarRecursivo(n);
    }

    private static long executarRecursivo(int n) {
        return (n < 2 ? n : (executarRecursivo(n - 2) + executarRecursivo(n - 1)));
    }

    public static void apresentar(int n){
        try {
            System.out.println("Fibonnachi("+n+")="+executar(n));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
