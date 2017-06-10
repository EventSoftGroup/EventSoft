package es.fdi.eventsoft.presentacion.controllers;

import es.fdi.eventsoft.negocio.comandos.Contexto;
import es.fdi.eventsoft.negocio.comandos.EventosNegocio;
import es.fdi.eventsoft.negocio.comandos.factoria.FactoriaComandos;
import es.fdi.eventsoft.negocio.entidades.Servicio;
import es.fdi.eventsoft.negocio.entidades.usuario.Cliente;
import es.fdi.eventsoft.negocio.entidades.usuario.Organizador;
import es.fdi.eventsoft.negocio.entidades.usuario.Proveedor;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.entidades.validadores.UserValidator;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static es.fdi.eventsoft.negocio.comandos.EventosNegocio.*;

@Controller
@RequestMapping("/usuarios")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserValidator userValidator;

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("title", "EventSoft");
        return "registrarTipoUsuario";
    }

    @RequestMapping("/tipoUsuario")
    public String registerDatosCLiente(@RequestParam String seleccion, Model model) {

        model.addAttribute("tipoUsuario", seleccion);
        switch (seleccion){
            case "cliente": model.addAttribute("cliente", new Cliente());
            case "organizador": model.addAttribute("organizador", new Organizador());
            case "proveedor": model.addAttribute("proveedor", new Proveedor());
        }
        return "register";
    }

    @RequestMapping(value = "/registrar_cliente", method = RequestMethod.POST)
    public String registrar_Cliente(@Valid Cliente cliente, BindingResult bindingResult, Model model, HttpSession session) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("tipoUsuario", "cliente");
            return "register";
        }
        cliente.setPassword(passwordEncoder.encode(cliente.getPassword()));
        cliente.setRoles("USER,CLIENTE");
        Contexto contexto = FactoriaComandos.getInstance().crearComando(EventosNegocio.CREAR_USUARIO).execute(cliente);


        if(contexto.getEvento() == EventosNegocio.USUARIO_CREADO){
            return "redirect:/login";
        }else if(contexto.getEvento() == EventosNegocio.EMAIL_YA_EXISTENTE){
            model.addAttribute("tipoUsuario", "cliente");
            bindingResult.rejectValue("email" , "error.cliente", "Email ya existente en el sistema");
            return "register";
        }else{
            model.addAttribute("pagina", "error-500");
            return "error-500";

        }
    }

    @RequestMapping(value = "/registrar_organizador", method = RequestMethod.POST)
    public String registrar_Organizador(@Valid Organizador organizador, BindingResult bindingResult, Model model, HttpSession session) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("tipoUsuario", "organizador");
            return "register";
        }

        organizador.setPassword(passwordEncoder.encode(organizador.getPassword()));
        organizador.setRoles("USER,ORGANIZADOR");
        Contexto contexto = FactoriaComandos.getInstance().crearComando(EventosNegocio.CREAR_USUARIO).execute(organizador);


        if(contexto.getEvento() == EventosNegocio.USUARIO_CREADO){
            return "redirect:/login";
        }else if(contexto.getEvento() == EventosNegocio.EMAIL_YA_EXISTENTE){
            model.addAttribute("tipoUsuario", "organizador");
            bindingResult.rejectValue("email" , "error.organizador", "Email ya existente en el sistema");
            return "register";
        }else{
            model.addAttribute("pagina", "error-500");
            return "error-500";
        }

    }

    @RequestMapping(value = "/registrar_proveedor", method = RequestMethod.POST)
    public String registrar_Proveedor(@Valid Proveedor proveedor, BindingResult bindingResult, Model model, HttpSession session) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("tipoUsuario", "proveedor");

            return "register";
        }

        proveedor.setPassword(passwordEncoder.encode(proveedor.getPassword()));
        proveedor.setRoles("USER,PROVEEDOR");
        Contexto contexto = FactoriaComandos.getInstance().crearComando(EventosNegocio.CREAR_USUARIO).execute(proveedor);

        if(contexto.getEvento() == EventosNegocio.USUARIO_CREADO){
            return "redirect:/login";
        }else if(contexto.getEvento() == EventosNegocio.EMAIL_YA_EXISTENTE){
            model.addAttribute("tipoUsuario", "proveedor");
            bindingResult.rejectValue("email" , "error.proveedor", "Email ya existente en el sistema");
            return "register";
        }else{
            model.addAttribute("pagina", "error-500");
            return "error-500";

        }
    }

    @RequestMapping("/perfil-usuario")
    public String home(Model model, HttpSession session) {
        model.addAttribute("title", "EventSoft");
        model.addAttribute("pagina", "perfil");
        model.addAttribute("usuarioAModificar", session.getAttribute("usuario"));
        model.addAttribute("listaTiposServicio", Servicio.TiposServicio.values());

        return "perfil-usuario";
    }

    @GetMapping(value = "/buscar/{id}",
            produces = "application/json")
    public @ResponseBody ResponseEntity<Usuario> buscarUsuario(@PathVariable Long id, Model model) {

        if(id>0) {
            Contexto contex = FactoriaComandos.getInstance().crearComando(BUSCAR_USUARIO_BY_ID).execute(id);

            if(contex.getEvento() == BUSCAR_USUARIO_BY_ID){
                return new ResponseEntity<>((Usuario) contex.getDatos(), HttpStatus.OK);
            }else if(contex.getEvento() == ERROR_BUSCAR_USUARIO) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.POST)
    public String modificar(@ModelAttribute("usuarioAModificar") Usuario usuario, BindingResult bindingResult, Model model) {
        userValidator.validate(usuario, bindingResult);

        if (bindingResult.hasErrors()) {
            return "perfil-usuario";
        }

        Usuario original = FactoriaSA.getInstance().crearSAUsuarios().buscarUsuarioByID(usuario.getId());
        original.setDireccion(usuario.getDireccion());
        original.setLocalidad(usuario.getLocalidad());
        original.setProvincia(usuario.getProvincia());
        original.setCodigoPostal(usuario.getCodigoPostal());
        original.setTelefono(usuario.getTelefono());
        FactoriaComandos.getInstance().crearComando(MODIFICAR_USUARIO).execute(original);

        return "perfil-usuario";
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.POST)
    public String eliminar(Model model, HttpSession session) {
        Contexto context = FactoriaComandos.getInstance().crearComando(ELIMINAR_USUARIO).execute(session.getAttribute("usuario"));

        if (context.getEvento() == ELIMINAR_USUARIO) {
            return "redirect:/logout";
        } else {
            return "redirect:/";
        }

    }

}