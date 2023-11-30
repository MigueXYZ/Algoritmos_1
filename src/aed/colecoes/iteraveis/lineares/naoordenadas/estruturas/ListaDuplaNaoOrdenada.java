package aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

import aed.colecoes.iteraveis.ColecaoIteravel;
import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class ListaDuplaNaoOrdenada<T> implements ColecaoIteravelLinearNaoOrdenada<T> {
    //bro wtf is the purpose of this??
    private static final long serialVersionUID = 1L;
    protected No base;
    protected int numeroElementos;
    private int indice;

    public ListaDuplaNaoOrdenada() {
        base = new No();
        numeroElementos = 0;
    }

    protected No getNo(T elem){
        No corrente=base.seguinte;
        while(corrente!=base && !corrente.elemento.equals(elem)){
            corrente=corrente.seguinte;
        }
        return corrente;
    }

    protected No getNoPorReferencia(T elem){
        No corrente=base.seguinte;
        while(corrente!=base && corrente.elemento!=elem){
            corrente=corrente.seguinte;
        }
        return corrente;
    }

    protected No getNoPorIndice(int indice){
        if(indice<0 || indice>=numeroElementos){
            throw new IndexOutOfBoundsException("Index out of Bounds");
        }
        No cor=base;
        if(indice < numeroElementos/2){
            cor=base.seguinte;
            while(indice-- > 0){
                cor=cor.seguinte;
            }
        }else{
            cor=base.anterior;
            while(++indice > numeroElementos){
                cor=cor.anterior;
            }
        }
        return cor;
    }



    @Override
    public void inserirNoFim(T elem) {
        new No(elem,base);
        numeroElementos++;
    }

    @Override
    public void inserirNoInicio(T elem) {
        new No(elem,base.seguinte);
        numeroElementos++;
    }

    @Override
    public void inserirPorIndice(int indice, T elem) {
        if(indice==numeroElementos){
            inserirNoFim(elem);
        }
        else{
            new No(elem,getNoPorIndice(indice));
            numeroElementos++;
        }
    }

    private T removerNo(No remover){
        remover.anterior.seguinte = remover.seguinte;
        remover.seguinte.anterior = remover.anterior;
        numeroElementos--;
        return remover.elemento;
    }

    @Override
    public T remover(T elem) {
        No no = getNo(elem);
        return no == base ? null : removerNo(no);
    }
    @Override
    public T removerPorReferencia(T elem) {
        No no = getNoPorReferencia(elem);
        return no == base ? null : removerNo(no);
    }
    @Override
    public T removerPorIndice(int indice) {
        No no = getNoPorIndice(indice);
        return no == base ? null : removerNo(no);
    }
    @Override
    public T removerDoInicio() {
        return removerNo(base.seguinte);
    }
    @Override
    public T removerDoFim() {
        return removerNo(base.anterior);
    }


    @Override
    public boolean contem(T elem) {
        return getNo(elem) != base;
    }

    @Override
    public boolean contemReferencia(T elem) {
        return getNoPorReferencia(elem) != base;
    }

    @Override
    public T consultarPorIndice(int indice){
        return getNoPorIndice(indice).elemento;
    }

    @Override
    public int getNumeroElementos(){
        return numeroElementos;
    }

    public IteradorIteravelDuplo<T> iterador() {return new Iterador();}


    public class Iterador implements IteradorIteravelDuplo<T> {
        protected No corrente;

        protected Iterador() {
            reiniciar();
        }

        @Override
        public void reiniciar() {
            corrente = base;
        }

        @Override
        public T corrente() {
            if (corrente == base) {
                throw new NoSuchElementException();
            }
            return corrente.elemento;
        }

        @Override
        public boolean podeAvancar() {
            return corrente.seguinte != base;
        }

        @Override
        public T avancar() {
            if(!podeAvancar()){
                throw new NoSuchElementException();
            }
            corrente = corrente.seguinte;
            return corrente.elemento;
        }

        @Override
        public boolean podeRecuar() {
            return corrente != base.seguinte;
        }

        @Override
        public T recuar() {
            if(!podeRecuar()){
                throw new NoSuchElementException();
            }
            corrente = corrente.anterior;
            return corrente.elemento;
        }
    }

        public class No implements Serializable {
        //seriously what is the purpose of this shit??
        private static final long serialVersionUID = 1L;

        protected T elemento;
        protected No seguinte;
        protected No anterior;

        // Criação do nó base
        public No() {
            elemento = null;
            seguinte = anterior = this;
        }

        public No(T elem, No seg) {
            //criar as conecções deste nó
            this.elemento=elem;
            this.anterior=seg.anterior;
            this.seguinte=seg;
            //destruir as conecções dos outros nós
            this.anterior.seguinte=this;
            seg.anterior=this;

        }
    }

}
