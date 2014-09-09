package br.com.efb.entity.Pessoa.Contato;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Contato {

	@Id
	@GeneratedValue
	private int id;
	
	private String obs;

	@OneToMany(mappedBy = "contato")
	private List<Telefone> telefone;

	@OneToMany(mappedBy = "contato")
	private List<Celular> celular;

	@OneToMany(mappedBy = "contato")
	private List<EmailContato> emailContatos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	public List<Celular> getCelular() {
		return celular;
	}

	public void setCelular(List<Celular> celular) {
		this.celular = celular;
	}

	public List<EmailContato> getEmailContatos() {
		return emailContatos;
	}

	public void setEmailContatos(List<EmailContato> emailContatos) {
		this.emailContatos = emailContatos;
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
		Contato other = (Contato) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
