package es.upm.dit.aled.lab5;

/**
 * Pista de despegue
 *
 * Se han añadido aserciones para comprobar que todo funciona correctamente
 * (https://docs.oracle.com/javase/8/docs/technotes/guides/language/assert.html)
 * y se ha separado la espera para entrar en pista de la espera por turbulencias
 * para un mayor realismo.
 *
 * @author jpuente
 * @version 04.12.2017
 */
public class Pista {


    /**
     * Pista ocupada
     */
    private boolean ocupada = false;

    /**
     * Turbulencias
     */
    private boolean turbulencias = false;

    /**
     * Tipo de la última aeronave que ha despegado
     */
    private Tipo ultimo = null;

    /**
     * Número de aviones esperando entrar en pista
     */
    private int avionesEsperando = 0;

    /**
     * Las aeronaves invocan este método cuando llegan a la pista.
     *
     * @param vuelo
     * @param tipo
     */
    public synchronized void entra(long vuelo, Tipo tipo) {
        try {
            if (tipo == Tipo.AVION) {
                avionesEsperando++;
            }
            while (ocupada || (tipo == Tipo.AVIONETA && ultimo == Tipo.AVIONETA && avionesEsperando > 0)) {
                wait();
            }
            ocupada = true;

            System.out.println("····· vuelo " + vuelo + " pasa a pista");
            assert ocupada && (tipo == Tipo.AVION ||
                    (tipo == Tipo.AVIONETA && (ultimo == Tipo.AVION || avionesEsperando == 0)))
                    : " avioneta " + vuelo + " pasando incorrectamente";

            if (tipo == Tipo.AVION)
                avionesEsperando--;
            ultimo = tipo;

            // ahora espera que no haya turbulencias (pero ya dentro de la pista)
            while (turbulencias) {
                wait();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        assert ocupada && !turbulencias : "vuelo " + vuelo + " entrando incorrectamente";
        System.out.println("----- " + vuelo + " " + tipo + " comienza despegue");
    }

    /**
     * Las aeronaves invocan este método cuando despegan.
     *
     * @param vuelo
     */
    public synchronized void despega(long vuelo) {
        ocupada = false;
        turbulencias = true;
        notifyAll();
        System.out.println("----- " + vuelo + " despega");
    }

    /**
     * Las aeronaves invovan este método para indicar que han
     * terminado las turbulencias
     */
    public synchronized void finTurbulencias() {
        turbulencias = false;
        notifyAll();
        System.out.println("----- " + "fin de turbulencias");
    }

}
