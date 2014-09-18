package br.com.efb.entity.PF.Documentos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.efb.entity.Pessoa.PessoaFisica;

@Entity
public class DocumentosPF implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne()
	private RG rg;
	
	@OneToOne()
	private CPF cpf;
	
	@OneToOne()
	private PIS pis;
	
	@OneToOne(mappedBy = "documentosPF")
	private PessoaFisica pessoaFisica;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RG getRg() {
		return rg;
	}

	public void setRg(RG rg) {
		this.rg = rg;
	}

	public CPF getCpf() {
		return cpf;
	}

	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}

	public PIS getPis() {
		return pis;
	}

	public void setPis(PIS pis) {
		this.pis = pis;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
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
		DocumentosPF other = (DocumentosPF) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
