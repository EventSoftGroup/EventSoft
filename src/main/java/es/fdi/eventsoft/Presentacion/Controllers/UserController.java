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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.BUSCAR_USUARIO;
import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.ELIMINAR_USUARIO;
import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.ERROR_BUSCAR_USUARIO;

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
            session.setAttribute("usuario", cliente);
            session.setAttribute("rol", "Cliente");
            model.addAttribute("pagina", "perfil-usuario");
            return "perfil-usuario";
        }else if(contexto.getEvento() == EventosNegocio.EMAIL_YA_EXISTENTE){
            model.addAttribute("tipoUsuario", "cliente");
            bindingResult.rejectValue("email" , "error.cliente", "Email ya existente en el sistema");
            return "register";
        }else{
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
            session.setAttribute("usuario", organizador);
            session.setAttribute("rol", "Organizador");
            model.addAttribute("pagina", "nuevo-evento");
            return "redirect:/eventos/nuevo";
        }else if(contexto.getEvento() == EventosNegocio.EMAIL_YA_EXISTENTE){
            model.addAttribute("tipoUsuario", "organizador");
            bindingResult.rejectValue("email" , "error.organizador", "Email ya existente en el sistema");
            return "register";
        }else{
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
            session.setAttribute("usuario", proveedor);
            session.setAttribute("rol", "Proveedor");
            session.setAttribute("email", proveedor.getEmail());
            model.addAttribute("pagina", "proveedores");
            return "redirect:/eventos/proveedores";
        }else if(contexto.getEvento() == EventosNegocio.EMAIL_YA_EXISTENTE){
            model.addAttribute("tipoUsuario", "proveedor");
            bindingResult.rejectValue("email" , "error.cliente", "Email ya existente en el sistema");
            return "register";
        }else{
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

    @GetMapping(value = "buscarUsuario/{id}",
            produces = "application/json")
    public @ResponseBody ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id, Model model) {

        if(id>0) {
            Contexto contex = FactoriaComandos.getInstance().crearComando(BUSCAR_USUARIO).execute(id);

            if(contex.getEvento() == BUSCAR_USUARIO){
                return new ResponseEntity<>((Usuario) contex.getDatos(), HttpStatus.OK);
            }else if(contex.getEvento() == ERROR_BUSCAR_USUARIO) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "modificar", method = RequestMethod.PUT)
    public String modificar(@ModelAttribute("Usuario") Usuario usuario, Model model) {
        FachadaIntegracion<Usuario> fachadaIntegracion = FachadaIntegracion.newInstance(Usuario.class);
        fachadaIntegracion.modifica(usuario);

        return "usuario-modificado";
    }

    @RequestMapping(value = "eliminar", method = RequestMethod.POST)
    public String eliminar(Model model, HttpSession session) throws ExcepcionNegocio {
        //SAUsuario saUsuario = FactoriaSA.getInstance().crearSAUsuarios();
        //saUsuario.eliminarUsuario(usuario);
        //Comprobamos que tenemos la sessión abierta y encontramos el atributo email.
        Contexto context = FactoriaComandos.getInstance().crearComando(ELIMINAR_USUARIO).execute(session.getAttribute("usuario"));

        return "login";
    }

}