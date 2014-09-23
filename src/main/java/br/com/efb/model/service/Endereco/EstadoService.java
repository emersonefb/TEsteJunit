package br.com.efb.model.service.Endereco;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.Dao.endereco.EstadoDao;
import br.com.efb.entity.endereco.Estado;

@Service
public class EstadoService {

	@Inject
	EstadoDao estadoDao;
	
	public void salvar(Estado estado) throws DAOException {
		estadoDao.salvar(estado);
	}
	
	public Estado buscarPorNome(Estado estado) {
		return estadoDao.buscarPorNome(estado);
	}
}
