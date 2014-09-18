package br.com.efb.controller.Convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverteData {

	/**
	 * Converte Data Para String
	 * @param data
	 * @return
	 * @throws ParseException
	 */
	public String converteParaString(Date data) throws ParseException {

//		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

		String result = out.format(data);
		// String result = out.format(in.parse(data.toString()));
		return result;

	}

	/**
	 * Converte String Para Date
	 * @param StringData
	 * @return
	 * @throws ParseException
	 */
	public Date converteParaData(String StringData) throws ParseException {

//		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");

		Date result = out.parse(StringData);
		return result;

	}

	public static void main(String[] args) {
		Date dt = new Date();
		ConverteData converteData = new ConverteData();
		String dh = null;
		try {
			dh = converteData.converteParaString(dt);
			System.out.println(dh);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			dt = converteData.converteParaData(dh);
			System.out.println(dt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
