package movil.unicauca.peliculas;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import movil.unicauca.peliculas.databinding.ActivityRegistroBinding;
import movil.unicauca.peliculas.db.DbHelper;
import movil.unicauca.peliculas.models.SimpleResponse;
import movil.unicauca.peliculas.models.User;
import movil.unicauca.peliculas.net.UserService;
import movil.unicauca.peliculas.util.Data;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.View.OnClickListener;

public class RegistroActivity extends AppCompatActivity implements Callback<SimpleResponse> {

    //region comentar
    /*private DbHelper dbHelper;
    private Button btnregistrate;
    private EditText edtnombre, edtapellido, edtemail, edtedad, edtusuario, edtcontrasenia;*/
    //endregion
    ActivityRegistroBinding binding;
    UserService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_registro);
        binding.setHandler(this);

        service = Data.retrofit.create(UserService.class);

        //region comentar
        /*dbHelper = new DbHelper(this);
        btnregistrate = (Button) findViewById(R.id.btnregistrate);
        edtnombre = (EditText) findViewById(R.id.edtnombre);
        edtapellido = (EditText) findViewById(R.id.edtapellido);
        edtemail = (EditText) findViewById(R.id.edtemail);
        edtedad = (EditText) findViewById(R.id.edtedad);
        edtusuario = (EditText) findViewById(R.id.edtusuario);
        edtcontrasenia = (EditText) findViewById(R.id.edtcontrasenia);

        btnregistrate.setOnClickListener(this);*/
        //endregion
    }




    public void register(){
        String nombre = binding.edtnombre.getText().toString();
        String apellido = binding.edtapellido.getText().toString();
        String email = binding.edtemail.getText().toString();
        String edad = binding.edtedad.getText().toString();
        String ususario = binding.edtusuario.getText().toString();
        String contrasenia = binding.edtcontrasenia.getText().toString();
        User user = new User(nombre, apellido, email, edad, ususario, contrasenia);

        Call<SimpleResponse> request = service.registro(user);
        request.enqueue(this);
        //region Comentar
        /*String name = edtnombre.getText().toString();
        String pass = edtcontrasenia.getText().toString();
        String lastname = edtapellido.getText().toString();
        String email = edtemail.getText().toString();
        String edad = edtedad.getText().toString();
        String usuario = edtusuario.getText().toString();


        if (name.isEmpty() || lastname.isEmpty() || email.isEmpty() || edad.isEmpty() ||
                usuario.isEmpty() ||  pass.isEmpty()){
            displayToast(getString(R.string.rellenatodosloscampos));

        }

        else {
            dbHelper.addUser(usuario, pass);
            displayToast(getString(R.string.usuarioregistrado));
            finish();
        }*/
        //endregion
    }

    public void displayToast(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
        if (response.isSuccessful()){
            SimpleResponse res = response.body();
            if(res.isSuccess()){
                Toast.makeText(this, "Registro Exitoso !", Toast.LENGTH_SHORT).show();
                finish();
            }else {
                Toast.makeText(RegistroActivity.this, res.getMsg(), Toast.LENGTH_SHORT).show();

            }
        }

    }

    @Override
    public void onFailure(Call<SimpleResponse> call, Throwable t) {

    }
}


