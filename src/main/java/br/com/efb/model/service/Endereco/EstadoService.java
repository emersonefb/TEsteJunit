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
	
	public Estado salvar(Estado estado) throws DAOException {
		try {
			estadoDao.salvar(estado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		estado = buscarPorNome(estado);
		return estado;
		
	}
	
	public Estado buscarPorNome(Estado estado) {
		return estadoDao.buscarPorNome(estado);
	}
}
