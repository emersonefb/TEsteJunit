package br.com.efb.entity.Pessoa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.efb.entity.Pessoa.Contato.Contato;
import br.com.efb.entity.endereco.Endereco;

@Entity
public class Pessoa {

	@Id
	@GeneratedValue
	private int id;
	
	private String tipodePessoa;
	
	private String nome;
	
	private String nomeCompleto;
	
	@ManyToOne
	private Endereco enderecos;

	@ManyToOne
	private Contato contatos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipodePessoa() {
		return tipodePessoa;
	}

	public void setTipodePessoa(String tipodePessoa) {
		this.tipodePessoa = tipodePessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}


	public Endereco getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco enderecos) {
		this.enderecos = enderecos;
	}

	public Contato getContatos() {
		return contatos;
	}

	public void setContatos(Contato contatos) {
		this.contatos = contatos;
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
		Pessoa other = (Pessoa) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
