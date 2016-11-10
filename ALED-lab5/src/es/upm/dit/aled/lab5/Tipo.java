package es.upm.dit.aled.lab5;

/**
 * Tipo de aeronave
 * 
 * @author jpuente
 * @version 06.11.2014
 */
public enum Tipo {
	AVION, AVIONETA;
	
	static final double pAvion = 0.75 ; // probabilidad de que sea un avión
	
	   /**
     * Elije un tipo al azar.
     *
     * @return uno de los tipos posibles
     */
    public static Tipo random() {
    	double x = Math.random(); // 0.0..1.0
    	if (x <= pAvion) {
    		return AVION;
    	} else {
    		return AVIONETA;
    	}   	
    }

}
