package br.com.efb.entity.endereco;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Bairro {

	@Id
	@GeneratedValue
	private int id;
	
	private String nome;
	
	@OneToMany(mappedBy = "bairro")
	private List<Ruas> ruas;
	
	@ManyToOne
	private Cidade cidade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ruas> getRuas() {
		return ruas;
	}

	public void setRuas(List<Ruas> ruas) {
		this.ruas = ruas;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
		Bairro other = (Bairro) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	


}
