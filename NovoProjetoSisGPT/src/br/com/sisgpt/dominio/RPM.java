package br.com.sisgpt.dominio;

public class RPM {

	public static int DUZENTOS = 200;
	public static int QUATROCENTOS = 400;
	public static int SEISCENTOS = 600;
	public static int OITOCENTOS = 800;
	public static int MIL = 1000;

	public int [] getValores(){
		return new int [] {DUZENTOS, QUATROCENTOS, SEISCENTOS, OITOCENTOS, MIL};
	}
}
