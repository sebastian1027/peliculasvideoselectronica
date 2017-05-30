package movil.unicauca.peliculas.remember;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import movil.unicauca.peliculas.AddActivity;
import movil.unicauca.peliculas.App;
import movil.unicauca.peliculas.MainActivity;
import movil.unicauca.peliculas.R;
import movil.unicauca.peliculas.adapter.RecordarAdapter;
import movil.unicauca.peliculas.databinding.ActivityRememberBinding;
import movil.unicauca.peliculas.models.Recordar;
import movil.unicauca.peliculas.models.RecordarDao;

public class RememberActivity extends AppCompatActivity{ // implements View.OnClickListener {

    ActivityRememberBinding binding;
    RecordarAdapter adapter;

    RecordarDao dao;

    //Button btnfecha, btnhora;
    //EditText fecha, hora;

    //private int dia, mes, anio, horaa, minutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_remember);
        List<Recordar> data = new ArrayList<>();
        adapter = new RecordarAdapter(getLayoutInflater(), data);
        binding.list.setAdapter(adapter);

        dao = ((App)getApplication()).session.getRecordarDao();

        /*btnfecha = (Button)findViewById(R.id.btnfecha);
        btnhora = (Button) findViewById(R.id.btnhora);

        fecha = (EditText) findViewById(R.id.Fecha);
        hora = (EditText) findViewById(R.id.Hora);

        btnfecha.setOnClickListener(this);
        btnhora.setOnClickListener(this);*/


        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // esta linea es para crear la flecha hacia atras

    }


    @Override
    protected void onResume() {
        super.onResume();
        List<Recordar> data = dao.loadAll();
        adapter.setData(data);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recordatorio, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    /*
    @Override
    public void onClick(View v) {
        if (v == btnfecha){
            //instancia de la clase calendar
            final Calendar calendar = Calendar.getInstance();
            dia = calendar.get(Calendar.DAY_OF_MONTH);
            mes = calendar.get(Calendar.MONTH);
            anio = calendar.get(Calendar.YEAR);

            //Intancia de la clase DATEPINKER

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }

            } ,dia, mes, anio);
            datePickerDialog.show();
        }
        if (v == btnhora){
            //instancia de la clase Calendar
            final Calendar calendar = Calendar.getInstance();
            horaa = calendar.get(Calendar.HOUR_OF_DAY);
            minutos = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    hora.setText(hourOfDay+":"+ minute);
                }
            }, horaa, minutos, false);
            timePickerDialog.show();

        }
    }*/
}
