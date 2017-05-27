package movil.unicauca.peliculas;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import movil.unicauca.peliculas.models.DaoMaster;
import movil.unicauca.peliculas.models.DaoSession;

/**
 * Created by sebastianl on 26/05/2017.
 */

public class App extends Application{

    public DaoSession session;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper= new DaoMaster.DevOpenHelper(this, "recuerdos.db");
        Database db = helper.getWritableDb();

        DaoMaster master = new DaoMaster(db);
        session = master.newSession();

    }
}
