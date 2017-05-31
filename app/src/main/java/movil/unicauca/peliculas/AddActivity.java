package movil.unicauca.peliculas;

import android.databinding.DataBindingUtil;
import android.databinding.adapters.AutoCompleteTextViewBindingAdapter;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import movil.unicauca.peliculas.databinding.ActivityAddBinding;
import movil.unicauca.peliculas.models.Recordar;
import movil.unicauca.peliculas.models.RecordarDao;

public class AddActivity extends AppCompatActivity {

    ActivityAddBinding binding;
    RecordarDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add);
        binding.setHandler(this);
        dao = ((App)getApplication()).session.getRecordarDao();
                          //
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // esta linea es para crear la flecha hacia atras

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);  // pone la flecha hacia atras en la parte superior izquierda
    }

    public void save (){
        String namepel = binding.nombrePelicula.getText().toString();
        String fecha = binding.Fecha.getText().toString();

        Recordar recordar = new Recordar();
        recordar.setNombrePelcula(namepel);
        recordar.setFechaEstreno(fecha);

        dao.insert(recordar);
        finish();

        Toast.makeText(this, R.string.tupeliculaseagregoarecuerdos, Toast.LENGTH_LONG).show();

    }


}
