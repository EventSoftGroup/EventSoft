package es.fdi.eventsoft.Negocio.Entidades;

import es.fdi.eventsoft.Negocio.Entidades.Validadores.Telefono;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tomas on 24/04/2017.
 */


public class Empleado implements Serializable {

    /****************************
     ********* ATRIBUTOS ********
     ****************************/

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Size(min=2, max=30)
    private String apellidos;

    @Size(min=2, max=30)
    @NotEmpty(message = "Escribe algo capullo!")
    private String nombre;

    @NotBlank
    @Email
    private String email;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Past
    private Date fechaNacimiento;

    @Telefono
    private String telefono;

    /****************************
     ******* CONSTRUCTORES ******
     ****************************/

    public Empleado() {

    }

    public Empleado(Long id, String apellidos, String nombre, String email, Date fechaNacimiento, Integer age) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Empleado(Long l) {
        this.id = l;
    }

    public Empleado(Long id, String apellidos, String nombre, Date fechaNacimiento) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Empleado(String apellidos, String nombre, Date fechaNacimiento, String email) {
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }


    /****************************
     **** GETTERS AND SETTERS ***
     ****************************/


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", telefono=" + telefono +
                '}';
    }
}
