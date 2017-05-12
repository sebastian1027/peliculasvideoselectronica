package movil.unicauca.peliculas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import movil.unicauca.peliculas.adapter.EstrenosAdapter;
import movil.unicauca.peliculas.databinding.ActivityMainBinding;
import movil.unicauca.peliculas.models.Estrenos;
import movil.unicauca.peliculas.util.Data;

public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, EstrenosAdapter.OnEstrenosListener {

    ActivityMainBinding binding;
    ActionBarDrawerToggle toggle;
    EstrenosAdapter adapter; //declaracion del adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Primer paso: Mostrar el boton hacia atras
        //Segun paso: instanciar el toggle

        toggle = new ActionBarDrawerToggle(this, binding.drawer, R.string.menu_open, R.string.menu_cerrado);

        binding.drawer.addDrawerListener(this);

        Data.data = new ArrayList<>();

        adapter = new EstrenosAdapter(getLayoutInflater(), this); //se instancia el adapter
        binding.recycler.setAdapter(adapter); //el recycerView sabe que va en que posicion
        binding.recycler.setLayoutManager(new LinearLayoutManager(this)); //el LayoutManagersirve para organizar los elementos
                                                                            // en pantalla es decir en que posicion

        loadData();
    }

    private void loadData(){

        Estrenos e1 = new Estrenos();
        e1.setNombre(getString(R.string.fastandthefurious));
        e1.setFecha(getString(R.string.may2));
        e1.setImagen(getString(R.string.imagee1));
        e1.setDuracion(getString(R.string.minutes120));

        Estrenos e2 = new Estrenos();
        e2.setNombre("un jefe en pañales");
        e2.setFecha("28 de abril de 2017");
        e2.setImagen("http://tbsila.cdn.turner.com/tbsila/tntla/images/10192/451637/g/the-boss-baby-poster.jpg");
        e2.setDuracion("100 minutos");

        Estrenos e3 = new Estrenos();
        e3.setNombre("Día del Atentado");
        e3.setFecha("3 mayo de 2017");
        e3.setImagen("https://i.ytimg.com/vi/0mNlbE-yD_8/hqdefault.jpg");
        e3.setDuracion("120 minutos");

        Estrenos e4 = new Estrenos();
        e4.setNombre("nunca digas su nombre");
        e4.setFecha("mayo de 2017");
        e4.setImagen("http://newcinema.es/imagenes/2016/09/nunca-digas-su-nombre-cartel.jpg");
        e4.setDuracion("140 minutos");

        Estrenos e5 = new Estrenos();
        //e5.setName((.getString(R.string.pitufos));
        e5.setNombre("Los pitufos");
        e5.setFecha("mayo de 2017");
        e5.setImagen("https://www.mujeresnegocios.com/wp-content/uploads/2017/04/2017-los-pitufos-la-aldea-escondida.jpg");
        e5.setDuracion("130 minutos");

        Estrenos e6 = new Estrenos();
        e6.setNombre("el cielo espera");
        e6.setFecha("mayo de 2017");
        e6.setImagen("http://1.bp.blogspot.com/-yMiWlB8zNZ0/VQW9Y3atoFI/AAAAAAAAGPY/XsxltLmkHPs/w1200-h630-p-k-no-nu/el_cielo_espera.jpg");
        e6.setDuracion("100 minutos");

        Data.data.add(e1);
        Data.data.add(e2);
        Data.data.add(e3);
        Data.data.add(e4);
        Data.data.add(e5);
        Data.data.add(e6);

        adapter.notifyDataSetChanged();
    }

    //region toggle Menu
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState(); //se boton de 3 lineas es visible en pantalla
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item); //Se abre y se cierra el drawer menu
    }



    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        toggle.onDrawerSlide(drawerView, slideOffset);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        toggle.onDrawerOpened(drawerView);
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        toggle.onDrawerClosed(drawerView);
    }

    @Override
    public void onDrawerStateChanged(int newState) {
        toggle.onDrawerStateChanged(newState);

    }


    //endregion

    @Override
    public void onEstreno(View v) {
        int pos = binding.recycler.getChildAdapterPosition(v);

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_POS, pos); //manda informacion al activity, dependiendo de cual se cardView se pulse
        startActivity(intent);
    }
}
