package movil.unicauca.peliculas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import movil.unicauca.peliculas.db.DbHelper;
import movil.unicauca.peliculas.session.Session;

public class LoginActivity extends AppCompatActivity implements OnClickListener {

    //ActivityLoginBinding binding;
    //SharedPreferences preferences;
    private DbHelper dbHelper;
    private EditText user, password;
    private Session session;
    private Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DbHelper(this);
        session = new Session(this);

        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.btnlogin);
        login.setOnClickListener(this);

        register = (Button) findViewById(R.id.btnregister);
        register.setOnClickListener(this);

        if(session.loggedin()){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
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

    private void login(){
        String usuario = user.getText().toString();
        String pass = password.getText().toString();

        if (dbHelper.getUser(usuario, pass)){
            session.setLoggedin(true);
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        else {
            Toast.makeText(getApplicationContext(), "Usuario/Contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }


    //region comentar
    /*public void goToMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void goToRegistro(){
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }*/
    //endregion
}
