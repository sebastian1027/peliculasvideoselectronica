package movil.unicauca.peliculas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import movil.unicauca.peliculas.databinding.ActivityLoginBinding;
import movil.unicauca.peliculas.db.DbHelper;
import movil.unicauca.peliculas.models.SimpleResponse;
import movil.unicauca.peliculas.models.User;
import movil.unicauca.peliculas.net.UserService;
import movil.unicauca.peliculas.session.Session;
import movil.unicauca.peliculas.util.Data;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements OnClickListener {

    ActivityLoginBinding binding;
    UserService service;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        boolean logged = preferences.getBoolean("logged", false);
        if (logged){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("logged", true);
            editor.putString("usuario", usuario);
            editor.putString("password", password);
            editor.apply();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setHandler(this);

        service = Data.retrofit.create(UserService.class);

        //region comentar
        //dbHelper = new DbHelper(this);
        //session = new Session(this);

        /*user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.btnlogin);
        login.setOnClickListener(this);

        register = (Button) findViewById(R.id.btnregister);
        register.setOnClickListener(this);

        if(session.loggedin()){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }*/

        //preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        //boolean logged = preferences
        //endregion
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnlogin:
                login();
                break;
            case R.id.btnregister:
                startActivity(new Intent(LoginActivity.this, RegistroActivity.class));
                break;
        }
    }

    public void goToRegister(){
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }

    public void login(){
        final String usuario = binding.user.getText().toString();
        String pass = binding.password.getText().toString();


        User userr = new User(usuario, pass);

        Call<SimpleResponse> request = service.login(userr);
        request.enqueue(new Callback<SimpleResponse>() {
            @Override
            public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
                if (response.isSuccessful()){
                    SimpleResponse res = response.body();
                    if (res.isSuccess()){
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(LoginActivity.this, res.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<SimpleResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error al conectarse", Toast.LENGTH_SHORT).show();
            }
        });

        //region comentar
        /*if (dbHelper.getUser(usuario, pass)){
            session.setLoggedin(true);
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        else {
            Toast.makeText(getApplicationContext(), R.string.userpassworng, Toast.LENGTH_SHORT).show();
        }*/
        //endregion
    }

}
