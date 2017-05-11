package movil.unicauca.peliculas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import movil.unicauca.peliculas.databinding.ActivityRegistroBinding;

public class RegistroActivity extends AppCompatActivity {

    ActivityRegistroBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registro);
        binding.setHandler(this); //Se le asigna un valor a handler
    }

    public void goToLogin(){

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);

    }
    }


