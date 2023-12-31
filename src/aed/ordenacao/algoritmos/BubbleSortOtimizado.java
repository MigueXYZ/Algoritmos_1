package aed.ordenacao.algoritmos;

import aed.Comparacao;
import aed.ordenacao.algoritmos.AlgoritmoOrdenacao;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class BubbleSortOtimizado<T> extends AlgoritmoOrdenacao<T> {

    public BubbleSortOtimizado(Comparacao<T> criterio) {
        super(criterio);
    }

    public void ordenar(T... elementos) {
        int indiceUltimaTroca = elementos.length;

        do {
            int indiceTroca = 0;
            for (int i = 1; i < indiceUltimaTroca; i++) {
                if (criterio.comparar(elementos[i], elementos[i - 1]) < 0) {
                    trocar(elementos, i, i - 1);
                    indiceTroca = i;
                }
            }
            indiceUltimaTroca = indiceTroca;
        } while (indiceUltimaTroca > 1);
    }

}
