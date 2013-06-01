package br.com.sisgpt.dominio;

public class Turno {

	public static String A = "A";
	public static String B = "B";
	public static String C = "C";
	public static String D = "D";
	public static String COMERCIAL = "Comercial";
	
	public String [] getTurnos(){
		return new String [] {A, B, C, D, COMERCIAL};
	}
}
