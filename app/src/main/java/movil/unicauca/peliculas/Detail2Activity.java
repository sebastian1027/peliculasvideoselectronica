package movil.unicauca.peliculas;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import movil.unicauca.peliculas.databinding.ActivityDetail2Binding;
import movil.unicauca.peliculas.models.ProximosEstrenos;
import movil.unicauca.peliculas.remember.RememberActivity;
import movil.unicauca.peliculas.util.Data;
import android.view.View.OnClickListener;

public class Detail2Activity extends AppCompatActivity implements ViewTreeObserver.OnGlobalLayoutListener, OnClickListener {

    public static final String EXTRA_POS = "pos"; //variable constante

    ActivityDetail2Binding binding;
    private Button btnrember;

    public TextView viewDatos;

    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail2);
        setSupportActionBar(binding.toolbar1);                  //
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // estas 2 lineas es para crear la flecha hacia atras

        //recupera la posicion
        pos =  getIntent().getExtras().getInt(EXTRA_POS);
        ProximosEstrenos  proxE = Data.datape.get(pos);

        binding.setProEx(proxE);
        binding.getRoot().getViewTreeObserver().addOnGlobalLayoutListener(this); // el getViewTreeObserver() puede utilizarse para obtener notificaciones cuando suceden eventos globales, como el diseño.

        btnrember = (Button) findViewById(R.id.btnrember);
        btnrember.setOnClickListener(this);

        viewDatos = (TextView) findViewById(R.id.ViewNameMovie);
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

    public void onClick(View view){
        switch (view.getId()){

            case R.id.btnrember:

                Intent intent;
                intent = new Intent(getApplicationContext(), AddActivity.class);
                intent.putExtra("DATOS", pos);
                startActivity(intent);


                //Intent intent = new Intent(Detail2Activity.this, AddActivity.class);
                //startActivity(intent);
                finish();
                break;

            default: break;
        }

    }
}
