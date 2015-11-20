package es.upm.dit.aled.puente;

import java.util.Random;

public enum Direccion {
	SUBE, BAJA;
	
	static Random r = new Random();
	static Direccion[] dir = Direccion.values();
	static int n = dir.length;
	
	public static  Direccion random() {
		return dir[r.nextInt(n)];
	}
}
