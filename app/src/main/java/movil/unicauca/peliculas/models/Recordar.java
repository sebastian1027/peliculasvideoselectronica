package movil.unicauca.peliculas.models;

/**
 * Created by Sebastianl on 22/05/2017.
 */

@Entity()
public class Recordar {
    @Id(autoincrement = true)

    String nombrePelcula, fechaEstreno, costo;
    Long idpelicula;

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
