package aed.ordenacao.utilizacao;

import aed.ComparacaoInteiros;
import aed.ordenacao.algoritmos.InsertionSort;
import aed.utils.VetorDeInteiros;

public class MainPraticaInsertionSort
{
    public static void main(String[] args){
        InsertionSort<Integer> insertionSort=new InsertionSort<>(ComparacaoInteiros.CRITERIO);
        insertionSort.apresentar(100, VetorDeInteiros.criarAleatorioInteger(100,-100,100,true));
    }
}
