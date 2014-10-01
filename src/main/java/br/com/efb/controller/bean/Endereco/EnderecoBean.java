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
import br.com.efb.entity.endereco.Bairro;
import br.com.efb.entity.endereco.Cidade;
import br.com.efb.entity.endereco.Endereco;
import br.com.efb.entity.endereco.Estado;
import br.com.efb.entity.endereco.Pais;
import br.com.efb.entity.endereco.Ruas;
import br.com.efb.model.service.Endereco.BairroService;
import br.com.efb.model.service.Endereco.CidadeService;
import br.com.efb.model.service.Endereco.EnderecoService;
import br.com.efb.model.service.Endereco.EstadoService;
import br.com.efb.model.service.Endereco.PaisService;
import br.com.efb.model.service.Endereco.RuasService;

@SuppressWarnings("restriction")
@Controller
@ViewScoped
public class EnderecoBean {

	@Inject
	EnderecoService enderecoService;

	@Inject
	PaisService paisService;

	@Inject
	EstadoService estadoService;

	@Inject
	CidadeService cidadeService;

	@Inject
	BairroService bairroService;

	@Inject
	RuasService ruasService;

	Endereco endereco = new Endereco();

	Pais pais = new Pais();

	Estado estado = new Estado();

	Cidade cidade = new Cidade();

	Bairro bairro = new Bairro();

	Ruas ruas = new Ruas();

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
		ruas.setCep(cep);
		List<Ruas> list = ruasService.buscarPorComecoCEP(ruas);
		if (list.equals(null)) {
		} else {
			for (Ruas ruas : list) {
				results.add(ruas.getCep());
			}
		}
		return results;
	}

	/**
	 * execulta os metodos para salvar
	 */
	public void salvar() {
		salvarPais();
		System.out.println("Pais: " + pais.getId() + " : " + pais.getNome());
		salvarEstado();
		System.out.println("Estado: " + estado.getId() + " : "
				+ estado.getNome());
		salvarCidade();
		System.out.println("Cidade: " + cidade.getId() + " : "
				+ cidade.getNome());
		salvarBairro();
		System.out.println("Bairro: " + bairro.getId() + " : "
				+ bairro.getNome());
		salvarRuas();
		System.out.println("CEP: " + ruas.getCep() + " Rua: " + ruas.getNome());
		// salvarEndereco();
		MensagemCadastrado("Ai Sim");
	}

	/**
	 * Salva um endereco
	 */
	private void salvarEndereco() {
		endereco.setNumero(456);
		try {
			ruas = ruasService.buscarPorCEP(ruas);
		} catch (DAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		endereco.setRuas(ruas);
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
		pais = null;
		estado = null;
		cidade = null;
		bairro = null;
		ruas = null;
	}

	/**
	 * Salva Ruas
	 * 
	 * @throws DAOException
	 */
	private void salvarRuas() {
		bairro = bairroService.buscarPorNome(bairro);
		ruas.setBairro(bairro);
		try {
			ruas = ruasService.salvar(ruas);
			MensagemCadastrado("Rua");
		} catch (DAOException e) {
			try {
				ruas = ruasService.buscarPorCEP(ruas);
				MensagemCadastrado("Rua");
			} catch (DAOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Salva Bairro
	 */
	private Bairro salvarBairro() {
		cidade = cidadeService.buscarPorNome(cidade);
		bairro.setCidade(cidade);
		try {
			bairro = bairroService.salvar(bairro);
			MensagemCadastrado("Bairro");
		} catch (DAOException e) {
			bairro = bairroService.buscarPorNome(bairro);
			MensagemCadastrado("Bairro");
			// e.printStackTrace();
		}
		return bairro;
	}

	/**
	 * Salva Cidade
	 * @return 
	 */
	private Cidade salvarCidade() {
		estado = estadoService.buscarPorNome(estado);
		cidade.setEstado(estado);
		try {
			cidade = cidadeService.salvar(cidade);
			MensagemCadastrado("Cidade");
		} catch (DAOException e) {
			cidade = cidadeService.buscarPorNome(cidade);
			MensagemCadastrado("Cidade");
			// e.printStackTrace();
		}
		return cidade;
	}

	/**
	 * Salva Estado
	 * 
	 * @return
	 */
	private Estado salvarEstado() {
		pais = paisService.buscarPorNome(pais);
		estado.setPais(pais);
		try {
			estado = estadoService.salvar(estado);
			MensagemCadastrado("Estado");
		} catch (DAOException e) {
			estado = estadoService.buscarPorNome(estado);
			MensagemCadastrado("Estado");
		}
		return estado;
	}

	/**
	 * Salva Pais
	 * 
	 * @return
	 */
	private Pais salvarPais() {
		try {
			pais = paisService.salvar(pais);
			MensagemCadastrado("Pais");

		} catch (DAOException e) {
			pais = paisService.buscarPorNome(pais);
			MensagemCadastrado("Pais");
		}
		return pais;
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
		endereco.setRuas(ruas);
		endereco = enderecoService.buscarPorRua(endereco);
	}

	/**
	 * Busca Uma Rua Pelo CEP
	 */
	public void buscarCep() {
		try {
			ruas.setId(0);
			ruas = ruasService.buscarPorCEP(ruas);
		} catch (DAOException e1) {
			e1.printStackTrace();
		} finally {
			if (ruas.getId() == 0) {
				MensagemCadastrado("CEP Nao Encontrado");
				return;
			} else {
				buscarEndereco();
			}
		}
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

	public PaisService getPaisService() {
		return paisService;
	}

	public void setPaisService(PaisService paisService) {
		this.paisService = paisService;
	}

	public EstadoService getEstadoService() {
		return estadoService;
	}

	public void setEstadoService(EstadoService estadoService) {
		this.estadoService = estadoService;
	}

	public CidadeService getCidadeService() {
		return cidadeService;
	}

	public void setCidadeService(CidadeService cidadeService) {
		this.cidadeService = cidadeService;
	}

	public BairroService getBairroService() {
		return bairroService;
	}

	public void setBairroService(BairroService bairroService) {
		this.bairroService = bairroService;
	}

	public RuasService getRuasService() {
		return ruasService;
	}

	public void setRuasService(RuasService ruasService) {
		this.ruasService = ruasService;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public Ruas getRuas() {
		return ruas;
	}

	public void setRuas(Ruas ruas) {
		this.ruas = ruas;
	}

}
