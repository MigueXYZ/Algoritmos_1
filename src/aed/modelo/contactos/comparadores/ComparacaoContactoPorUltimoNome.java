package aed.modelo.contactos.comparadores;

import aed.Comparacao;
import aed.modelo.contactos.Contacto;

public enum ComparacaoContactoPorUltimoNome implements Comparacao<Contacto> {
    INSTANCIA;

    @Override
    public int comparar(Contacto o1, Contacto o2) {
        int aux= o1.getUltimo_nome().compareTo(o2.getUltimo_nome());
        if(aux==0){
            int ano = Integer.compare(o1.getData_nascimento().getAno(),o2.getData_nascimento().getAno());
            if(ano!=0){
                return ano;
            }
            
            int mes = Integer.compare(o1.getData_nascimento().getMes(),o2.getData_nascimento().getMes());
            if(mes!=0){
                return mes;
            }
            int dia = Integer.compare(o1.getData_nascimento().getDia(),o2.getData_nascimento().getDia());
        }
        return aux;
    }
}
