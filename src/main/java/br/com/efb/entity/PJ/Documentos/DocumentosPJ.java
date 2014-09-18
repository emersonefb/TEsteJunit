package br.com.efb.entity.PJ.Documentos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.efb.entity.Pessoa.PessoaJuridica;

@Entity
public class DocumentosPJ implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne()
	private CNPJ cnpj;
	
	@OneToOne()
	private InscricaoEstadual inscricaoEstadual;
	
	@OneToOne()
	private InscricaoMunicipal inscricaoMunicipal;
	
	@OneToOne()
	private NumeroContribuinte numeroContribuinte;
	
	@OneToOne(mappedBy = "documentosPJ")
	private PessoaJuridica pessoaJuridica;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CNPJ getCnpj() {
		return cnpj;
	}

	public void setCnpj(CNPJ cnpj) {
		this.cnpj = cnpj;
	}

	public InscricaoEstadual getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(InscricaoEstadual inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public InscricaoMunicipal getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(InscricaoMunicipal inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public NumeroContribuinte getNumeroContribuinte() {
		return numeroContribuinte;
	}

	public void setNumeroContribuinte(NumeroContribuinte numeroContribuinte) {
		this.numeroContribuinte = numeroContribuinte;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
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
		DocumentosPJ other = (DocumentosPJ) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
