package center.innovus.nutriassist.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import center.innovus.nutriassist.Models.Carbohidratos;

/**
 * Created by personal on 10/08/17.
 */

public class CarbohidratosDao {
    AdminSQLiteOpenHelper admin ;

    public CarbohidratosDao(Context context){
        admin = new AdminSQLiteOpenHelper(context,"carbohidratos", null, 1);

    }

    public void create(Carbohidratos carbohidratos){
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("identificacion", carbohidratos.getIdentificacion());
        registro.put("carbohidratos", carbohidratos.getCarbohidratos());
        db.insert("carbohidrato",null,registro);
        db.close();
    }
    public ArrayList<Carbohidratos> getCarbohidratosByIdentificacion(String identificacion){

        ArrayList<Carbohidratos> carbohidratos = new ArrayList<Carbohidratos>();
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor fila = db.rawQuery("select identificacion, carbohidratos, fecha from carbohidrato where identificacion ="+ identificacion, null);

        if(fila.moveToFirst()){

            carbohidratos.add(new Carbohidratos(fila.getString(0),fila.getDouble(1),fila.getString(3)));

        }
        db.close();
        return carbohidratos;

    }
}
