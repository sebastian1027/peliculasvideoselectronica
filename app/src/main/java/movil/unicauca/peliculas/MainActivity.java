package movil.unicauca.peliculas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import movil.unicauca.peliculas.adapter.EstrenosAdapter;
import movil.unicauca.peliculas.databinding.ActivityMainBinding;
import movil.unicauca.peliculas.fragments.CalificationFragment;
import movil.unicauca.peliculas.fragments.ProximosEstrenosFragment;
import movil.unicauca.peliculas.fragments.RememberFragment;
import movil.unicauca.peliculas.models.Estrenos;
import movil.unicauca.peliculas.util.Data;

public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, EstrenosAdapter.OnEstrenosListener, NavigationView.OnNavigationItemSelectedListener {

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
        e1.setDuracion(getString(R.string.minutes160));
        e1.setClasificacion(getString(R.string.oldyeras12));
        e1.setSinopsis(getString(R.string.sinopsisrapidosyfuriosos));
        e1.setGenero1(getString(R.string.action));
        e1.setGenero2(getString(R.string.fiction));
        e1.setPrecio(getString(R.string.docemil));

        Estrenos e2 = new Estrenos();
        e2.setNombre(getString(R.string.unjefe));
        e2.setFecha(getString(R.string.abril28));
        e2.setImagen(getString(R.string.imgunjefe));
        e2.setDuracion(getString(R.string.duracionunjefe));
        e2.setClasificacion(getString(R.string.allpeople));
        e2.setSinopsis(getString(R.string.sinopsisunjefe));
        e2.setGenero1(getString(R.string.animation));
        e2.setGenero2(getString(R.string.comedy));
        e2.setPrecio(getString(R.string.diezmil));


        Estrenos e3 = new Estrenos();
        e3.setNombre(getString(R.string.diadelatentado));
        e3.setFecha(getString(R.string.mayo3));
        e3.setImagen(getString(R.string.imgdiadelatentado));
        e3.setDuracion(getString(R.string.minutos130));
        e3.setClasificacion(getString(R.string.docemil));
        e3.setSinopsis(getString(R.string.sinopsisdiadelatentado));
        e3.setGenero1(getString(R.string.action));
        e3.setGenero2(getString(R.string.drama));
        e3.setPrecio(getString(R.string.ochomil));

        Estrenos e4 = new Estrenos();
        e4.setNombre(getString(R.string.nuncadigassunombre));
        e4.setFecha(getString(R.string.mayo3));
        e4.setImagen(getString(R.string.imgnuncadigas));
        e4.setDuracion(getString(R.string.minutos96));
        e4.setClasificacion(getString(R.string.oldyeras12));
        e4.setSinopsis(getString(R.string.sinopsisnuncadigas));
        e4.setGenero1(getString(R.string.terror));
        e4.setGenero2(getString(R.string.Supernatural));
        e4.setPrecio(getString(R.string.oldyeras12));

        Estrenos e5 = new Estrenos();
        e5.setNombre(getString(R.string.lospitufos));
        e5.setFecha(getString(R.string.mayo1));
        e5.setImagen(getString(R.string.imglospitufos));
        e5.setDuracion(getString(R.string.minutos89));
        e5.setClasificacion(getString(R.string.allpeople));
        e5.setSinopsis(getString(R.string.sinopsispitufos));
        e5.setGenero1(getString(R.string.animation));
        e5.setGenero2(getString(R.string.adventure));
        e5.setPrecio(getString(R.string.docemil));

        Estrenos e6 = new Estrenos();
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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_nav, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (id == R.id.nav_proxEstre){
            fragmentManager.beginTransaction().replace(R.id.templateestrenos, new ProximosEstrenosFragment()).commit();
        }
        if (id == R.id.nav_calificarpeliculas){
            fragmentManager.beginTransaction().replace(R.id.calification, new CalificationFragment()).commit();
        }
        if (id == R.id.nav_recordatorios){
            fragmentManager.beginTransaction().replace(R.id.remember, new RememberFragment()).commit();
        }
        if (id == R.id.nav_salir){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        return true; //o return false -> este es por defecto
    }
}
