package es.fdi.eventsoft.negocio.servicios.usuarios.imp;

import es.fdi.eventsoft.integracion.FachadaIntegracion;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import es.fdi.eventsoft.negocio.servicios.factoria.FactoriaSA;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("userDetailsService")
public class UserDetail implements UserDetailsService {

    private Logger log = LoggerFactory.getLogger(UserDetail.class);
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            Usuario u = new SAUsuarioImp().buscarUsuarioByEmail(email);

            ArrayList<SimpleGrantedAuthority> roles = new ArrayList<>();
            for (String rol : u.getRoles().split("[,]")) {
                roles.add(new SimpleGrantedAuthority("ROLE_" + rol));
            }

            return new org.springframework.security.core.userdetails.User(
                    u.getEmail(), u.getPassword(), roles);
        } catch (Exception e) {
            //log.error(e.getMessage());
            //e.printStackTrace();
            throw new UsernameNotFoundException("Usuario con email: " + email + " no encontrado.");
        }
    }
}
