package br.com.efb.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LerPlanilha {

	public String[][] LerPanilha() throws BiffException, IOException {
		File planilha = CarregaPlanilha();

		Workbook workbook = Workbook.getWorkbook(planilha);
		/**
		 * Aqui é feito o controle de qual aba do xls será realiza a leitura dos
		 * dados
		 */
		Sheet sheet = (Sheet) workbook.getSheet(0);

		int linhas = NumerodeLinhas(sheet);

		int colunas = NumerodeColunas(sheet);

		String[][] a = new String[colunas][linhas];

		LerLinhas(sheet, a, linhas);

		return a;
	}

	private void LerLinhas(Sheet sheet, String[][] a, int linha) {
		/**
		 * lendo as linhas das celulas
		 */
		for (int l = 0; l < linha; l++) {
			for (int i = 0; i < a.length; i++) {
				Cell ao = (Cell) ((jxl.Sheet) sheet).getCell(i, l);
				a[i][l] = ((jxl.Cell) ao).getContents();
			}
		}
	}

	private int NumerodeColunas(Sheet sheet) {
		/**
		 * Numero de Colunas com dados do xls
		 */
		int colunas = ((jxl.Sheet) sheet).getColumns();
		// System.out.println("Colunas " + ((jxl.Sheet) sheet).getColumns());
		return colunas;
	}

	private int NumerodeLinhas(Sheet sheet) {
		/**
		 * Numero de linhas com dados do xls
		 */
		int linhas = ((jxl.Sheet) sheet).getRows();
		// System.out.println("Linhas " + ((jxl.Sheet) sheet).getRows());
		return linhas;
	}

	private File CarregaPlanilha() {
		/**
		 * Carrega a planilha
		 */

		File planilha = new File("C:/pasta/asd/plan.xls");
		try {
			if (!planilha.exists()) {
				throw new FileNotFoundException("Arquivo não encontrado!");

			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return planilha;
	}
}