package movil.unicauca.peliculas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import movil.unicauca.peliculas.databinding.ActivityMainBinding;
import movil.unicauca.peliculas.fragments.CalificationFragment;
import movil.unicauca.peliculas.fragments.MainFragment;
import movil.unicauca.peliculas.fragments.ProximosEstrenosFragment;

public class MainActivity extends AppCompatActivity implements DrawerLayout.DrawerListener, NavigationView.OnNavigationItemSelectedListener {

    ActivityMainBinding binding;
    ActionBarDrawerToggle toggle;

    //tercer video de calculadora: 28:07


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //Primer paso: Mostrar el boton hacia atras
        //Segun paso: instanciar el toggle

        toggle = new ActionBarDrawerToggle(this, binding.drawer, R.string.menu_open, R.string.menu_cerrado);

        binding.drawer.addDrawerListener(this);
        binding.nav.setNavigationItemSelectedListener(this);

        putFragment(MainFragment.instace());


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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.nav_proxEstre:
                putFragment(new ProximosEstrenosFragment());
                break;
            case R.id.nav_calificarpeliculas:
                putFragment(new CalificationFragment());
                break;
            case R.id.nav_recordatorios:
                putFragment(new RememberFragment());
                break;
            case R.id.nav_salir:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_Estre:
                putFragment(new MainFragment());
                break;
        }
        binding.drawer.closeDrawers();
        return true; //o return false -> este es por defecto
    }

    void putFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }
}
