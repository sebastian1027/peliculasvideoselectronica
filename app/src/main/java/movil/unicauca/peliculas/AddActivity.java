package movil.unicauca.peliculas;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import movil.unicauca.peliculas.databinding.ActivityAddBinding;
import movil.unicauca.peliculas.models.ProximosEstrenos;
import movil.unicauca.peliculas.models.Recordar;
import movil.unicauca.peliculas.models.RecordarDao;
import movil.unicauca.peliculas.util.Data;


public class AddActivity extends AppCompatActivity {

    ActivityAddBinding binding;
    RecordarDao dao;

    public TextView txtPeliculaRecibida;
    public String recibiendoPelicula;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add);
        binding.setHandler(this);
        dao = ((App)getApplication()).session.getRecordarDao();
                          //
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // esta linea es para crear la flecha hacia atras

        int pos =  getIntent().getExtras().getInt("DATOS");
        ProximosEstrenos proxE = Data.datape.get(pos);

        binding.txtPeliculaRecibida.setText(proxE.getNombre());
        binding.txtFechaRecibida.setText(proxE.getFecha_estreno());
        binding.txtPrecioRecibido.setText(proxE.getPrecio());


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);  // pone la flecha hacia atras en la parte superior izquierda
    }

    public void save (){
        String namepel = binding.txtPeliculaRecibida.getText().toString();
        String fecha = binding.txtFechaRecibida.getText().toString();
        String precio = binding.txtPrecioRecibido.getText().toString();

        Recordar recordar = new Recordar();
        recordar.setNombrePelcula(namepel);
        recordar.setFechaEstreno(fecha);
        recordar.setPrecio(precio);

        dao.insert(recordar);
        finish();

        Toast.makeText(this, R.string.tupeliculaseagregoarecuerdos, Toast.LENGTH_LONG).show();

    }


}
