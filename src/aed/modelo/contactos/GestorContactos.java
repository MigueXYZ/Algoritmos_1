package aed.modelo.contactos;

import java.util.LinkedList;

public enum GestorContactos {
    INSTANCIA;

    private LinkedList<Contacto> Contactos;

    public LinkedList<Contacto> getContactosData(){
        LinkedList<Contacto> tato = new LinkedList<>();
        return tato;
    }
}
