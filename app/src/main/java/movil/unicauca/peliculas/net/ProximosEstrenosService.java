package movil.unicauca.peliculas.net;

import java.util.List;

import movil.unicauca.peliculas.models.Cartelera;
import movil.unicauca.peliculas.models.SimpleResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by sebastianl on 12/06/2017.
 */

public interface ProximosEstrenosService {

    @GET("cartelera")
    Call<List<Cartelera>> all();

    @POST("cartelera")
    Call<SimpleResponse> insert(@Body Cartelera cartelera);
}
