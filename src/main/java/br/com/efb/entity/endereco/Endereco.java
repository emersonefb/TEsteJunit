package br.com.efb.entity.endereco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Endereco {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private Ruas ruas;
	
	private int numero;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Ruas getRuas() {
		return ruas;
	}

	public void setRuas(Ruas ruas) {
		this.ruas = ruas;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + numero;
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
		Endereco other = (Endereco) obj;
		if (id != other.id)
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}


	
	
}
