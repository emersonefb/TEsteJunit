package br.com.efb.entity.Pessoa.Contato;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Telefone {

	@Id
	@GeneratedValue
	private int id;
	
	private int prefixoDDI;
	
	private int prefixoDDD;
	
	private String numero;
	
	private String Observacao;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrefixoDDI() {
		return prefixoDDI;
	}

	public void setPrefixoDDI(int prefixoDDI) {
		this.prefixoDDI = prefixoDDI;
	}

	public int getPrefixoDDD() {
		return prefixoDDD;
	}

	public void setPrefixoDDD(int prefixoDDD) {
		this.prefixoDDD = prefixoDDD;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getObservacao() {
		return Observacao;
	}

	public void setObservacao(String observacao) {
		Observacao = observacao;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Telefone other = (Telefone) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
