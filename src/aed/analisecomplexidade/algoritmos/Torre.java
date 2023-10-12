package aed.analisecomplexidade.algoritmos;

public class Torre {
    private char nome;
    private int numeroDiscos;
    private int[] baseEDiscos;
    public Torre(char nome,int numeroMaxDiscos){
        this.nome=nome;
        this.numeroDiscos=0;
        this.baseEDiscos= new int[numeroMaxDiscos+1];
        this.baseEDiscos[0]=3*numeroMaxDiscos;
    }
    public void preencherComDiscos(){
        for (int i = 1; i < baseEDiscos.length; i++) {
            baseEDiscos[i]= baseEDiscos.length-i;
        }
        numeroDiscos=baseEDiscos.length-1;
    }

    public void moverDisco(Torre torreDestina) throws Exception {
        if(this.numeroDiscos==0) {
            throw new Exception("A torre   está vazia");
        }
        if(torreDestina.numeroDiscos==torreDestina.baseEDiscos.length){
            throw new Exception("A torre destino está cheia");
        }

        //a 1 e 4 podem ser juntas desta forma
        torreDestina.baseEDiscos[++torreDestina.numeroDiscos]=this.baseEDiscos[this.numeroDiscos];
        // 1
        //torreDestina.baseEDiscos[torreDestina.numeroDiscos+1]=this.baseEDiscos[this.numeroDiscos];
        // 2
        this.baseEDiscos[numeroDiscos]=0;
        // 3
        this.numeroDiscos--;
        // 4 pode ser feita antes da numero 2 tbm
        // torreDestina.numeroDiscos++;
    }

}
