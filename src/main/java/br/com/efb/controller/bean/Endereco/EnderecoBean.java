package br.com.efb.controller.bean.Endereco;

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

	public void salvar() {
		salvarPais();
		salvarEstado();
		salvarCidade();
		salvarBairro();
		salvarRuas();
		salvarEndereco();
	}

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

			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									"Salvo", null));
			
			pais = null;

			estado = null;

			cidade = null;

			bairro = null;

			ruas = null;
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void salvarRuas() {
		bairro = bairroService.buscarPorNome(bairro);
		ruas.setBairro(bairro);
		try {
			ruasService.salvar(ruas);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void salvarBairro() {
		cidade = cidadeService.buscarPorNome(cidade);
		bairro.setCidade(cidade);
		try {
			bairroService.salvar(bairro);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void salvarCidade() {
		estado = estadoService.buscarPorNome(estado);
		cidade.setEstado(estado);
		try {
			cidadeService.salvar(cidade);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void salvarEstado() {
		pais = paisService.buscarPorNome(pais);
		estado.setPais(pais);
		try {
			estadoService.salvar(estado);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void salvarPais() {
		try {
			paisService.salvar(pais);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void buscar() {
		System.out.println("RUA:    "+ruas.getId());
		endereco.setRuas(ruas); 
		endereco = enderecoService.buscarPorRua(endereco);
		System.out.println("Nome Rua asdf:  "+endereco.getId());
		try {
			endereco = enderecoService.buscarPorID(endereco);
			System.out.println("esse" + endereco.getId());

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

	public void buscarCep() {
		// ruas.setId(1);
		// ruas.setCep("09391000");
		try {
			ruas = ruasService.buscarPorCEP(ruas);
			buscar();

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
