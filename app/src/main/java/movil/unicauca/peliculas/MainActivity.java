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
        e1.setDuracion(getString(R.string.minutes160));
        e1.setClasificacion("Mayores de 12 años");
        e1.setSinopsis("Justo cuando Dom y Letty celebran su luna de miel, Brian y Mia se han retirado del juego y el resto del equipo se ha desintegrado en busca de una vida común y corriente; una misteriosa mujer intentará seducir a Dom para convencerlo de regresar a la vida criminal que tanto lo acecha, traicionando a quienes lo rodean y enfrentándose a retos nunca antes vistos. Desde la costa cubana pasando por las calles de Nueva York y hasta el helado Ártico, el equipo deberá cruzar el mundo para detener a una anarquista y evitar un desastre mundial trayendo de vuelta a casa al hombre que los convirtió en una familia.");
        e1.setGenero1("Acción");
        e1.setGenero2("Ficción");
        e1.setPrecio("$12.000");

        Estrenos e2 = new Estrenos();
        e2.setNombre("un jefe en pañales");
        e2.setFecha("28 de abril de 2017");
        e2.setImagen("http://tbsila.cdn.turner.com/tbsila/tntla/images/10192/451637/g/the-boss-baby-poster.jpg");
        e2.setDuracion("1 hora 36 minutos");
        e2.setClasificacion("Apta para todo Público");
        e2.setSinopsis("Conoce al bebé más inusual, Usa traje. Un Jefe en Pañales es una historia universal e hilarante acerca de cómo la llegada de un nuevo bebé impacta a una familia, contada desde la perspectiva de un narrador poco fiable, pero encantador: Tim, un niño de siete años, de mente desenfrenada e imaginativa. Con un mensaje pícaro, pero conmovedor, acerca de la importancia de la familia.");
        e2.setGenero1("Animacion");
        e2.setGenero2("Comedia");
        e2.setPrecio("$10.000");


        Estrenos e3 = new Estrenos();
        e3.setNombre("Día del Atentado");
        e3.setFecha("3 mayo de 2017");
        e3.setImagen("https://i.ytimg.com/vi/0mNlbE-yD_8/hqdefault.jpg");
        e3.setDuracion("130 minutos");
        e3.setClasificacion("Mayores de 12 años");
        e3.setSinopsis("DÍA DEL ATENTADO es la reconstrucción del atentado de Boston de 2013 y un homenaje a los héroes cotidianos que inspiraron al mundo en las extraordinarias horas que siguieron. A raíz de un acto de terrorista, el sargento de policía Tommy Saunders (Mark Wahlberg) se une a valientes sobrevivientes, socorristas e investigadores en una carrera contra reloj para atrapar a los bombarderos antes de que ataquen de nuevo. Junto a las historias del Agente Especial Richard Deslauriers (Kevin Bacon); el Comisionado de Policía Ed Davis (John Goodman); el Sargento Jeffrey Pugliese (JK Simmons) y la enfermera Carol Saunders (Michelle Monaghan), esta crónica visceral e inquebrantable captura la intensidad y el suspenso de un suceso que atrapó al mundo.");
        e3.setGenero1("Acción");
        e3.setGenero2("Drama");
        e3.setPrecio("$8.000");

        Estrenos e4 = new Estrenos();
        e4.setNombre("nunca digas su nombre");
        e4.setFecha("mayo de 2017");
        e4.setImagen("http://newcinema.es/imagenes/2016/09/nunca-digas-su-nombre-cartel.jpg");
        e4.setDuracion("96 minutos");
        e4.setClasificacion("Mayores de 12 años");
        e4.setSinopsis("Cuando tres estudiantes universitarios se mudan a una vieja casa fuera del campus, sin querer, liberan a \"Bye Bye Man\", un ente sobrenatural que persigue a quien descubre su nombre. Intentarán mantener su existencia en secreto para alejar al resto de una muerte segura.");
        e4.setGenero1("Terror");
        e4.setGenero2("Sobrenatural");
        e4.setPrecio("$12.000");

        Estrenos e5 = new Estrenos();
        e5.setNombre("Los pitufos");
        e5.setFecha("1 de mayo de 2017");
        e5.setImagen("https://www.mujeresnegocios.com/wp-content/uploads/2017/04/2017-los-pitufos-la-aldea-escondida.jpg");
        e5.setDuracion("89 minutos");
        e5.setClasificacion("Para todo el público");
        e5.setSinopsis("Pitufina y sus hermanos practican senderismo por el desconocido Bosque Encantado tratando de encontrar un legendario pueblo para los Pitufos. Deben hacerlo antes de que su némesis, el malvado mago Gargamel, lo haga. Durante el camino, algunos de los misterios de los Pitufos empiezan a salir a la luz.");
        e5.setGenero1("Animación");
        e5.setGenero2("Aventura");
        e5.setPrecio("$12.000");

        Estrenos e6 = new Estrenos();
        e6.setNombre("Guardianes de la Galaxia 2");
        e6.setFecha("27 de abril de 2017");
        e6.setImagen("https://www.findelahistoria.com/web/wp-content/uploads/2017/01/guardianes-de-la-galaxia-1.jpg");
        e6.setDuracion("120 minutos");
        e6.setClasificacion("Para todo el Público");
        e6.setSinopsis("Sinopsis:Ambientada en el nuevo contexto sonoro de “Awesome Mixtape #2”, GUARDIANES DE LA GALAXIA VOL. 2, de Marvel, continúa las aventuras del equipo en su travesía por los confines del cosmos. Los Guardianes deberán luchar para mantener unida a su nueva familia mientras intentan desentrañar el misterio del verdadero linaje de Peter Quill. Viejos rivales se convertirán en nuevos aliados y los personajes favoritos de los cómics clásicos acudirán en ayuda de nuestros héroes a medida que el Universo Cinematográfico de Marvel continúa expandiéndose.");
        e6.setGenero1("Acción");
        e6.setGenero2("Aventura");
        e6.setPrecio("$14.000");

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
