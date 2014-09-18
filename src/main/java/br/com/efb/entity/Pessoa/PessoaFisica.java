package br.com.efb.entity.Pessoa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.com.efb.entity.PF.Documentos.DocumentosPF;

@Entity
public class PessoaFisica extends Pessoa {

	private String sexo;
	
	private Date dataDeNascimento; 
	
	@OneToOne()
	private  DocumentosPF documentosPF;

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public DocumentosPF getDocumentosPF() {
		return documentosPF;
	}

	public void setDocumentosPF(DocumentosPF documentosPF) {
		this.documentosPF = documentosPF;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((documentosPF == null) ? 0 : documentosPF.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaFisica other = (PessoaFisica) obj;
		if (documentosPF == null) {
			if (other.documentosPF != null)
				return false;
		} else if (!documentosPF.equals(other.documentosPF))
			return false;
		return true;
	}
	
}
