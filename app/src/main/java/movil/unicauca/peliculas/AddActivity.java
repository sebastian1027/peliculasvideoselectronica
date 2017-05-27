package movil.unicauca.peliculas;

import android.databinding.DataBindingUtil;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
    }

    public void save (){
        String namepel = binding.nombrePelicula.getText().toString();
        String fecha = binding.Fecha.getText().toString();
        String hora = binding.Hora.getText().toString();

        Recordar recordar = new Recordar();
        recordar.setNombrePelcula(namepel);
        recordar.setFechaEstreno(fecha);
        recordar.setHora(hora);

        dao.insert(recordar);
        finish();
    }
}
