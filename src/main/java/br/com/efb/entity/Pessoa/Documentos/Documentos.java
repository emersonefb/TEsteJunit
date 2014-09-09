package br.com.efb.entity.Pessoa.Documentos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.efb.entity.Pessoa.Pessoa;

@Entity
public class Documentos {

	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne()
	private RG rg;
	
	@OneToOne()
	private CPF cpf;
	
	@OneToOne()
	private PIS pis;
	
	@OneToOne(mappedBy = "documentos")
	private Pessoa pessoa;

	
}
