package org.cursoEveris.patrones.business.vo;

import org.cursoEveris.patrones.business.mapper.annotation.MappingId;



public class DireccionVO {

	@MappingId(id="id")
	private Long id;
	
	@MappingId(id="calle")
	private String calle;
	
	@MappingId(id="bloque")
	private String bloque;
	
	@MappingId(id="puerta")
	private String puerta;

	@MappingId(id="idCliente")
	private Long idCliente;
	
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getBloque() {
		return bloque;
	}

	public void setBloque(String bloque) {
		this.bloque = bloque;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	@Override
	public String toString() {
		return "DireccionVO [id=" + id + ", calle=" + calle + ", bloque=" + bloque + ", puerta=" + puerta
				+ ", idCliente=" + idCliente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bloque == null) ? 0 : bloque.hashCode());
		result = prime * result + ((calle == null) ? 0 : calle.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((puerta == null) ? 0 : puerta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DireccionVO other = (DireccionVO) obj;
		if (bloque == null) {
			if (other.bloque != null)
				return false;
		} else if (!bloque.equals(other.bloque))
			return false;
		if (calle == null) {
			if (other.calle != null)
				return false;
		} else if (!calle.equals(other.calle))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		if (puerta == null) {
			if (other.puerta != null)
				return false;
		} else if (!puerta.equals(other.puerta))
			return false;
		return true;
	}
	
	
}
