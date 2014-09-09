package br.com.efb.excel;

import java.io.IOException;

import jxl.read.biff.BiffException;

public class Cadastro {

	public static void main(String[] args) {
//		CriarPlanilha criarPlanilha = new CriarPlanilha();
//		try {
//			criarPlanilha.CriarPanilha(null, null, null, null, null, null, null,
//					null, null, null, null, null, "plan", "pasta", "asd");
//		} catch (BiffException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	//emerson
		LerPlanilha lerPlanilha = new LerPlanilha();
		try {
			String[][] p = lerPlanilha.LerPanilha();
			
			for (int l = 0; l < p[0].length; l++) {
				for (int i = 0; i < p.length; i++) {
					System.out.println(p[i][l]);
				}
			}
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("ok");
	}

}
