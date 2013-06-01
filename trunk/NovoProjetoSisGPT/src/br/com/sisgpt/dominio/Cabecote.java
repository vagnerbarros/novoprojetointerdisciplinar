package br.com.sisgpt.dominio;

public class Cabecote {

	public static String DOBRA_CANTOS_MEIO = "Dobra Cantos e Dobra Meio";
	public static String NORMAL = "Corte Normal";
	public static String MEIO = "Dobra Meio";
	public static String PONTEIRA = "Ponteira";
	public static String TODOS = "Todos"; 

	public String [] tiposCabecote(){
		return new String [] {DOBRA_CANTOS_MEIO, NORMAL, MEIO, PONTEIRA, TODOS};
	}
}
