package br.com.efb.model.service.Endereco;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.efb.Dao.endereco.CidadeDao;
import br.com.efb.Dao.endereco.DAOException;
import br.com.efb.entity.endereco.Cidade;

@Service
public class CidadeService {

	@Inject
	CidadeDao cidadeDao;
	
	public Cidade salvar(Cidade cidade) throws DAOException {
		try {
			cidadeDao.salvar(cidade);
		} catch (Exception e) {
			e.printStackTrace();
		}
		cidade = buscarPorNome(cidade);
		return cidade;
	}
	
	public Cidade buscarPorNome(Cidade cidade) {
		return cidade = cidadeDao.buscarPorNome(cidade);
	}
}
