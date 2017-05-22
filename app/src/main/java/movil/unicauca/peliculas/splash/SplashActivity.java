package movil.unicauca.peliculas.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import movil.unicauca.peliculas.LoginActivity;
import movil.unicauca.peliculas.R;


/**
 * Created by Sebastianl on 18/05/2017.
 */

public class SplashActivity extends Activity {
    private long SPLAH_DELAY = 4000; //4 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION); //oculta la barra de los botones para los celulares que los tiene virtuales
        setContentView(R.layout.image_logo);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLAH_DELAY);
    }
}
