package br.com.efb.model.service.Endereco;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.Dao.endereco.EnderecoDao;
import br.com.efb.entity.endereco.Endereco;

@Service
public class EnderecoService {
	
	@Inject
	EnderecoDao enderecoDao;
	
	public void salvar(Endereco endereco) throws DAOException {
		enderecoDao.salvar(endereco);
	}

	public Endereco buscarPorID(Endereco endereco) throws DAOException {
		return enderecoDao.buscarPorId(endereco);
		
	}

	public Endereco buscarPorRua(Endereco endereco) {
		return enderecoDao.buscarPorRua(endereco);
	}

}
