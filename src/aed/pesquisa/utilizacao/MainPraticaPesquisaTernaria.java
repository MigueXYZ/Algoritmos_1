package aed.pesquisa.utilizacao;

import aed.ComparacaoInteiros;
import aed.pesquisa.algoritmos.PesquisaBinaria;
import aed.pesquisa.algoritmos.PesquisaTernaria;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class MainPraticaPesquisaTernaria {

    public static void main(String[] args) {
        PesquisaTernaria<Integer> pesquisaTernaria = new PesquisaTernaria<>(ComparacaoInteiros.CRITERIO);
        pesquisaTernaria.apresentar(20, 7, 7);
        pesquisaTernaria.apresentar(20, 7, 1, 2, 4, 5, 6, 7, 8, 9);
        pesquisaTernaria.apresentar(20, 3, 1, 2, 4, 5, 6, 7, 8, 9);
    }
}
