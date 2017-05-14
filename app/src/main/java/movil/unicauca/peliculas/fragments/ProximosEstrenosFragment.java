package movil.unicauca.peliculas.fragments;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import movil.unicauca.peliculas.Detail2Activity;
import movil.unicauca.peliculas.R;
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
        pe1.setNombre(getString(R.string.colossal));
        pe1.setFecha_estreno(getString(R.string.mayo18));
        pe1.setImagen(getString(R.string.imgcolosal));
        pe1.setDuracion(getString(R.string.minutos110));

        ProximosEstrenos pe2 = new ProximosEstrenos();
        pe1.setNombre(getString(R.string.mom));
        pe1.setFecha_estreno(getString(R.string.mayo18));
        pe1.setImagen(getString(R.string.imgmom));
        pe1.setDuracion(getString(R.string.minutos78));

        ProximosEstrenos pe3 = new ProximosEstrenos();
        pe1.setNombre(getString(R.string.huye));
        pe1.setFecha_estreno(getString(R.string.mayo18));
        pe1.setImagen(getString(R.string.imghuye));
        pe1.setDuracion(getString(R.string.unahora44min));

        ProximosEstrenos pe4 = new ProximosEstrenos();
        pe1.setNombre(getString(R.string.rapidoypeludo));
        pe1.setFecha_estreno(getString(R.string.junio1));
        pe1.setImagen(getString(R.string.imgrapidoypeludo));
        pe1.setDuracion(getString(R.string.minutos90));

        ProximosEstrenos pe5 = new ProximosEstrenos();
        pe1.setNombre(getString(R.string.mujermaravilla));
        pe1.setFecha_estreno(getString(R.string.junio1));
        pe1.setImagen(getString(R.string.imgmujermaravilla));
        pe1.setDuracion(getString(R.string.minutos120));

        ProximosEstrenos pe6 = new ProximosEstrenos();
        pe1.setNombre(getString(R.string.lamomia));
        pe1.setFecha_estreno(getString(R.string.junio8));
        pe1.setImagen(getString(R.string.imglamomia));
        pe1.setDuracion(getString(R.string.minutos120));

        ProximosEstrenos pe7 = new ProximosEstrenos();
        pe1.setNombre(getString(R.string.guardianesbahia));
        pe1.setFecha_estreno(getString(R.string.junio15));
        pe1.setImagen(getString(R.string.imggaurdianesbahia));
        pe1.setDuracion(getString(R.string.minutos120));

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
