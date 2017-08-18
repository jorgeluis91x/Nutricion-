package center.innovus.nutriassist.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;

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

    public double getPromedio(String identificacion){
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor fila = db.rawQuery("select round(avg(carbohidratos),1) from carbohidrato where identificacion = '"+ identificacion+"'", null);
        double promedio = 0;
        if(fila.moveToFirst()){
            promedio = fila.getDouble(0);
        }
        db.close();
        return promedio;
    }
    public ArrayList<Carbohidratos> getCarbohidratosByIdentificacion(String identificacion){

        ArrayList<Carbohidratos> carbohidratos = new ArrayList<Carbohidratos>();
        SQLiteDatabase db = admin.getWritableDatabase();

        Cursor fila = db.rawQuery("select identificacion, carbohidratos, fecha from carbohidrato where identificacion = '"+ identificacion+"'", null);

        if(fila.moveToFirst()){

            do{
                String prueba = fila.getString(2);
                carbohidratos.add(new Carbohidratos(fila.getString(0),fila.getDouble(1),prueba));

            } while (fila.moveToNext());


        }
        db.close();
        return carbohidratos;

    }
}
