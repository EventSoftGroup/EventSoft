package es.fdi.eventsoft.Presentacion.Controllers;


import es.fdi.eventsoft.Integracion.FachadaIntegracion;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.Entidades.Empleado;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Cliente;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Organizador;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Proveedor;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.Usuario;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.Factoria_ServiciosAplicacion.FactoriaSA;
import es.fdi.eventsoft.Negocio.ServiciosAplicacion.SA_Usuario.SAUsuario;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/usuarios/")
public class UserController {

    @RequestMapping("register")
    public String register(Model model) {
        model.addAttribute("title", "EventSoft");

        return "registrarTipoUsuario";
    }

    @RequestMapping("tipoUsuario")
    public String registerDatosCLiente(@RequestParam String seleccion, Model model) {

        model.addAttribute("tipoUsuario", seleccion);
        switch (seleccion){
            case "cliente": model.addAttribute("cliente", new Cliente());
            case "organizador": model.addAttribute("organizador", new Organizador());
            case "proveedor": model.addAttribute("proveedor", new Proveedor());
        }
        return "register";
    }

    @RequestMapping(value = "registrar_cliente", method = RequestMethod.POST)
    public String registrar_Cliente(@Valid Cliente cliente, BindingResult bindingResult, Model model, HttpSession session) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("tipoUsuario", "cliente");
            return "register";
        }
        Contexto contexto = FactoriaComandos.getInstance().crearComando(EventosNegocio.CREAR_USUARIO).execute(cliente);

        if(contexto.getEvento() == EventosNegocio.USUARIO_CREADO){
            model.addAttribute("cliente", cliente);
            session.setAttribute("rol", "Cliente");
            model.addAttribute("pagina", "perfil-usuario");
            return "perfil-usuario";
        }else {
            model.addAttribute("pagina", "error-500");
            return "error-500";
        }

    }

    @RequestMapping(value = "registrar_organizador", method = RequestMethod.POST)
    public String registrar_Organizador(@Valid Organizador organizador, BindingResult bindingResult, Model model, HttpSession session) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("tipoUsuario", "organizador");
            return "register";
        }

        Contexto contexto = FactoriaComandos.getInstance().crearComando(EventosNegocio.CREAR_USUARIO).execute(organizador);

        if(contexto.getEvento() == EventosNegocio.USUARIO_CREADO){
            model.addAttribute("organizador", organizador);
            session.setAttribute("rol", "Organizador");
            model.addAttribute("pagina", "nuevo-evento");
            return "redirect:/eventos/nuevo";
        }else {
            model.addAttribute("pagina", "error-500");
            return "error-500";
        }

    }



    @RequestMapping(value = "registrar_proveedor", method = RequestMethod.POST)
    public String registrar_Proveedor(@Valid Proveedor proveedor, BindingResult bindingResult, Model model, HttpSession session) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("tipoUsuario", "proveedor");
            return "register";
        }

        Contexto contexto = FactoriaComandos.getInstance().crearComando(EventosNegocio.CREAR_USUARIO).execute(proveedor);

        if(contexto.getEvento() == EventosNegocio.USUARIO_CREADO){
            model.addAttribute("proveedor", proveedor);
            session.setAttribute("rol", "Proveedor");
            model.addAttribute("pagina", "proveedores");
            return "redirect:/eventos/proveedores";
        }else {
            model.addAttribute("pagina", "error-500");
            return "error-500";
        }
    }


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

        Comando comando = FactoriaComandos.newInstance().crearComando(EventosNegocio.CREAR_USUARIO);
        Contexto contexto = comando.execute(Cliente);
        System.out.println("Datos recibidos: " + contexto.getDatos());

        return "redirect:index";
    }*/


    @RequestMapping(value = "/cust/save", method = RequestMethod.GET)
    public String saveCustomerPage(Model model) {
        model.addAttribute("empleado", new Empleado());

        return "custSave";
    }

    @RequestMapping(value = "/cust/save.do", method = RequestMethod.POST)
    public String saveCustomerAction(@Valid Empleado empleado, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            System.out.println("Empleado incorrecto!!");
            for (ObjectError err : bindingResult.getAllErrors())
                System.out.println(err.toString());
            return "custSave";
        }

        model.addAttribute("empleado", empleado);
        FachadaIntegracion<Empleado> fachadaIntegracion = FachadaIntegracion.newInstance(Empleado.class);
        fachadaIntegracion.alta(empleado);

        //TestEmpleados.persistirEmpleado(new Empleado("desde Controller", "prueba3", new GregorianCalendar(1979,6,6).getTime()));

        return "custSaveSuccess";

    }


    @RequestMapping("buscarUsuario")
    public String buscarUsuario(Model model) {
        //TODO


        return null;
    }

    @RequestMapping(value = "ver", method = RequestMethod.GET)
    public String ver(Model model) {
        // TODO muestra los datos del usuario seleccionado;

        return null;
    }

    @RequestMapping(value = "modificar", method = RequestMethod.PUT)
    public String modificar(@ModelAttribute("Usuario") Usuario usuario, Model model) {
        FachadaIntegracion<Usuario> fachadaIntegracion = FachadaIntegracion.newInstance(Usuario.class);
        fachadaIntegracion.modifica(usuario);

        return "usuario-modificado";
    }

    @RequestMapping(value = "eliminar", method = RequestMethod.DELETE)
    public String eliminar(@ModelAttribute("Usuario") Usuario usuario, Model model) throws ExcepcionNegocio {
        SAUsuario saUsuario = FactoriaSA.getInstance().crearSAUsuarios();
        saUsuario.eliminarUsuario(usuario);

        return "usuario-eliminado";
    }
}