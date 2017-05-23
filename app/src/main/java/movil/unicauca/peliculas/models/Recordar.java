package movil.unicauca.peliculas.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Sebastianl on 22/05/2017.
 */

@Entity
public class Recordar {


    String nombrePelcula, fechaEstreno, costo;
    Long idpelicula;

    @Generated(hash = 261123891)
    public Recordar(String nombrePelcula, String fechaEstreno, String costo,
            Long idpelicula) {
        this.nombrePelcula = nombrePelcula;
        this.fechaEstreno = fechaEstreno;
        this.costo = costo;
        this.idpelicula = idpelicula;
    }

    @Generated(hash = 993510675)
    public Recordar() {
    }

    public String getNombrePelcula() {
        return nombrePelcula;
    }

    public void setNombrePelcula(String nombrePelcula) {
        this.nombrePelcula = nombrePelcula;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public Long getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(Long idpelicula) {
        this.idpelicula = idpelicula;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }
}
