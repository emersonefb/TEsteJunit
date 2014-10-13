package br.com.efb.controller.bean.Endereco;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.endereco.Endereco;
import br.com.efb.model.service.Endereco.EnderecoService;

@SuppressWarnings("restriction")
@Controller
@ViewScoped
public class EnderecoBean {

	@Inject
	EnderecoService enderecoService;

	Endereco endereco = new Endereco();

	@PostConstruct
	public void init() {

	}

	/**
	 * Auto Complemento busca o CEP atraver do inicio digitado
	 * 
	 * @param cep
	 * @return
	 */
	public List<String> completeText(String cep) {
		List<String> results = new ArrayList<String>();
		endereco.setCep(cep);
		List<Endereco> list = enderecoService.buscarPorComecoCEP(endereco);
		if (list.equals(null)) {
		} else {
			for (Endereco endereco : list) {
				results.add(endereco.getCep());
			}
		}
		return results;
	}

	/**
	 * execulta os metodos para salvar
	 */
	public void salvar() {
		salvarEndereco();
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado "
						+ "Ai Sim", null));
	}

	/**
	 * Salva um endereco
	 */
	private void salvarEndereco() {
		try {
			enderecoService.salvar(endereco);
			MensagemCadastrado("Rua");
			limparCampos();
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Limpa os Objetos
	 */
	private void limparCampos() {
//		endereco = null;
	}


	/**
	 * envia para a tela a mensagem cadastrado
	 * 
	 * @param Mensagem
	 */
	private void MensagemCadastrado(String Mensagem) {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado "
						+ Mensagem, null));
	}

	/**
	 * Busca endereco pelo nome da Rua
	 */
	public void buscarEndereco() {
		endereco = enderecoService.buscarPorRua(endereco);
	}

	
	/**
	 * get e set
	 * 
	 * @return
	 */

	
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

}
