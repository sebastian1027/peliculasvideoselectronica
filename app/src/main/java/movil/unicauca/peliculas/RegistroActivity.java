package movil.unicauca.peliculas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import movil.unicauca.peliculas.db.DbHelper;
import android.view.View.OnClickListener;

public class RegistroActivity extends AppCompatActivity implements OnClickListener {

    //ActivityRegistroBinding binding;
    private DbHelper dbHelper;
    private Button btnregistrate;
    private EditText edtnombre, edtapellido, edtemail, edtedad, edtusuario, edtcontrasenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        dbHelper = new DbHelper(this);
        btnregistrate = (Button) findViewById(R.id.btnregistrate);
        edtnombre = (EditText) findViewById(R.id.edtnombre);
        edtapellido = (EditText) findViewById(R.id.edtapellido);
        edtemail = (EditText) findViewById(R.id.edtemail);
        edtedad = (EditText) findViewById(R.id.edtedad);
        edtusuario = (EditText) findViewById(R.id.edtusuario);
        edtcontrasenia = (EditText) findViewById(R.id.edtcontrasenia);

        btnregistrate.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnregistrate:
                register();
                break;
        }
    }

    public void register(){
        String name = edtnombre.getText().toString();
        String pass = edtcontrasenia.getText().toString();
        String lastname = edtapellido.getText().toString();
        String email = edtemail.getText().toString();
        String edad = edtedad.getText().toString();
        String usuario = edtusuario.getText().toString();


        if (name.isEmpty() || lastname.isEmpty() || email.isEmpty() || edad.isEmpty() ||
                usuario.isEmpty() ||  pass.isEmpty()){
            displayToast("Rellena todos los campos");

        }

        else {
            dbHelper.addUser(usuario, pass);
            displayToast("Usuario Registrado");
            finish();
        }
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


}


