package br.com.sisgpt.dominio;

public class Setor {

	public static String ACABAMENTO = "Acabamento";
	public static String TECELAGEM = "Tecelagem";
	public static String LASER = "Laser";
	public static String PONTEIRA = "Ponteira";

	public String [] getSetores(){
		return new String [] {ACABAMENTO, TECELAGEM, LASER, PONTEIRA};
	}
}
