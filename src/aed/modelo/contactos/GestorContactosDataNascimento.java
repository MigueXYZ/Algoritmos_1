package aed.modelo.contactos;

import aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaOrdenada;
import java.io.Serializable;
import java.util.Objects;

public class GestorContactosDataNascimento implements Serializable {
	private static final long serialVersionUID = 1L;

	private Data dataNascimento;
	private ListaDuplaOrdenada<Contacto> contactos;

	public GestorContactosDataNascimento(Data dataNascimento,ListaDuplaOrdenada<Contacto> contactos) {
		this.dataNascimento = dataNascimento;
		this.contactos = contactos;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GestorContactosDataNascimento obj = (GestorContactosDataNascimento) o;
		return Objects.equals(dataNascimento, obj.dataNascimento) && Objects.equals(contactos, obj.contactos);
	}

	@Override
	public int hashCode () {
		return Objects.hash(dataNascimento, contactos);
	}

	@Override
	public String toString() {
		return " (" + dataNascimento + ", " + contactos + ")";
	}
}