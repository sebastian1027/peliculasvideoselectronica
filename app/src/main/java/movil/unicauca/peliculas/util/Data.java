package movil.unicauca.peliculas.util;

import java.util.ArrayList;
import java.util.List;

import movil.unicauca.peliculas.models.Cartelera;
import movil.unicauca.peliculas.models.ProximosEstrenos;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sebastianl on 11/05/2017.
 */

public class Data {

    public static List<Cartelera> data = new ArrayList<>(); //lista estatica para hacer referencia a data directamente



    //public static List<ProximosEstrenos> datape; //lista estatica para hacer referencia a data directamente
    public static List<ProximosEstrenos> datape = new ArrayList<>();; //lista estatica para hacer referencia a data directamente

    public static Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.101:3000")
            .addConverterFactory(GsonConverterFactory.create()).build();
}
