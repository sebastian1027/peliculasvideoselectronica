package movil.unicauca.peliculas.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Sebastianl on 22/05/2017.
 */

@Entity
public class Recordar {



    Long idpelicula;

    String nombrePelcula, fechaEstreno, costo, hora, precio;

    @Generated(hash = 596594398)
    public Recordar(Long idpelicula, String nombrePelcula, String fechaEstreno,
            String costo, String hora, String precio) {
        this.idpelicula = idpelicula;
        this.nombrePelcula = nombrePelcula;
        this.fechaEstreno = fechaEstreno;
        this.costo = costo;
        this.hora = hora;
        this.precio = precio;
    }

    @Generated(hash = 993510675)
    public Recordar() {
    }

    public Long getIdpelicula() {
        return this.idpelicula;
    }

    public void setIdpelicula(Long idpelicula) {
        this.idpelicula = idpelicula;
    }

    public String getNombrePelcula() {
        return this.nombrePelcula;
    }

    public void setNombrePelcula(String nombrePelcula) {
        this.nombrePelcula = nombrePelcula;
    }

    public String getFechaEstreno() {
        return this.fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getCosto() {
        return this.costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getHora() {
        return this.hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPrecio() {
        return this.precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }


    
}
