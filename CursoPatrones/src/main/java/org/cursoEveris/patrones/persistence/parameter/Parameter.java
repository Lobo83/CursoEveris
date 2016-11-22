/**
 * Clase que encapsula la información para ejecutar querys con argumentos
 */
package org.cursoEveris.patrones.persistence.parameter;
/**
 * 
 * @author xe52220
 *
 */
public class Parameter {

	/**
	 * Nombre del argumento
	 */
	private String nombre;
	/**
	 * Posición que ocupa el argumento
	 */
	private int posicion;
	/**
	 * Valor del argumento
	 */
	private Object valor;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(final int posicion) {
		this.posicion = posicion;
	}
	public Object getValor() {
		return valor;
	}
	public void setValor(final Object valor) {
		this.valor = valor;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + posicion;
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parameter other = (Parameter) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (posicion != other.posicion)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Parameter [nombre=" + nombre + ", posicion=" + posicion
				+ ", valor=" + valor + "]";
	}
	
}
