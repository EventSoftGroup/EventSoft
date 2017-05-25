package es.fdi.eventsoft.Presentacion.Controllers;
import es.fdi.eventsoft.Negocio.Comandos.Contexto;
import es.fdi.eventsoft.Negocio.Comandos.EventosNegocio;
import es.fdi.eventsoft.Negocio.Comandos.Factoria_Comandos.FactoriaComandos;
import es.fdi.eventsoft.Negocio.Entidades.Servicio;
import es.fdi.eventsoft.Negocio.Entidades.Usuario.*;
import es.fdi.eventsoft.Negocio.__excepcionNegocio.ExcepcionNegocio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.Arrays;

import static es.fdi.eventsoft.Negocio.Comandos.EventosNegocio.*;

@Controller
@RequestMapping("/usuarios/")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

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
        if (contexto.getEvento() != null){
            System.out.println("Le inserto el id");
            Contexto contexto_2 = FactoriaComandos.getInstance().crearComando(EventosNegocio.BUSCAR_USUARIO_BY_EMAIL).execute(cliente.getEmail());
            Usuario recibido = (Usuario) contexto_2.getDatos();
            cliente.setId(recibido.getId());
        } else {
            System.out.println("No le inserto el id");
        }

        if(contexto.getEvento() == EventosNegocio.USUARIO_CREADO){
            model.addAttribute("cliente", cliente);
            session.setAttribute("usuario", cliente);
            session.setAttribute("rol", "Cliente");
            session.setAttribute("usuario", cliente);
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
        if (contexto.getEvento() != null) {
            Contexto contexto_2 = FactoriaComandos.getInstance().crearComando(EventosNegocio.BUSCAR_USUARIO_BY_EMAIL).execute(organizador.getEmail());
            Usuario recibido = (Usuario) contexto_2.getDatos();
            organizador.setId(recibido.getId());
        }

        if(contexto.getEvento() == EventosNegocio.USUARIO_CREADO){
            model.addAttribute("organizador", organizador);
            session.setAttribute("usuario", organizador);
            session.setAttribute("rol", "Organizador");
            session.setAttribute("usuario", organizador);
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
        if (contexto.getEvento() != null) {
            Contexto contexto_2 = FactoriaComandos.getInstance().crearComando(EventosNegocio.BUSCAR_USUARIO_BY_EMAIL).execute(proveedor.getEmail());
            Usuario recibido = (Usuario) contexto_2.getDatos();
            proveedor.setId(recibido.getId());
        }

        if(contexto.getEvento() == EventosNegocio.USUARIO_CREADO){
            model.addAttribute("proveedor", proveedor);
            session.setAttribute("usuario", proveedor);
            session.setAttribute("rol", "Proveedor");
            session.setAttribute("email", proveedor.getEmail());
            model.addAttribute("pagina", "proveedores");
            return "redirect:/eventos/proveedores";
        }else if(contexto.getEvento() == EventosNegocio.EMAIL_YA_EXISTENTE){
            model.addAttribute("tipoUsuario", "proveedor");
            bindingResult.rejectValue("email" , "error.proveedor", "Email ya existente en el sistema");
            return "register";
        }else{
            model.addAttribute("pagina", "error-500");
            return "error-500";

        }
    }

    @RequestMapping("perfil-usuario")
    public String home(Model model, HttpSession session) {
        model.addAttribute("title", "EventSoft");
        model.addAttribute("pagina", "perfil");
        model.addAttribute("usuarioAModificar", session.getAttribute("usuario"));
        model.addAttribute("listaTiposServicio", Servicio.TiposServicio.values());

        return "perfil-usuario";
    }

    @GetMapping(value = "buscarUsuario/{id}",
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

    @RequestMapping(value = "modificar", method = RequestMethod.POST)
    public String modificar(
            @RequestParam("idUsuario") Long id,
            @RequestParam("email") String email,
            @RequestParam("direccion") String direccion,
            @RequestParam("localidad") String localidad,
            @RequestParam("provincia") String provincia,
            @RequestParam("codigoPostal") String codigoPostal,
            @RequestParam("telefono") String telefono) {
        Contexto contexto;

        contexto = FactoriaComandos.getInstance().crearComando(BUSCAR_USUARIO_BY_ID).execute(id);
        Usuario usuario = (Usuario) contexto.getDatos();
        usuario.setEmail(email);
        usuario.setDireccion(direccion);
        usuario.setLocalidad(localidad);
        usuario.setProvincia(provincia);
        usuario.setCodigoPostal(codigoPostal);
        usuario.setTelefono(telefono);

        contexto = FactoriaComandos.getInstance().crearComando(MODIFICAR_USUARIO).execute(usuario);
        if (contexto.getEvento() == MODIFICAR_USUARIO) {
            return "perfil-usuario";
        } else {
            return "error-500";
        }
    }

    @RequestMapping(value = "eliminar", method = RequestMethod.POST)
    public String eliminar(Model model, HttpSession session) throws ExcepcionNegocio {
        Contexto context = FactoriaComandos.getInstance().crearComando(ELIMINAR_USUARIO).execute(session.getAttribute("usuario"));

        if (context.getEvento() == ELIMINAR_USUARIO) {
            return "redirect:/login";
        } else {
            return "redirect:./#";
        }

    }

}