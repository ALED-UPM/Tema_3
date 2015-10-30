package es.upm.dit.aled.lab4;

/**
 * Funciones parametricas.
 *
 * @author Jose A. Manas
 * @version 10.2.2012
 */
public class Funcion01
        implements FuncionP {

    /**
     * Constructor.
     */
    public Funcion01() {
    }

    /**
     * Valor de X en función de t.
     *
     * @param t parametro.
     * @return x(t).
     */
    public double fx(double t) {
        return 3 * Math.sin(5 * t);
    }

    /**
     * Valor de Y en función de t.
     *
     * @param t parametro.
     * @return y(t).
     */
    public double fy(double t) {
        return 3 * Math.cos(3 * t);
    }
}


