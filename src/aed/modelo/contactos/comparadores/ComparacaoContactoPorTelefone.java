package aed.modelo.contactos.comparadores;

import aed.Comparacao;
import aed.modelo.contactos.Contacto;

public enum ComparacaoContactoPorTelefone implements Comparacao<Contacto> {
    INSTANCIA;
    @Override
    public int comparar(Contacto t1, Contacto t2) {
        return -Long.compare(t1.getNumeroTelefone(), t2.getNumeroTelefone());
    }
}
