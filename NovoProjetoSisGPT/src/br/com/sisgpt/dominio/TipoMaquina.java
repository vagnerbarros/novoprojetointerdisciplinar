package br.com.sisgpt.dominio;

public class TipoMaquina {

	public static String PONTEIRA = "Ponteira";
	public static String CHINESA = "Máquina de Corte Chinesa";
	public static String HOSTQUINIF = "Máquina de Corte HostQuinif"; 
	
	public String [] getTiposMaquina(){
		return new String [] {PONTEIRA, CHINESA, HOSTQUINIF};
	}
}
