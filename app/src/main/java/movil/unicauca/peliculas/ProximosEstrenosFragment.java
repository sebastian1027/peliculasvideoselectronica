package movil.unicauca.peliculas;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import movil.unicauca.peliculas.adapter.ProximosEstrenosAdapter;
import movil.unicauca.peliculas.databinding.FragmentProximosEstrenosBinding;
import movil.unicauca.peliculas.models.ProximosEstrenos;
import movil.unicauca.peliculas.util.Datape;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProximosEstrenosFragment extends Fragment implements ProximosEstrenosAdapter.OnProximosEstrenosListener{



    FragmentProximosEstrenosBinding binding;
    ProximosEstrenosAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_proximos_estrenos, container, false);

        Datape.data = new ArrayList<>();

        adapter = new ProximosEstrenosAdapter(getLayoutInflater(null), this); //se instancia el adapter
        binding.recycler.setAdapter(adapter); //el recyclerView sabe que va en que posicion
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext())); //el LayoutManagersirve para organizar los elementos
        // en pantalla es decir en que posicion
        loadDatape();
        return binding.getRoot();
    }

    //region loadDatape
    private void loadDatape(){

        ProximosEstrenos pe1 = new ProximosEstrenos();
        pe1.setNombre("Colossal");
        pe1.setFecha_estreno("18 de Mayo");
        pe1.setImagen("http://www.asturscore.com/wp-content/uploads/2017/04/Colossal.jpg");
        pe1.setDuracion("110 minutos");

        ProximosEstrenos pe2 = new ProximosEstrenos();
        pe1.setNombre("Mamá");
        pe1.setFecha_estreno("18 de Mayo");
        pe1.setImagen("https://s-media-cache-ak0.pinimg.com/736x/55/07/df/5507df006cb8451be78d704df99ae93e.jpg");
        pe1.setDuracion("78 minutos");

        ProximosEstrenos pe3 = new ProximosEstrenos();
        pe1.setNombre("Huye!");
        pe1.setFecha_estreno("18 de Mayo");
        pe1.setImagen("http://www.cinevistablog.com/wp-content/uploads/2017/04/huye-get-out-pelicula-de-horror-y-misterio-exito-de-taquilla-y-en-sundance_opt2_.jpg");
        pe1.setDuracion("1 hora 44 minutos");

        ProximosEstrenos pe4 = new ProximosEstrenos();
        pe1.setNombre("Rapido y Peludo");
        pe1.setFecha_estreno("1 de Junio");
        pe1.setImagen("http://p2.trrsf.com/image/fget/cf/thumbox-ttv.terra.com/video/58dab9ce2735ba1f2f8d0fea.jpg");
        pe1.setDuracion("90 minutos");

        ProximosEstrenos pe5 = new ProximosEstrenos();
        pe1.setNombre("La Mujer Maravilla");
        pe1.setFecha_estreno("1 de Junio");
        pe1.setImagen("http://media.ultimahora.com/adjuntos/161/imagenes/003/328/0003328988.jpg");
        pe1.setDuracion("120 minutos");

        ProximosEstrenos pe6 = new ProximosEstrenos();
        pe1.setNombre("La Momia");
        pe1.setFecha_estreno("8 de Junio");
        pe1.setImagen("https://1.bp.blogspot.com/-bfnPczu2DhM/WEU_M1EdIfI/AAAAAAABD1I/FuYrO24IMsAEWcVtUGIB5DQGSnMSblsVACLcB/s1600/trailer-momia-2017.jpg");
        pe1.setDuracion("120 Minutos");

        ProximosEstrenos pe7 = new ProximosEstrenos();
        pe1.setNombre("Guardianes de la Bahia");
        pe1.setFecha_estreno("15 de Junio");
        pe1.setImagen("https://cinemedios.files.wordpress.com/2016/12/baywatch-2017-cast-trailer-article.png");
        pe1.setDuracion("120 Minutos");

        Datape.data.add(pe1);
        Datape.data.add(pe2);
        Datape.data.add(pe3);
        Datape.data.add(pe4);
        Datape.data.add(pe5);
        Datape.data.add(pe6);
        Datape.data.add(pe7);



        adapter.notifyDataSetChanged();

    }

    @Override
    public void onProximosEstrenos(View v) {
        int pos = binding.recycler.getChildAdapterPosition(v);
        Intent intent = new Intent(getContext(), Detail2Activity.class);
        intent.putExtra(Detail2Activity.EXTRA_POS, pos);
        startActivity(intent);
    }

    //endregion

}
