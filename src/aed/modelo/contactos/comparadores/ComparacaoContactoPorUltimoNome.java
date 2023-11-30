package aed.modelo.contactos.comparadores;

import aed.Comparacao;
import aed.modelo.contactos.Contacto;

public enum ComparacaoContactoPorUltimoNome implements Comparacao<Contacto> {
    INSTANCIA;

    @Override
    public int comparar(Contacto o1, Contacto o2) {
        int aux= o1.getUltimoNome().compareTo(o2.getUltimoNome());
        if(aux==0){
            int ano = Integer.compare(o1.getDataNascimento().getAno(),o2.getDataNascimento().getAno());
            if(ano!=0){
                return ano;
            }
            
            int mes = Integer.compare(o1.getDataNascimento().getMes(),o2.getDataNascimento().getMes());
            if(mes!=0){
                return mes;
            }
            int dia = Integer.compare(o1.getDataNascimento().getDia(),o2.getDataNascimento().getDia());
        }
        return aux;
    }
}
