package es.fdi.eventsoft.negocio.excepcionNegocio;

/**
 * Created by Tomas on 29/04/17.
 */
public class ExcepcionNegocio extends Exception {

    private static final long serialVersionUID = 3939587969769222770L;



    public ExcepcionNegocio() {
        super();
    }

    public ExcepcionNegocio(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcepcionNegocio(String message) {
        super(message);
    }

    public ExcepcionNegocio(Throwable cause) {
        super(cause);
    }


}
