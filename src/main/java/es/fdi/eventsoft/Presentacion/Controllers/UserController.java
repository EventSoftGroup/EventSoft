package es.fdi.eventsoft.Presentacion.Controllers;


import es.fdi.eventsoft.Negocio.Comandos.Comando;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Organizador;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Presentacion.Validadores.ValidadorCliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

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
    public String registrar_usuario(@ModelAttribute("Organizador") Organizador Organizador,
                                    @ModelAttribute("Proveedor") Proveedor Proveedor,
                                    @ModelAttribute("Cliente") Cliente Cliente,
                                    @RequestParam String seleccion,
                                    HttpSession session) {

        //Creo una nueva variable Usuario que utilizaré para guardarlo en sesión.
        Usuario Usuario = null;

        if (seleccion.equalsIgnoreCase("Cliente")) {
            System.out.println("Tengo un nuevo Cliente con nombre: " + Cliente.getNombre());
            session.setAttribute("nombre", Cliente.getNombre());
            session.setAttribute("rol", "Cliente");
        } else if (seleccion.equalsIgnoreCase("Organizador")) {
            System.out.println("Tengo un nuevo Organizador con nombre: " + Organizador.getEmpresa());
            session.setAttribute("nombre", Organizador.getEmpresa());
            session.setAttribute("rol", "Organizador");
        } else if (seleccion.equalsIgnoreCase("Proveedor")) {
            System.out.println("Tengo un nuevo Proveedor con nombre: " + Proveedor.getEmpresa());
            session.setAttribute("nombre", Organizador.getEmpresa());
            session.setAttribute("rol", "Proveedor");
        }

        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
        session.setAttribute("fecha_registro", formateador.format(ahora));

        Comando comando = FactoriaComandos.getInstance().crearComando(EventosNegocio.CREAR_USUARIO);
        Contexto contexto = comando.execute(Cliente);
        System.out.println("Datos recibidos: " + contexto.getDatos());

        return "redirect:index";
    }*/


    /*
        USER CONTROLLER.
     */


    @RequestMapping(value = "registrar_cliente", method = RequestMethod.POST)
    public String registrar_Cliente(@ModelAttribute("TCliente") Cliente Cliente, HttpSession session, Model model, BindingResult result) {


        System.out.println("Valor de nombre: " + Cliente.getNombre());
        ValidadorCliente validadorCliente = new ValidadorCliente();
        validadorCliente.validate(Cliente, result);
        if (result.hasErrors()) {
            System.out.println("Hay errores");


        } else {
            System.out.println("No Hay errores");
        }

        System.out.println("");
        System.out.println("--------------- Cliente -----------------------");
        System.out.println("-- " + Cliente.toString());
        System.out.println("-------------------------------------------");
        System.out.println("");

        Comando comando = FactoriaComandos.getInstance().crearComando(EventosNegocio.CREAR_USUARIO);
        Contexto contexto = comando.execute(Cliente);
        System.out.println("Datos recibidos: " + contexto.getDatos());



        session.setAttribute("rol", "Cliente");
        model.addAttribute("pagina", "perfil-usuario");

        return "perfil-usuario";
    }

    /*
        USER CONTROLLER.
     */


    @RequestMapping(value = "registrar_organizador", method = RequestMethod.POST)
    public String registrar_Organizador(@ModelAttribute("Organizador") Organizador Organizador, HttpSession session) {

        System.out.println("");
        System.out.println("----------------- Organizador ---------------------");
        System.out.println("-- " + Organizador.toString());
        System.out.println("-------------------------------------------");
        System.out.println("");

        //Creo una nueva variable Usuario que utilizaré para guardarlo en sesión.
        Usuario Usuario = null;


        return "nuevo-evento";
    }

    /*
        USER CONTROLLER.
     */


    @RequestMapping(value = "registrar_proveedor", method = RequestMethod.POST)
    public String registrar_Proveedor(@ModelAttribute("Proveedor") Proveedor TProveedor, HttpSession session) {

        System.out.println("");
        System.out.println("-------------------- Proveedor -----------------------");
        System.out.println("-- " + TProveedor.toString());
        System.out.println("-------------------------------------------");
        System.out.println("");

        //Creo una nueva variable Usuario que utilizaré para guardarlo en sesión.
        Usuario Usuario = null;


        return "proveedores";
    }
}