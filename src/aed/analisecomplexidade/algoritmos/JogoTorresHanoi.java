package aed.analisecomplexidade.algoritmos;
public class JogoTorresHanoi {
    private static int mov;
    public static void executar(int n, char torre_inicio, char torre_auxiliar, char torre_destino) {
        if (n < 1) {
            throw new IllegalArgumentException("Argumento " + n + " Inválido");
        }
        mov=0;
        executarRecursivo(n, torre_inicio, torre_auxiliar, torre_destino);
    }

    private static void executarRecursivo(int n, char torre_inicio, char torre_auxiliar, char torre_destino) {
        if (n < 2) {
            moverDisco(n, torre_inicio, torre_destino);
            return;
        }
        executarRecursivo(n - 1, torre_inicio, torre_destino, torre_auxiliar);
        moverDisco(n,torre_inicio,torre_destino);
        executarRecursivo(n - 1, torre_auxiliar, torre_inicio, torre_destino);
    }

    private static void moverDisco(int n, char torre_inicio, char torre_destino) {
        System.out.println("Mover disco: " + n + " da torre " + torre_inicio + " para a torre " + torre_destino);
        mov +=1;
        System.out.println("Mov: "+ mov);
    }

    public static void apresentar(int n, char torre_inicio, char torre_destino, char torre_auxiliar) {
        try {
            executar(n, torre_inicio, torre_destino, torre_auxiliar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
