package br.com.sisgpt.util;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Conversor {

	public static Date stringToDate(String datas) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		java.sql.Date temp = null;

		try {
			java.util.Date data = format.parse(datas);

			java.sql.Date date = new java.sql.Date(data.getTime());
			temp = date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}



	// TRANSFORMAR DE STRING EM HORA
	public static Time stringToHour(String hora) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		java.sql.Time temp = null;

		try {
			java.util.Date data = format.parse(hora);

			Time time = new Time(data.getTime());
			temp = time;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	// CONVERTER DE DATA PARA STRING
	public static String dateToString(Date dd) {

		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
		String retorno = "";

		try {
			String data = formataData.format(dd);
			retorno = data;
		} catch (Exception e) {
			retorno = "";
		}
		return retorno;
	}

	// CONVERTER DE HORA PARA STRING
	public static String hourToString(Time dd) {
		SimpleDateFormat formataData = new SimpleDateFormat("HH:mm");
		String retorno = "";

		try {
			String data = formataData.format(dd);
			retorno = data;
		} catch (Exception e) {
			retorno = "";
		}

		return retorno;
	}
}
