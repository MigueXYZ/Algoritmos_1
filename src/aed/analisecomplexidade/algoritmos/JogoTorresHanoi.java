package aed.analisecomplexidade.algoritmos;
public class JogoTorresHanoi {
    public static void executar(int numeroDiscos){
        if (numeroDiscos < 1) {
            throw new IllegalArgumentException("Argumento " + numeroDiscos + " Inválido");
        }
        Torre torre_A =new Torre('A',numeroDiscos);
        Torre torre_B =new Torre('B',numeroDiscos);
        Torre torre_C =new Torre('C',numeroDiscos);
        torre_A.preencherComDiscos();

        executarRecursivo(numeroDiscos, torre_A, torre_B, torre_C);
    }

    private static void executarRecursivo(int n, Torre torre_inicio, Torre torre_auxiliar, Torre torre_destino){
        if (n < 2) {
            //overDisco(n, torre_inicio, torre_destino);
            torre_inicio.moverDisco(torre_destino);
            return;
        }
        executarRecursivo(n - 1, torre_inicio, torre_destino, torre_auxiliar);
        //moverDisco(n,torre_inicio,torre_destino);
        torre_inicio.moverDisco(torre_destino);
        executarRecursivo(n - 1, torre_auxiliar, torre_inicio, torre_destino);
    }

    private static void moverDisco(int n, char torre_inicio, char torre_destino) {
        System.out.println("Mover disco: " + n + " da torre " + torre_inicio + " para a torre " + torre_destino);

    }

    public static void apresentar(int n) {
        try {
            executar(n);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
