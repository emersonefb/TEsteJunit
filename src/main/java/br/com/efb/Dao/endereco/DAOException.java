package br.com.efb.Dao.endereco;

public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5723208539029655885L;

	public DAOException(String string, Exception causa) {
		System.out.println("erro DAOException "+ string + " " + causa);
	}

}
