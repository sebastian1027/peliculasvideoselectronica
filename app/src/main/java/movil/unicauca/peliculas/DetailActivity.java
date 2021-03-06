package movil.unicauca.peliculas;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.MenuItem;
import android.view.ViewTreeObserver;

import movil.unicauca.peliculas.databinding.ActivityDetailBinding;
import movil.unicauca.peliculas.models.Cartelera;
import movil.unicauca.peliculas.util.Data;

public class DetailActivity extends AppCompatActivity implements ViewTreeObserver.OnGlobalLayoutListener {

    public static final String EXTRA_POS = "pos"; ////variable constante, por convencion empieza con EXTRA

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //recupera la posicion
        int pos =  getIntent().getExtras().getInt(EXTRA_POS);
        Cartelera cartelera = Data.data.get(pos);

        binding.setCartelera(cartelera);
        binding.getRoot().getViewTreeObserver().addOnGlobalLayoutListener(this);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);  // pone la flecha hacia atras en la parte superior izquierda
    }

    @Override
    protected void onResume() {
        super.onResume();


    }


    @Override
    public void onGlobalLayout() {
        BitmapDrawable drawable = (BitmapDrawable) binding.imgE.getDrawable(); //obtenemos el Bitmap del imageView
        Palette p = Palette.from(drawable.getBitmap()).generate(); // con el bitmap obtenemos el palette

        int colorDefault = ContextCompat.getColor(this, R.color.colorPrimary);
        binding.collapsingBarE.setContentScrimColor(p.getVibrantColor(colorDefault)); //obtenemos el color vibrante,
                                                                                     // si no lo hay poenmos un color por defecto
    }

}
