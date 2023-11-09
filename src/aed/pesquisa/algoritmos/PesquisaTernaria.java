package aed.pesquisa.algoritmos;

import aed.Comparacao;

public class PesquisaTernaria<T> extends AlgoritmoPesquisa<T> {
    public PesquisaTernaria(Comparacao<T> criterio) {
        super(criterio);
    }

    public int pesquisar(T elemento, T... elementos) {
        int indiceUltimoElemento = elementos.length - 1;
        if (elementos.length == 0 ||
                criterio.comparar(elemento, elementos[0]) < 0 ||
                criterio.comparar(elemento, elementos[indiceUltimoElemento]) > 0) {
            return NAO_ENCONTRADO;
        }
        return pesquisarRecursivo(elemento, 0, indiceUltimoElemento, elementos);
    }

    public int pesquisarRecursivo(T elemento, int esq, int dir, T... elementos) {
        if (esq > dir) {
            return NAO_ENCONTRADO;
        }
        int terco_1 = esq+(dir - esq) / 3;
        int terco_2 = esq+(dir - esq) * 2 / 3;
        int cp = criterio.comparar(elemento, elementos[terco_1]);
        if(cp<0){
            return pesquisarRecursivo(elemento,esq,terco_1-1,elementos);
        }
        if(cp==0){
            return terco_1;
        }
        cp = criterio.comparar(elemento, elementos[terco_2]);
        if(cp<0){
            return pesquisarRecursivo(elemento,terco_1+1,terco_2-1,elementos);
        }
        if(cp>0){
            return pesquisarRecursivo(elemento,terco_2+1,dir,elementos);
        }
        return terco_2;

    }

}
