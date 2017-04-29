package es.fdi.eventsoft.presentacion.controller;

import es.fdi.eventsoft.negocio.Usuario.TCliente;
import es.fdi.eventsoft.negocio.Usuario.TOrganizador;
import es.fdi.eventsoft.negocio.Usuario.TProveedor;
import es.fdi.eventsoft.negocio.Usuario.TUsuario;
import es.fdi.eventsoft.presentacion.Validadores.ValidadorCliente;
import es.fdi.eventsoft.presentacion.comandos.Comando;
import es.fdi.eventsoft.presentacion.comandos.factoriaComandos.FactoriaComandos;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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


    /*@RequestMapping(value = "registrar_usuario", method = RequestMethod.POST)
    public String registrar_usuario(@ModelAttribute("Organizador") TOrganizador TOrganizador,
                                    @ModelAttribute("Proveedor") TProveedor TProveedor,
                                    @ModelAttribute("Cliente") TCliente TCliente,
                                    @RequestParam String seleccion,
                                    HttpSession session) {

        //Creo una nueva variable TUsuario que utilizaré para guardarlo en sesión.
        TUsuario TUsuario = null;

        if (seleccion.equalsIgnoreCase("TCliente")) {
            System.out.println("Tengo un nuevo TCliente con nombre: " + TCliente.getNombre());
            session.setAttribute("nombre", TCliente.getNombre());
            session.setAttribute("rol", "Cliente");
        } else if (seleccion.equalsIgnoreCase("TOrganizador")) {
            System.out.println("Tengo un nuevo TOrganizador con nombre: " + TOrganizador.getEmpresa());
            session.setAttribute("nombre", TOrganizador.getEmpresa());
            session.setAttribute("rol", "Organizador");
        } else if (seleccion.equalsIgnoreCase("TProveedor")) {
            System.out.println("Tengo un nuevo TProveedor con nombre: " + TProveedor.getEmpresa());
            session.setAttribute("nombre", TOrganizador.getEmpresa());
            session.setAttribute("rol", "Proveedor");
        }

        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        session.setAttribute("fecha_registro", formateador.format(ahora));

        Comando comando = FactoriaComandos.getInstance().crearComando(EventoGUI.CREAR_USUARIO);
        Contexto contexto = comando.execute(TCliente);
        System.out.println("Datos recibidos: " + contexto.getDatos());

        return "redirect:index";
    }*/


    /*
        USER CONTROLLER.
     */


    @RequestMapping(value = "registrar_cliente", method = RequestMethod.POST)
    public String registrar_Cliente(@ModelAttribute("TCliente") TCliente TCliente, HttpSession session, Model model, BindingResult result) {


        System.out.println("Valor de nombre: " + TCliente.getNombre());
        ValidadorCliente validadorCliente = new ValidadorCliente();
        validadorCliente.validate(TCliente, result);
        if (result.hasErrors()) {
            System.out.println("Hay errores");


        } else {
            System.out.println("No Hay errores");
        }

        System.out.println("");
        System.out.println("--------------- TCliente -----------------------");
        System.out.println("-- " + TCliente.toString());
        System.out.println("-------------------------------------------");
        System.out.println("");

        Comando comando = FactoriaComandos.getInstance().crearComando(EventoGUI.CREAR_USUARIO);
        Contexto contexto = comando.execute(TCliente);
        System.out.println("Datos recibidos: " + contexto.getDatos());



        session.setAttribute("rol", "Cliente");
        model.addAttribute("pagina", "perfil-usuario");

        return "perfil-usuario";
    }

    /*
        USER CONTROLLER.
     */


    @RequestMapping(value = "registrar_organizador", method = RequestMethod.POST)
    public String registrar_Organizador(@ModelAttribute("Organizador") TOrganizador TOrganizador, HttpSession session) {

        System.out.println("");
        System.out.println("----------------- TOrganizador ---------------------");
        System.out.println("-- " + TOrganizador.toString());
        System.out.println("-------------------------------------------");
        System.out.println("");

        //Creo una nueva variable TUsuario que utilizaré para guardarlo en sesión.
        TUsuario TUsuario = null;


        return "nuevo-evento";
    }

    /*
        USER CONTROLLER.
     */


    @RequestMapping(value = "registrar_proveedor", method = RequestMethod.POST)
    public String registrar_Proveedor(@ModelAttribute("Proveedor") TProveedor TProveedor, HttpSession session) {

        System.out.println("");
        System.out.println("-------------------- TProveedor -----------------------");
        System.out.println("-- " + TProveedor.toString());
        System.out.println("-------------------------------------------");
        System.out.println("");

        //Creo una nueva variable TUsuario que utilizaré para guardarlo en sesión.
        TUsuario TUsuario = null;


        return "proveedores";
    }
}