package aed.modelo.contactos;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenadaOrdemDistinta;
import aed.modelo.contactos.comparadores.ComparacaoGestoresContactosDataNascimentoPorDataAsc;

import java.util.NoSuchElementException;

public enum GestorContactos {
    INSTANCIA;

    private static final IteradorIteravelDuplo<Contacto> ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS = new ListaDuplaNaoOrdenada<Contacto>().iterador();

    private ListaDuplaOrdenadaOrdemDistinta<GestorContactosDataNascimento> listaGestores;
    GestorContactos(){
        listaGestores=new ListaDuplaOrdenadaOrdemDistinta<>(ComparacaoGestoresContactosDataNascimentoPorDataAsc.CRITERIO);
    }
    public void inserir(Contacto contacto){

        GestorContactosDataNascimento gestor;
        gestor = listaGestores.consultarDistinto(new GestorContactosDataNascimento(contacto.getDataNascimento()));
       if(gestor==null) {
           gestor = new GestorContactosDataNascimento(contacto.getDataNascimento());
           listaGestores.inserir(gestor);
       }
        gestor.inserir(contacto);
    }
    public Contacto remover(Contacto contacto){
        GestorContactosDataNascimento gestor;
        gestor = listaGestores.consultarDistinto(new GestorContactosDataNascimento(contacto.getDataNascimento()));
        if(gestor==null) {
            return null;
        }
        Contacto contactoRemovido = gestor.remover(contacto);
        if(gestor.isVazio()){
            listaGestores.remover(gestor);
        }
        return contactoRemovido;
    }
    public IteradorIteravelDuplo<Contacto> remover(Data data){
        GestorContactosDataNascimento gestor = new GestorContactosDataNascimento(data);
        gestor=listaGestores.remover(gestor);
        return gestor == null ?  ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS : gestor.iterador();
    }
    public IteradorIteravelDuplo<Contacto> consultar(Data data){
        GestorContactosDataNascimento gestor;
        gestor = listaGestores.consultarDistinto(new GestorContactosDataNascimento(data));
        return gestor == null ?  ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS : gestor.iterador();
    }
    public IteradorIteravelDuplo<Contacto> consultar(Data dataInicio,Data dataFim){
        return new Iterador(dataInicio,dataFim);
    }
    private class Iterador implements IteradorIteravelDuplo<Contacto>{
        private IteradorIteravelDuplo<GestorContactosDataNascimento> iteradorGestores;
        private IteradorIteravelDuplo<Contacto> iteradorContactos;
        public Iterador(Data dataInicio, Data dataFim){
            iteradorGestores=listaGestores.consultar(new GestorContactosDataNascimento(dataInicio),new GestorContactosDataNascimento(dataFim));

            reiniciar();
        }
        @Override
        public void reiniciar() {
            iteradorGestores.reiniciar();
            iteradorContactos=ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS;
        }
        @Override
        public Contacto corrente() {
            return iteradorContactos.corrente();
        }
        @Override
        public boolean podeAvancar() {
            if(iteradorGestores.podeAvancar() ||  iteradorContactos.podeAvancar()){
                return true;
            }
            return false;
        }
        @Override
        public Contacto avancar() {
            if(!iteradorContactos.podeAvancar()){
                iteradorContactos=iteradorGestores.avancar().iterador();
            }
            iteradorContactos.avancar();
        return null;
        }
        @Override
        public boolean podeRecuar() {
            if(iteradorGestores.podeRecuar() ||  iteradorContactos.podeRecuar()){
                return true;
            }
            return false;
        }
        @Override
        public Contacto recuar() {
            if(!iteradorContactos.podeRecuar()){
                iteradorContactos=iteradorGestores.recuar().iterador();
            }
            iteradorContactos.recuar();
        return null;
        }
    }
}
