package br.com.efb.model.service.Endereco;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.efb.Dao.endereco.BairroDao;
import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.endereco.Bairro;

@Service
public class BairroService {

	@Inject
	BairroDao bairroDao;
	
	public Bairro  salvar(Bairro bairro) throws DAOException {
		try {
			bairroDao.salvar(bairro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		bairro = buscarPorNome(bairro);
		return bairro;
	}

	public Bairro buscarPorNome(Bairro bairro) {
		return bairroDao.buscarPorNome(bairro);
	}
}
