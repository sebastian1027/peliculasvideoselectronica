package movil.unicauca.peliculas.net;


import movil.unicauca.peliculas.models.SimpleResponse;
import movil.unicauca.peliculas.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by sebastianl on 12/06/2017.
 */

public interface UserService {

    @POST("users/login")
    Call<SimpleResponse> login(@Body User user);

    @POST("users/registro")
    Call<SimpleResponse> registro(@Body User user);
}
