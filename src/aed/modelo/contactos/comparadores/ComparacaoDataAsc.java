package aed.modelo.contactos.comparadores;

import aed.Comparacao;
import aed.modelo.contactos.Data;

public enum ComparacaoDataAsc implements Comparacao<Data> {
    INSTANCIA;

    @Override
    public int comparar(Data o1, Data o2) {
        return o1.compareTo(o2);
    }
}
