package movil.unicauca.peliculas;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import movil.unicauca.peliculas.databinding.ActivityDetailBinding;
import movil.unicauca.peliculas.models.Estrenos;
import movil.unicauca.peliculas.util.Data;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POS = "´pos"; ////variable constante, por convencion empieza con EXTRA

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);



        //recupera la posicion
        int pos =  getIntent().getExtras().getInt(EXTRA_POS);
        Estrenos estrenos = Data.data.get(pos);

        binding.setEstrenos(estrenos);
    }
}
