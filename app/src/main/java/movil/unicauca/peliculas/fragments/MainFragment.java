package movil.unicauca.peliculas.fragments;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import movil.unicauca.peliculas.AddEstrenoActivity;
import movil.unicauca.peliculas.DetailActivity;
import movil.unicauca.peliculas.R;
import movil.unicauca.peliculas.adapter.EstrenosAdapter;
import movil.unicauca.peliculas.databinding.FragmentMainBinding;
import movil.unicauca.peliculas.models.Cartelera;
import movil.unicauca.peliculas.net.CarteleraService;
import movil.unicauca.peliculas.util.Data;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainFragment extends Fragment implements EstrenosAdapter.OnEstrenosListener {

    public static MainFragment instace(){
        return new MainFragment();
    }

    FragmentMainBinding binding;
    EstrenosAdapter adapter; //declaracion del adapter


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        adapter = new EstrenosAdapter(getLayoutInflater(null), this); //se instancia el adapter
        binding.recycler.setAdapter(adapter); //el recycerView sabe que va en que posicion
        binding.recycler.setLayoutManager(new LinearLayoutManager(getActivity())); //el LayoutManagersirve para organizar los elementos
        // en pantalla es decir en que posicion
        loadData();
        return binding.getRoot();


    }

    private void loadData(){

        Data.data.clear();

        Cartelera e1 = new Cartelera();
        e1.setNombre(getString(R.string.fastandthefurious));
        e1.setFecha(getString(R.string.may2));
        e1.setImagen(getString(R.string.imagee1));
        e1.setDuracion(getString(R.string.minutes160));
        e1.setClasificacion(getString(R.string.oldyeras12));
        e1.setSinopsis(getString(R.string.sinopsisrapidosyfuriosos));
        e1.setGenero1(getString(R.string.action));
        e1.setGenero2(getString(R.string.fiction));
        e1.setPrecio(getString(R.string.docemil));

        Cartelera e2 = new Cartelera();
        e2.setNombre(getString(R.string.unjefe));
        e2.setFecha(getString(R.string.abril28));
        e2.setImagen(getString(R.string.imgunjefe));
        e2.setDuracion(getString(R.string.duracionunjefe));
        e2.setClasificacion(getString(R.string.allpeople));
        e2.setSinopsis(getString(R.string.sinopsisunjefe));
        e2.setGenero1(getString(R.string.animation));
        e2.setGenero2(getString(R.string.comedy));
        e2.setPrecio(getString(R.string.diezmil));


        Cartelera e3 = new Cartelera();
        e3.setNombre(getString(R.string.diadelatentado));
        e3.setFecha(getString(R.string.mayo3));
        e3.setImagen(getString(R.string.imgdiadelatentado));
        e3.setDuracion(getString(R.string.minutos130));
        e3.setClasificacion(getString(R.string.docemil));
        e3.setSinopsis(getString(R.string.sinopsisdiadelatentado));
        e3.setGenero1(getString(R.string.action));
        e3.setGenero2(getString(R.string.drama));
        e3.setPrecio(getString(R.string.ochomil));

        Cartelera e4 = new Cartelera();
        e4.setNombre(getString(R.string.nuncadigassunombre));
        e4.setFecha(getString(R.string.mayo3));
        e4.setImagen(getString(R.string.imgnuncadigas));
        e4.setDuracion(getString(R.string.minutos96));
        e4.setClasificacion(getString(R.string.oldyeras12));
        e4.setSinopsis(getString(R.string.sinopsisnuncadigas));
        e4.setGenero1(getString(R.string.terror));
        e4.setGenero2(getString(R.string.Supernatural));
        e4.setPrecio(getString(R.string.oldyeras12));

        Cartelera e5 = new Cartelera();
        e5.setNombre(getString(R.string.lospitufos));
        e5.setFecha(getString(R.string.mayo1));
        e5.setImagen(getString(R.string.imglospitufos));
        e5.setDuracion(getString(R.string.minutos89));
        e5.setClasificacion(getString(R.string.allpeople));
        e5.setSinopsis(getString(R.string.sinopsispitufos));
        e5.setGenero1(getString(R.string.animation));
        e5.setGenero2(getString(R.string.adventure));
        e5.setPrecio(getString(R.string.docemil));

        Cartelera e6 = new Cartelera();
        e6.setNombre(getString(R.string.guardianesgalaxia));
        e6.setFecha(getString(R.string.abril27));
        e6.setImagen(getString(R.string.imgguardianesgal));
        e6.setDuracion(getString(R.string.minutos120));
        e6.setClasificacion(getString(R.string.allpeople));
        e6.setSinopsis(getString(R.string.sinopsisguardianes));
        e6.setGenero1(getString(R.string.action));
        e6.setGenero2(getString(R.string.adventure));
        e6.setPrecio(getString(R.string.catorcemil));

        Data.data.add(e1);
        Data.data.add(e2);
        Data.data.add(e3);
        Data.data.add(e4);
        Data.data.add(e5);
        Data.data.add(e6);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onEstreno(View v) {

        int pos = binding.recycler.getChildAdapterPosition(v); //El método getChildAdapterPosition(), nos indicarán la posición de una vista dentro del adaptador.
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_POS, pos); //manda informacion al activity, dependiendo de cual se cardView se pulse
        startActivity(intent);

    }


}
