package br.com.sisgpt.dominio;

public class Funcao {

	public static String GERENTE = "Gerente";
	public static String OPERARIO = "Operário";

	public String [] getFuncoes(){
		return new String [] {GERENTE, OPERARIO};
	}
}
