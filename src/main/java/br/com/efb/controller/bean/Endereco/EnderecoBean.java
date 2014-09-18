package br.com.efb.controller.bean.Endereco;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.endereco.Endereco;
import br.com.efb.entity.endereco.Ruas;
import br.com.efb.model.service.Endereco.EnderecoService;

@Controller
@ViewScoped
public class EnderecoBean {

	@Inject
	EnderecoService enderecoService;

	Endereco endereco = new Endereco();
	
	Ruas ruas = new Ruas();

	@PostConstruct
	public void init() {
		
		

	}

	public void salvar() {
		endereco.setRuas(ruas);
		try {
			enderecoService.salvar(endereco);

			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									"Salvo", null));
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public EnderecoService getEnderecoService() {
		return enderecoService;
	}

	public void setEnderecoService(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Ruas getRuas() {
		return ruas;
	}

	public void setRuas(Ruas ruas) {
		this.ruas = ruas;
	}
}
