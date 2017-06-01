package es.fdi.eventsoft.negocio.servicios.usuarios.imp;

import es.fdi.eventsoft.integracion.FachadaIntegracion;
import es.fdi.eventsoft.negocio.entidades.usuario.Usuario;
import javafx.util.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserDetail implements UserDetailsService {

    private Logger log = LoggerFactory.getLogger(UserDetail.class);
    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em){
        this.em = em;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario u = em.createQuery(
                "from Usuario where email = :email", Usuario.class)
                .setParameter("email", email)
                .getSingleResult();

        ArrayList<SimpleGrantedAuthority> roles = new ArrayList<>();
        for (String rol : u.getRoles().split("[,]")) {
            roles.add(new SimpleGrantedAuthority("ROLE_" + rol));
        }

        log.info(u.getRoles());

        return new org.springframework.security.core.userdetails.User(
                u.getEmail(), u.getPassword(), roles);
    }
}
