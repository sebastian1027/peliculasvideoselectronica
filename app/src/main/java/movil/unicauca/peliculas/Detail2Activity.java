package movil.unicauca.peliculas;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import movil.unicauca.peliculas.databinding.ActivityDetail2Binding;
import movil.unicauca.peliculas.models.ProximosEstrenos;
import movil.unicauca.peliculas.util.Datape;

public class Detail2Activity extends AppCompatActivity {

    public static final String EXTRA_POS = "´pos"; //variable constante
    ActivityDetail2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail2);

        //recupera la posicion
        int pos =  getIntent().getExtras().getInt(EXTRA_POS);
        ProximosEstrenos  proxE = Datape.data.get(pos);

        binding.setProEx(proxE);
    }
}
