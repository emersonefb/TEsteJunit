package br.com.efb.entity.Pessoa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.com.efb.entity.PJ.Documentos.DocumentosPJ;

@Entity
public class PessoaJuridica extends Pessoa {

	private Date dataDeCostituicao; 
	
	private String nomeFantasia;
	
	@OneToOne()
	private  DocumentosPJ documentosPJ;

	public Date getDataDeCostituicao() {
		return dataDeCostituicao;
	}

	public void setDataDeCostituicao(Date dataDeCostituicao) {
		this.dataDeCostituicao = dataDeCostituicao;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public DocumentosPJ getDocumentosPJ() {
		return documentosPJ;
	}

	public void setDocumentosPJ(DocumentosPJ documentosPJ) {
		this.documentosPJ = documentosPJ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((documentosPJ == null) ? 0 : documentosPJ.hashCode());
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
		PessoaJuridica other = (PessoaJuridica) obj;
		if (documentosPJ == null) {
			if (other.documentosPJ != null)
				return false;
		} else if (!documentosPJ.equals(other.documentosPJ))
			return false;
		return true;
	}

}
