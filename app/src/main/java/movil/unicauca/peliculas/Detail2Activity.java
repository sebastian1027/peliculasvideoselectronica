package movil.unicauca.peliculas;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.MenuItem;
import android.view.ViewTreeObserver;

import movil.unicauca.peliculas.databinding.ActivityDetail2Binding;
import movil.unicauca.peliculas.models.ProximosEstrenos;
import movil.unicauca.peliculas.util.Data;

public class Detail2Activity extends AppCompatActivity implements ViewTreeObserver.OnGlobalLayoutListener {

    public static final String EXTRA_POS = "pos"; //variable constante

    ActivityDetail2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail2);
        setSupportActionBar(binding.toolbar1);                  //
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // estas 2 lineas es para crear la flecha hacia atras

        //recupera la posicion
        int pos =  getIntent().getExtras().getInt(EXTRA_POS);
        ProximosEstrenos  proxE = Data.datape.get(pos);

        binding.setProEx(proxE);
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
        BitmapDrawable drawable = (BitmapDrawable) binding.imgPE.getDrawable(); //obtenemos el Bitmap del imageView
        Palette p = Palette.from(drawable.getBitmap()).generate(); // con el bitmap obtenemos el palette

        int colorDefault = ContextCompat.getColor(this, R.color.colorPrimary);
        binding.collapsingBarPE.setContentScrimColor(p.getVibrantColor(colorDefault)); //obtenemos el color vibrante,
                                                                                     // si no lo hay poenmos un color por defecto
    }
}
