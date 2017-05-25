package es.fdi.eventsoft.Presentacion.Controllers;


import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Entidades.Valoracion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Rodrigo de Miguel on 09/05/2017.
 */
@Controller
@RequestMapping("/valoraciones/")
public class ValoracionesController {

    private Logger log = LoggerFactory.getLogger(ServiciosController.class);

    @RequestMapping("crearValoracion")
    public String crearValoracion(Model model) {
        //TODO



        return null;
    }

    @RequestMapping("buscarValoracion")
    public String buscarValoracion(Model model) {
        //TODO



        return null;
    }

    @RequestMapping(value = "eliminar", method = RequestMethod.DELETE)
    public String eliminar(@RequestAttribute("Valoracion") Valoracion valoracion) {
        FachadaIntegracion<Valoracion> fachadaIntegracion = FachadaIntegracion.newInstance(Valoracion.class);
        fachadaIntegracion.baja(valoracion.getId());

        return "valoracion-eliminada";
    }

    @RequestMapping("buscarValoracionesByUser")
    public String buscarValoracionesByUser(Model model) {
        //TODO


        return null;
    }

}