package br.com.efb.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import jxl.read.biff.BiffException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CriarPlanilha {
	public static void CriarPanilha(String TOTALPIS, String TOTALCOFINS,
			String TOTALCSLL, String TOTALIRPJ, String TOTALPISRetencao,
			String TOTALCOFINSRetencao, String TOTALCSLLRetencao,
			String TOTALIRPJRetencao, String TOTALSOMAPIS,
			String TOTALSOMACOFINS, String TOTALSOMACSLL, String TOTALSOMAIRPJ,
			String nomePlanilhaMedico, String nomePastaMedicoAno,
			String nomePastaMedicoMes) throws BiffException, IOException {

		CriarPasta(nomePastaMedicoAno);

		CriarPasta(nomePastaMedicoAno, nomePastaMedicoMes);

		FileOutputStream out = CriarXLS(nomePlanilhaMedico, nomePastaMedicoAno,
				nomePastaMedicoMes);
		
		// Criando area de trabalho para o excel
		HSSFWorkbook wb = new HSSFWorkbook();

		// criando uma nova sheet
		HSSFSheet s = wb.createSheet();

		// Criando uma referencia para Linha
		HSSFRow r = null;
		// df.getRowCount() // numero de linha na tabela
		// int f= df.getColumnCount(); // numero de colunas na tabela

		// criando a linha 0
		// Criando a celula na posicao ZERO, que seria A, com referencia na
		// linha ZERO criado acima ou seja, colocaremos
		// informacao na A1
		// Criar Linha Com Nome das Colunas
		int linhan = 0;
		r = s.createRow(linhan);
		 Object A1 = null;
//		org.apache.poi.ss.usermodel.Cell B1 = null;
//		org.apache.poi.ss.usermodel.Cell C1 = null;
//		org.apache.poi.ss.usermodel.Cell D1 = null;
//		org.apache.poi.ss.usermodel.Cell E1 = null;
//		org.apache.poi.ss.usermodel.Cell F1 = null;
//		org.apache.poi.ss.usermodel.Cell G1 = null;
//		org.apache.poi.ss.usermodel.Cell H1 = null;
//		org.apache.poi.ss.usermodel.Cell I1 = null;
//		org.apache.poi.ss.usermodel.Cell J1 = null;
//		org.apache.poi.ss.usermodel.Cell K1 = null;
//		org.apache.poi.ss.usermodel.Cell L1 = null;

		 int i =0;
		A1 = r.createCell(i);
//		B1 = r.createCell(i++);
//		C1 = r.createCell(2);
//		D1 = r.createCell(3);
//		E1 = r.createCell(4);
//		F1 = r.createCell(5);
//		G1 = r.createCell(6);
//		H1 = r.createCell(7);
//		I1 = r.createCell(8);
//		J1 = r.createCell(9);
//		K1 = r.createCell(10);
//		L1 = r.createCell(11);

		// Colocando um valor
		((org.apache.poi.ss.usermodel.Cell) A1).setCellValue("TOTAL PIS");
//		((org.apache.poi.ss.usermodel.Cell) B1).setCellValue("TOTAL COFINS");
//		((org.apache.poi.ss.usermodel.Cell) C1).setCellValue("TOTAL CSLL");
//		((org.apache.poi.ss.usermodel.Cell) D1).setCellValue("TOTAL IRPJ");
//		((org.apache.poi.ss.usermodel.Cell) E1)
//				.setCellValue("TOTAL PIS Retido");
//		((org.apache.poi.ss.usermodel.Cell) F1)
//				.setCellValue("TOTAL COFINS Retido");
//		((org.apache.poi.ss.usermodel.Cell) G1)
//				.setCellValue("TOTAL CSLL Retido");
//		((org.apache.poi.ss.usermodel.Cell) H1)
//				.setCellValue("TOTAL IRPJ Retido");
//		((org.apache.poi.ss.usermodel.Cell) I1).setCellValue("TOTAL SOMA PIS");
//		((org.apache.poi.ss.usermodel.Cell) J1)
//				.setCellValue("TOTAL SOMA COFINS");
//		((org.apache.poi.ss.usermodel.Cell) K1).setCellValue("TOTAL SOMA CSLL");
//		((org.apache.poi.ss.usermodel.Cell) L1).setCellValue("TOTAL SOMA IRPJ");

		// Criar Linha Com Valor na lina 2 das Colunas
		// criando a linha 1
		r = s.createRow(1);
		org.apache.poi.ss.usermodel.Cell A2 = null;
		org.apache.poi.ss.usermodel.Cell B2 = null;
		org.apache.poi.ss.usermodel.Cell C2 = null;
		org.apache.poi.ss.usermodel.Cell D2 = null;
		org.apache.poi.ss.usermodel.Cell E2 = null;
		org.apache.poi.ss.usermodel.Cell F2 = null;
		org.apache.poi.ss.usermodel.Cell G2 = null;
		org.apache.poi.ss.usermodel.Cell H2 = null;
		org.apache.poi.ss.usermodel.Cell I2 = null;
		org.apache.poi.ss.usermodel.Cell J2 = null;
		org.apache.poi.ss.usermodel.Cell K2 = null;
		org.apache.poi.ss.usermodel.Cell L2 = null;

		A2 = r.createCell(0);
		B2 = r.createCell(1);
		C2 = r.createCell(2);
		D2 = r.createCell(3);
		E2 = r.createCell(4);
		F2 = r.createCell(5);
		G2 = r.createCell(6);
		H2 = r.createCell(7);
		I2 = r.createCell(8);
		J2 = r.createCell(9);
		K2 = r.createCell(10);
		L2 = r.createCell(11);

		// Colocando um valor
		((org.apache.poi.ss.usermodel.Cell) A2).setCellValue(TOTALPIS);
		((org.apache.poi.ss.usermodel.Cell) B2).setCellValue(TOTALCOFINS);
		((org.apache.poi.ss.usermodel.Cell) C2).setCellValue(TOTALCSLL);
		((org.apache.poi.ss.usermodel.Cell) D2).setCellValue(TOTALIRPJ);
		((org.apache.poi.ss.usermodel.Cell) E2).setCellValue(TOTALPISRetencao);
		((org.apache.poi.ss.usermodel.Cell) F2)
				.setCellValue(TOTALCOFINSRetencao);
		((org.apache.poi.ss.usermodel.Cell) G2).setCellValue(TOTALCSLLRetencao);
		((org.apache.poi.ss.usermodel.Cell) H2).setCellValue(TOTALIRPJRetencao);
		((org.apache.poi.ss.usermodel.Cell) I2).setCellValue(TOTALSOMAPIS);
		((org.apache.poi.ss.usermodel.Cell) J2).setCellValue(TOTALSOMACOFINS);
		((org.apache.poi.ss.usermodel.Cell) K2).setCellValue(TOTALSOMACSLL);
		((org.apache.poi.ss.usermodel.Cell) L2).setCellValue(TOTALSOMAIRPJ);

		// Criar Linha Con Nome das Colunas
		// criando a linha 4
		r = s.createRow(3);

		org.apache.poi.ss.usermodel.Cell A4 = null;
		org.apache.poi.ss.usermodel.Cell B4 = null;
		org.apache.poi.ss.usermodel.Cell C4 = null;
		org.apache.poi.ss.usermodel.Cell D4 = null;
		org.apache.poi.ss.usermodel.Cell E4 = null;
		org.apache.poi.ss.usermodel.Cell F4 = null;
		org.apache.poi.ss.usermodel.Cell G4 = null;
		org.apache.poi.ss.usermodel.Cell H4 = null;
		org.apache.poi.ss.usermodel.Cell I4 = null;
		org.apache.poi.ss.usermodel.Cell J4 = null;
		org.apache.poi.ss.usermodel.Cell K4 = null;
		org.apache.poi.ss.usermodel.Cell L4 = null;

		A4 = r.createCell(0);
		B4 = r.createCell(1);
		C4 = r.createCell(2);
		D4 = r.createCell(3);
		E4 = r.createCell(4);
		F4 = r.createCell(5);
		G4 = r.createCell(6);
		H4 = r.createCell(7);
		I4 = r.createCell(8);
		J4 = r.createCell(9);
		K4 = r.createCell(10);
		L4 = r.createCell(11);

		// Colocando um valor
		((org.apache.poi.ss.usermodel.Cell) A4).setCellValue("Nota Fiscal");
		((org.apache.poi.ss.usermodel.Cell) B4).setCellValue("Empresa");
		((org.apache.poi.ss.usermodel.Cell) C4).setCellValue("Valor Nota");
		((org.apache.poi.ss.usermodel.Cell) D4).setCellValue("Medico");
		((org.apache.poi.ss.usermodel.Cell) E4).setCellValue("PIS");
		((org.apache.poi.ss.usermodel.Cell) F4).setCellValue("COFINS");
		((org.apache.poi.ss.usermodel.Cell) G4).setCellValue("CSLL");
		((org.apache.poi.ss.usermodel.Cell) H4).setCellValue("IRPJ");
		((org.apache.poi.ss.usermodel.Cell) I4).setCellValue("PIS Retido");
		((org.apache.poi.ss.usermodel.Cell) J4).setCellValue("COFINS Retido");
		((org.apache.poi.ss.usermodel.Cell) K4).setCellValue("CSLL Retido");
		((org.apache.poi.ss.usermodel.Cell) L4).setCellValue("IRPJ Retido");
		//

		 for (int linha = 0; linha < 3; linha++) {
//		for (int linha = 0; linha < df.getRowCount(); linha++) {

			// String f= (String) df.getValueAt(linha,3);
			// System.out.println("f "+f);

//			org.apache.poi.ss.usermodel.Cell vMedico = null;
//			org.apache.poi.ss.usermodel.Cell vNotaFiscal = null;
//			org.apache.poi.ss.usermodel.Cell vEmpresa = null;
//			org.apache.poi.ss.usermodel.Cell vValorNota = null;
//			org.apache.poi.ss.usermodel.Cell vPIS = null;
//			org.apache.poi.ss.usermodel.Cell vCOFINS = null;
//			org.apache.poi.ss.usermodel.Cell vCSLL = null;
//			org.apache.poi.ss.usermodel.Cell vIRPJ = null;
//			org.apache.poi.ss.usermodel.Cell vPISRetido = null;
//			org.apache.poi.ss.usermodel.Cell vCOFINSRetido = null;
//			org.apache.poi.ss.usermodel.Cell vCSLLRetido = null;
//			org.apache.poi.ss.usermodel.Cell vIRPJRetido = null;

			r = s.createRow(linha + 4);
			// System.out.println(r);
//			vNotaFiscal = r.createCell(0);
//			vEmpresa = r.createCell(1);
//			vValorNota = r.createCell(2);
//			vMedico = r.createCell(3);
//			vPIS = r.createCell(4);
//			vCOFINS = r.createCell(5);
//			vCSLL = r.createCell(6);
//			vIRPJ = r.createCell(7);
//			vPISRetido = r.createCell(8);
//			vCOFINSRetido = r.createCell(9);
//			vCSLLRetido = r.createCell(10);
//			vIRPJRetido = r.createCell(11);

//			DefaultTableModel df = null;
//			String NumerodaNota = (String) df.getValueAt(linha, 0);
//			;
//			String Empresa = (String) df.getValueAt(linha, 1);
//			String ValordaNota = (String) df.getValueAt(linha, 2);
//			String Medico = (String) df.getValueAt(linha, 3);
//			String PIS = (String) df.getValueAt(linha, 4);
//			String COFINS = (String) df.getValueAt(linha, 5);
//			String CSLL = (String) df.getValueAt(linha, 6);
//			String IRPJ = (String) df.getValueAt(linha, 7);
//			String PISRetido = (String) df.getValueAt(linha, 8);
//			String COFINSRetido = (String) df.getValueAt(linha, 9);
//			String CSLLRetido = (String) df.getValueAt(linha, 10);
//			String IRPJRetido = (String) df.getValueAt(linha, 11);

			// Colocando um valor
//			((org.apache.poi.ss.usermodel.Cell) vMedico).setCellValue(Medico);
//			((org.apache.poi.ss.usermodel.Cell) vNotaFiscal)
//					.setCellValue(NumerodaNota);
//			((org.apache.poi.ss.usermodel.Cell) vEmpresa).setCellValue(Empresa);
//			((org.apache.poi.ss.usermodel.Cell) vValorNota)
//					.setCellValue(ValordaNota);
//			((org.apache.poi.ss.usermodel.Cell) vPIS).setCellValue(PIS);
//			((org.apache.poi.ss.usermodel.Cell) vCOFINS).setCellValue(COFINS);
//			((org.apache.poi.ss.usermodel.Cell) vCSLL).setCellValue(CSLL);
//			((org.apache.poi.ss.usermodel.Cell) vIRPJ).setCellValue(IRPJ);
//			((org.apache.poi.ss.usermodel.Cell) vPISRetido)
//					.setCellValue(PISRetido);
//			((org.apache.poi.ss.usermodel.Cell) vCOFINSRetido)
//					.setCellValue(COFINSRetido);
//			((org.apache.poi.ss.usermodel.Cell) vCSLLRetido)
//					.setCellValue(CSLLRetido);
//			((org.apache.poi.ss.usermodel.Cell) vIRPJRetido)
//					.setCellValue(IRPJRetido);

		}// fim for

		// Salvando o arquivo
		wb.write(out);
		out.close();

	}

	private static FileOutputStream CriarXLS(String nomePlanilhaMedico,
			String nomePastaMedicoAno, String nomePastaMedicoMes)
			throws FileNotFoundException {
		FileOutputStream out = new FileOutputStream("C:/"
				+ nomePastaMedicoAno + "/" + nomePastaMedicoMes + "/"
				+ nomePlanilhaMedico + ".xls");
		return out;
	}

	private static void CriarPasta(String nomePastaMedicoAno,
			String nomePastaMedicoMes) {
		File file1 = new File("C:/" + nomePastaMedicoAno + "/"
				+ nomePastaMedicoMes);
		file1.mkdir();
	}

	private static void CriarPasta(String nomePastaMedicoAno) {
		File file = new File("C:/" + nomePastaMedicoAno);
		file.mkdir();
	}

}
