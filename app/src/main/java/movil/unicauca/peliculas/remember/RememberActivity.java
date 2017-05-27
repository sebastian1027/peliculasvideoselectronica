package movil.unicauca.peliculas.remember;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import movil.unicauca.peliculas.AddActivity;
import movil.unicauca.peliculas.App;
import movil.unicauca.peliculas.R;
import movil.unicauca.peliculas.adapter.RecordarAdapter;
import movil.unicauca.peliculas.databinding.ActivityRememberBinding;
import movil.unicauca.peliculas.models.Recordar;
import movil.unicauca.peliculas.models.RecordarDao;

public class RememberActivity extends AppCompatActivity {

    ActivityRememberBinding binding;
    RecordarAdapter adapter;

    RecordarDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_remember);
        List<Recordar> data = new ArrayList<>();
        adapter = new RecordarAdapter(getLayoutInflater(), data);
        binding.list.setAdapter(adapter);

        dao = ((App)getApplication()).session.getRecordarDao();
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Recordar> data = dao.loadAll();
        adapter.setData(data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recordatorio, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
