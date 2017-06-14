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
import movil.unicauca.peliculas.util.Data;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProximosEstrenosFragment extends Fragment implements ProximosEstrenosAdapter.OnProximosEstrenosListener{



    FragmentProximosEstrenosBinding binding;
    ProximosEstrenosAdapter adapter; //declaracion del adapter

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_proximos_estrenos, container, false);

        //Data.datape = new ArrayList<>();

        adapter = new ProximosEstrenosAdapter(getLayoutInflater(null), this); //se instancia el adapter
        binding.recycler.setAdapter(adapter); //el recyclerView sabe que va en que posicion
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext())); //el LayoutManagersirve para organizar los elementos
        // en pantalla es decir en que posicion

        loadDatape();
        return binding.getRoot();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    //region loadDatape
    private void loadDatape(){

        Data.datape.clear();

        ProximosEstrenos pe1 = new ProximosEstrenos();
        pe1.setNombre(getString(R.string.titlespiderman));
        pe1.setFecha_estreno(getString(R.string.july6));
        pe1.setImagen(getString(R.string.imgspiderman));
        pe1.setGenero1(getString(R.string.adventure));
        pe1.setGenero2(getString(R.string.action));
        pe1.setClasificacion(getString(R.string.allpeople));
        pe1.setSinopsis(getString(R.string.sinopsisspiderman));
        pe1.setDuracion(getString(R.string.minutos120));
        pe1.setPrecio(getString(R.string.docemil));

        ProximosEstrenos pe2 = new ProximosEstrenos();
        pe2.setNombre(getString(R.string.tittlethor));
        pe2.setFecha_estreno(getString(R.string.november2));
        pe2.setImagen(getString(R.string.imgthor));
        pe2.setGenero1(getString(R.string.action));
        pe2.setGenero2(getString(R.string.adventure));
        pe2.setClasificacion(getString(R.string.allpeople));
        pe2.setSinopsis(getString(R.string.sinopsisthor));
        pe2.setDuracion(getString(R.string.minutos100));
        pe2.setPrecio(getString(R.string.diezmil));



        ProximosEstrenos pe3 = new ProximosEstrenos();
        pe3.setNombre(getString(R.string.tittlemivillano));
        pe3.setFecha_estreno(getString(R.string.june29));
        pe3.setImagen(getString(R.string.imgmivillano));
        pe3.setGenero1(getString(R.string.comedy));
        pe3.setGenero2(getString(R.string.adventure));
        pe3.setClasificacion(getString(R.string.allpeople));
        pe3.setSinopsis(getString(R.string.sinopsisvillanofav3));
        pe3.setDuracion(getString(R.string.minutos120));
        pe3.setPrecio(getString(R.string.diezmil));



        ProximosEstrenos pe4 = new ProximosEstrenos();
        pe4.setNombre(getString(R.string.tittletransformers));
        pe4.setFecha_estreno(getString(R.string.july20));
        pe4.setImagen(getString(R.string.imgtransformers));
        pe4.setGenero1(getString(R.string.adventure));
        pe4.setGenero2(getString(R.string.action));
        pe4.setClasificacion(getString(R.string.allpeople));
        pe4.setSinopsis(getString(R.string.sinopsistransformers));
        pe4.setDuracion(getString(R.string.minutos130));
        pe4.setPrecio(getString(R.string.docemil));


        ProximosEstrenos pe5 = new ProximosEstrenos();
        pe5.setNombre(getString(R.string.tittleguardians));
        pe5.setFecha_estreno(getString(R.string.august31));
        pe5.setImagen(getString(R.string.imgguardians));
        pe5.setGenero1(getString(R.string.adventure));
        pe5.setGenero2(getString(R.string.sciencefiction));
        pe5.setClasificacion(getString(R.string.allpeople));
        pe5.setSinopsis(getString(R.string.sinopsisguardians));
        pe5.setDuracion(getString(R.string.minutos120));
        pe5.setPrecio(getString(R.string.ochomil));


        ProximosEstrenos pe6 = new ProximosEstrenos();
        pe6.setNombre(getString(R.string.tittlecondorito));
        pe6.setFecha_estreno(getString(R.string.october12));
        pe6.setImagen(getString(R.string.imgcondorito));
        pe6.setGenero1(getString(R.string.animation));
        pe6.setGenero2(getString(R.string.adventure));
        pe6.setClasificacion(getString(R.string.allpeople));
        pe6.setSinopsis(getString(R.string.sinopsiscondorito));
        pe6.setDuracion(getString(R.string.minutos100));
        pe6.setPrecio(getString(R.string.ochomil));

        ProximosEstrenos pe7 = new ProximosEstrenos();
        pe7.setNombre(getString(R.string.tittleit));
        pe7.setFecha_estreno(getString(R.string.september7));
        pe7.setImagen(getString(R.string.imgit));
        pe7.setGenero1(getString(R.string.terror));
        pe7.setGenero2(getString(R.string.monsters));
        pe7.setClasificacion(getString(R.string.oldyeras12));
        pe7.setSinopsis(getString(R.string.sinopsisit));
        pe7.setDuracion(getString(R.string.minutos130));
        pe7.setPrecio(getString(R.string.diezmil));


        Data.datape.add(pe1);
        Data.datape.add(pe2);
        Data.datape.add(pe3);
        Data.datape.add(pe4);
        Data.datape.add(pe5);
        Data.datape.add(pe6);
        Data.datape.add(pe7);


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
