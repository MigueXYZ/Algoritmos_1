package aed.modelo.contactos;

import aed.colecoes.iteraveis.IteradorIteravelDuplo;
import aed.colecoes.iteraveis.associativas.estruturas.TabelaHashOrdenada;
import aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenadaOrdemDistinta;
import aed.modelo.contactos.comparadores.ComparacaoContactoPorDataNascimento;
import aed.modelo.contactos.comparadores.ComparacaoDataAsc;
import aed.modelo.contactos.comparadores.ComparacaoGestoresContactosDataNascimentoPorDataAsc;

import java.util.NoSuchElementException;

public enum GestorContactos {
    INSTANCIA;

    private TabelaHashOrdenada<Data,GestorContactosDataNascimento> contactosPorDataNascimento;
    private static final IteradorIteravelDuplo<Contacto> ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS = new ListaDuplaNaoOrdenada<Contacto>().iterador();

    GestorContactos(){
        contactosPorDataNascimento = new TabelaHashOrdenada<Data,GestorContactosDataNascimento>(ComparacaoDataAsc.INSTANCIA,100 );
    }
    public void inserir(Contacto contacto){
        Data dataNascimento=contacto.getDataNascimento();
        GestorContactosDataNascimento gcdn = contactosPorDataNascimento.consultar(dataNascimento);
       if(gcdn==null) {
           gcdn=new GestorContactosDataNascimento(dataNascimento);
           contactosPorDataNascimento.inserir(dataNascimento,gcdn);
       }
        gcdn.inserir(contacto);
    }
    public Contacto remover(Contacto contacto){
        GestorContactosDataNascimento gestor;
        Data dataNascimento = contacto.getDataNascimento();
        gestor = contactosPorDataNascimento.consultar(dataNascimento);
        if(gestor==null) {
            return null;
        }
        Contacto contactoRemovido = gestor.remover(contacto);
        if(gestor.isVazio()){
            contactosPorDataNascimento.remover(dataNascimento);
        }
        return contactoRemovido;
    }
    public IteradorIteravelDuplo<Contacto> remover(Data data){
        GestorContactosDataNascimento gestor = new GestorContactosDataNascimento(data);
        gestor=contactosPorDataNascimento.remover(data);
        return gestor == null ?  ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS : gestor.iterador();
    }
    public IteradorIteravelDuplo<Contacto> consultar(Data data){
        GestorContactosDataNascimento gestor;
        gestor = contactosPorDataNascimento.consultar(data);
        return gestor == null ?  ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS : gestor.iterador();
    }
    public IteradorIteravelDuplo<Contacto> consultar(Data dataInicio,Data dataFim){
        return new Iterador(dataInicio,dataFim);
    }
    private class Iterador implements IteradorIteravelDuplo<Contacto>{
        private final IteradorIteravelDuplo<GestorContactosDataNascimento> iteradorGestores;
        private IteradorIteravelDuplo<Contacto> iteradorContactos;
        public Iterador(Data dataInicio, Data dataFim){
            iteradorGestores=contactosPorDataNascimento.consultarValores(dataInicio,dataFim);
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
            return iteradorGestores.podeAvancar() || iteradorContactos.podeAvancar();
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
            return iteradorGestores.podeRecuar() || iteradorContactos.podeRecuar();
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
