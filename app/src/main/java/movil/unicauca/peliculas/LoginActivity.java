package movil.unicauca.peliculas;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import movil.unicauca.peliculas.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setHandler(this); //Se le asigna un valor a handler

    }

    public void goToMain(){
        //region obtener informacion del TextInputLayout
        String usr = binding.usuario.getEditText().toString();
        String pass = binding.pass.toString().toString();
        //endregion

        Log.i("Peliculas", "Usr:"+usr+" Pass:"+pass);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToRegistro(){
        //region obtener informacion del TextInputLayout
        String usr = binding.usuario.getEditText().toString();
        String pass = binding.pass.toString().toString();
        //endregion

        Log.i("Peliculas", "Usr:"+usr+" Pass:"+pass);

        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }
}
