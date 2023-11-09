package aed.ordenacao.algoritmos;

import aed.Comparacao;

public class InsertionSort<T> extends AlgoritmoOrdenacao<T>{
    public InsertionSort(Comparacao<T> criterio) {
        super(criterio);
    }

    /*
    @Override
    public final void ordenar(T... elementos) {
        for (int i = 0; i < elementos.length; i++) {
            for (int j = i - 1; j > 0; j--) {
                ordenarRecursivo(j,i,elementos);
            }
        }
    }

    private void ordenarRecursivo(int esq,int dir,T... elementos){
        if(esq < 0){
            return;
        }
        if(criterio.comparar(elementos[esq],elementos[dir])>0){
            trocar(elementos,esq,dir);
            ordenarRecursivo(esq-1,dir-1,elementos);
        }
        return;
    }
    */

    public void ordenar(T... elementos){
        for (int i = 0; i < elementos.length; i++) {
            int j=i-1;
            T corrente=elementos[i];
            while(j>=0 && criterio.comparar(corrente,elementos[j])<0){
                elementos[j+1]=elementos[j];
                j--;
            }
            elementos[j+1]=corrente;
        }
    }
}
