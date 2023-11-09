package aed.modelo.contactos.comparadores;

import aed.Comparacao;
import aed.modelo.contactos.Contacto;

public enum ComparacaoContactoPorDataNascimento implements Comparacao<Contacto> {
    INSTANCIA;

    @Override
    public int comparar(Contacto o1, Contacto o2) {
        if(o1.getData_nascimento().getAno()>o2.getData_nascimento().getAno()){
            return 0;
        }
        else{
            return 1;
        }
    }
}
