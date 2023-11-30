package aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

import aed.colecoes.iteraveis.IteradorIteravel;
import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;

import java.io.Serial;
import java.io.Serializable;
import java.util.NoSuchElementException;

public class ListaDuplaNaoOrdenada2<T> implements ColecaoIteravelLinearNaoOrdenada<T> {
    @Serial
    private static final long serialVersionUID = 1L;
    protected No base;
    protected int numeroElementos;

    public ListaDuplaNaoOrdenada2(){
        numeroElementos = 0;
        base = new No();
    }
    @Override
    public void inserirNoInicio(T elem) {
        new No(elem,base.seguinte);
        numeroElementos++;
    }
    @Override
    public void inserirNoFim(T elem) {
        new No(elem,base);
        numeroElementos++;
    }
    @Override
    public void inserirPorIndice(int indice, T elem) {
        if(indice == numeroElementos){
            inserirNoFim(elem);
            return;
        }
        new No(elem,getNoPorIndice(indice));
        numeroElementos++;
    }
    protected No getNo(T elem){
        No current = base.seguinte;

        while(current != base && !current.elemento.equals(elem))
            current = current.seguinte;

        return current;
    }
    protected No getNoPorReferencia(T elem){
        No current = base.seguinte;

        while(current != base && current.elemento != elem)
            current = current.seguinte;

        return current;
    }
    protected No getNoPorIndice(int indice){
        if(indice < 0 || indice >= numeroElementos)
            throw new IndexOutOfBoundsException();

        No current;
        if(indice >= numeroElementos/2){
            current = base.seguinte;
            while(indice-- > 0)
                current = current.anterior;
        }
        else{
            current = base.anterior;
            while(++indice < numeroElementos)
                current = current.seguinte;
        }

        return current;
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
    public IteradorIteravelDuplo<T> iterador() {
        return new Iterador();
    }

    @Override
    public int getNumeroElementos() {
        return numeroElementos;
    }

    @Override
    public T consultarPorIndice(int indice) {
        return getNoPorIndice(indice).elemento;
    }

    @Override
    public boolean contem(T elem) {
        return getNo(elem) != base;
    }

    @Override
    public boolean contemReferencia(T elem) {
        return getNoPorReferencia(elem) != base;
    }

    public class No implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        protected T elemento;
        protected No seguinte;
        protected No anterior;

        protected No(){
            elemento = null;
            seguinte = anterior = this;
        }

        protected No(T elem, No seg){
            elemento = elem;
            anterior = seg.anterior;
            seguinte = seg;
            anterior.seguinte = seguinte.anterior = this;
        }
    }

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
            if (!podeAvancar()) {
                throw new NoSuchElementException();
            }

            corrente = corrente.seguinte;
            return corrente.elemento;
        }

        @Override
        public boolean podeRecuar() {
            return corrente.anterior != base;
        }

        @Override
        public T recuar() {
            if (!podeRecuar()) {
                throw new NoSuchElementException();
            }

            corrente = corrente.anterior;
            return corrente.elemento;
        }
    }
}
