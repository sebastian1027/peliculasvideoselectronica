package movil.unicauca.peliculas.models;

/**
 * Created by sebastianl on 12/06/2017.
 */

public class User {
    Long idusuario;
    String nombre, apellido, email, edad, usuario, password;

    public User(String nombre, String apellido, String email, String edad, String usuario, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
        this.usuario = usuario;
        //this.password = password;
        this.password = password;
    }

    public User(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    /*public User(String usuario, String pass) {
        this.usuario = usuario;
        this.password = pass;
    }*/

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
