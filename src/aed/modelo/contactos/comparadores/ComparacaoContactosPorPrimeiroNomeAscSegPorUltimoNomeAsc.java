package aed.modelo.contactos.comparadores;

import aed.Comparacao;
import aed.modelo.contactos.Contacto;

public enum ComparacaoContactosPorPrimeiroNomeAscSegPorUltimoNomeAsc  implements Comparacao<Contacto> {
    CRITERIO;

    @Override
    public int comparar(Contacto c1, Contacto c2) {
        int cp=c1.getPrimeiroNome().compareTo(c2.getPrimeiroNome());
        if(cp!=0){
            return cp;
        }
        return c1.getUltimoNome().compareTo(c2.getUltimoNome());
    }
}
