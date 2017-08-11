package center.innovus.nutriassist.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by personal on 10/08/17.
 */

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    public AdminSQLiteOpenHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table carbohidrato(id INTEGER PRIMARY KEY,identificacion text, carbohidratos numeric, fecha TIMESTAMP DEFAULT CURRENT_DATE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
        db.execSQL("drop table if exists carbohidrato");
        db.execSQL("create table carbohidrato(id INTEGER PRIMARY KEY,identificacion text, carbohidratos numeric, fecha DATE DEFAULT CURRENT_DATE)");
    }
}