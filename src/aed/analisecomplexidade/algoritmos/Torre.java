package aed.analisecomplexidade.algoritmos;

import java.util.NoSuchElementException;

public class Torre {
    private char nome;
    private int numeroDiscos;
    private int[] baseEDiscos;

    public Torre(char nome, int numeroMaxDiscos) {
        this.nome = nome;
        this.numeroDiscos = 0;
        this.baseEDiscos = new int[numeroMaxDiscos + 1];
        this.baseEDiscos[0] = 3 * numeroMaxDiscos;
    }

    public void preencherComDiscos() {
        int length = baseEDiscos.length;
        for (int i = 1; i < length; i++) {
            baseEDiscos[i] = length - i;
        }
        numeroDiscos = length - 1;
    }

    public void moverDisco(Torre torreDestina)  {
        if (this.numeroDiscos == 0) {
            throw new ArrayIndexOutOfBoundsException("A torre   está vazia");
        }
        if (torreDestina.numeroDiscos == torreDestina.baseEDiscos.length - 1) {
            throw new NoSuchElementException("A torre destino está cheia");
        }
        if(this.baseEDiscos[this.numeroDiscos]<= torreDestina.baseEDiscos[torreDestina.numeroDiscos]){
            throw new IllegalArgumentException("Disco a mover não menor do que o disco do topo da torre de destino");
        }


        //a 1 e 4 podem ser juntas desta forma
        torreDestina.baseEDiscos[++torreDestina.numeroDiscos] = this.baseEDiscos[this.numeroDiscos];
        //a 2 e 3 podem ser juntas assim
        this.baseEDiscos[numeroDiscos--] = 0;

        // 1
        //torreDestina.baseEDiscos[torreDestina.numeroDiscos+1]=this.baseEDiscos[this.numeroDiscos];
        // 2
        //this.baseEDiscos[numeroDiscos]=0;
        // 3
        //this.numeroDiscos--;
        // 4 pode ser feita antes da numero 2 tbm
        // torreDestina.numeroDiscos++;
    }

}
