package aed.pesquisa.algoritmos;

import aed.Comparacao;

public class PesquisaTernariaIterativa<T> extends AlgoritmoPesquisa<T> {
    public PesquisaTernariaIterativa(Comparacao<T> criterio) {
        super(criterio);
    }

    public int pesquisar(T elemento, T... elementos) {
        int indiceUltimoElemento = elementos.length - 1;
        if (elementos.length == 0 ||
                criterio.comparar(elemento, elementos[0]) < 0 ||
                criterio.comparar(elemento, elementos[indiceUltimoElemento]) > 0) {
            return NAO_ENCONTRADO;
        }
        int esq=0;
        int dir = indiceUltimoElemento;
        int terco;
        int terco_1;
        int terco_2=0;
        int cp=1;
        while(cp!=0){
             terco = (dir-esq)/3;
             terco_1 = esq+terco;
             terco_2 = dir-terco;
            if(esq > dir){
                return NAO_ENCONTRADO;
            }
            cp = criterio.comparar(elemento, elementos[terco_1]);
            if(cp<0){
                dir = terco_1-1;
            }
            if(cp>0){
                cp = criterio.comparar(elemento, elementos[terco_2]);
                if(cp<0){
                    esq=terco_1+1;
                    dir=terco_2-1;
                }
                if(cp>0){
                    esq=terco_2+1;
                }
            }
        }
        return terco_2;

    }

}
