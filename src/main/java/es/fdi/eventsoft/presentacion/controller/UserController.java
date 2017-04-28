package es.fdi.eventsoft.presentacion.controller;

import es.fdi.eventsoft.negocio.modelo.Cliente;
import es.fdi.eventsoft.negocio.modelo.Organizador;
import es.fdi.eventsoft.negocio.modelo.Proveedor;
import es.fdi.eventsoft.negocio.modelo.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/usuarios/")
public class UserController {

    /* =================================
           AQUÍ LOS GETS DE USUARIOS
       =================================*/
    @RequestMapping("perfil-usuario")
    public String home(Model model) {
        model.addAttribute("title", "EventSoft");
        model.addAttribute("pagina", "perfil");
        return "perfil-usuario";
    }

    /* -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_ */


    /* =================================
           AQUÍ LOS POSTS DE USUARIOS
       ================================= */


    @RequestMapping(value = "registrar_usuario", method = RequestMethod.POST)
    public String registrar_usuario(@ModelAttribute("Organizador") Organizador organizador,
                                    @ModelAttribute("Proveedor") Proveedor proveedor,
                                    @ModelAttribute("Cliente") Cliente cliente,
                                    @RequestParam String seleccion,
                                    HttpSession session) {

        //Creo una nueva variable usuario que utilizaré para guardarlo en sesión.
        Usuario usuario = null;

        if (seleccion.equalsIgnoreCase("cliente")) {
            // System.out.println("Tengo un nuevo cliente con nombre: " + cliente.getNombre());
            // session.setAttribute("nombre", cliente.getNombre());
            session.setAttribute("rol", "Cliente");
        } else if (seleccion.equalsIgnoreCase("organizador")) {
            System.out.println("Tengo un nuevo organizador con nombre: " + organizador.getEmpresa());
            session.setAttribute("nombre", organizador.getEmpresa());
            session.setAttribute("rol", "Organizador");
        } else if (seleccion.equalsIgnoreCase("proveedor")) {
            System.out.println("Tengo un nuevo proveedor con nombre: " + proveedor.getEmpresa());
            session.setAttribute("nombre", organizador.getEmpresa());
            session.setAttribute("rol", "Proveedor");
        }

        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        session.setAttribute("fecha_registro", formateador.format(ahora));

        return "redirect:index";
    }


    /*
        USER CONTROLLER.
     */


    @RequestMapping(value = "registrar_cliente", method = RequestMethod.POST)
    public String registrar_Cliente(@ModelAttribute("Cliente") Cliente cliente,HttpSession session) {

        System.out.println("");
        System.out.println("--------------- Cliente -----------------------");
        System.out.println("-- " + cliente.toString());
        System.out.println("-------------------------------------------");
        System.out.println("");

        //Creo una nueva variable usuario que utilizaré para guardarlo en sesión.
        Usuario usuario = null;


        return "perfil-usuario";
    }

    /*
        USER CONTROLLER.
     */


    @RequestMapping(value = "registrar_organizador", method = RequestMethod.POST)
    public String registrar_Organizador(@ModelAttribute("Organizador") Organizador organizador,HttpSession session) {

        System.out.println("");
        System.out.println("----------------- Organizador ---------------------");
        System.out.println("-- " + organizador.toString());
        System.out.println("-------------------------------------------");
        System.out.println("");

        //Creo una nueva variable usuario que utilizaré para guardarlo en sesión.
        Usuario usuario = null;


        return "nuevo-evento";
    }

    /*
        USER CONTROLLER.
     */


    @RequestMapping(value = "registrar_proveedor", method = RequestMethod.POST)
    public String registrar_Proveedor(@ModelAttribute("Proveedor") Proveedor proveedor,HttpSession session) {

        System.out.println("");
        System.out.println("-------------------- Proveedor -----------------------");
        System.out.println("-- " + proveedor.toString());
        System.out.println("-------------------------------------------");
        System.out.println("");

        //Creo una nueva variable usuario que utilizaré para guardarlo en sesión.
        Usuario usuario = null;


        return "proveedores";
    }
}