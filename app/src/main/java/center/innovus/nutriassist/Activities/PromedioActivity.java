package center.innovus.nutriassist.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import java.util.ArrayList;

import center.innovus.nutriassist.Models.Carbohidratos;
import center.innovus.nutriassist.DataBase.CarbohidratosDao;
import center.innovus.nutriassist.Models.Tabla;
import center.innovus.nutriassist.R;

public class PromedioActivity extends AppCompatActivity {

    String identificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promedio);


        identificacion = getIntent().getStringExtra("identificacion");

        CarbohidratosDao cb = new CarbohidratosDao(getApplicationContext());

        ArrayList<Carbohidratos> carbohidratos = cb.getCarbohidratosByIdentificacion(identificacion);



        Tabla tabla = new Tabla(this, (TableLayout)findViewById(R.id.tabla));
        tabla.agregarCabecera(R.array.cabecera_tabla);
        for(int i = 0; i < carbohidratos.size(); i++)
        {
            ArrayList<String> elementos = new ArrayList<String>();
            elementos.add(carbohidratos.get(i).getFecha());
            elementos.add(carbohidratos.get(i).getCarbohidratos() + "");
            tabla.agregarFilaTabla(elementos);
        }

        ArrayList<String> elementos = new ArrayList<String>();
        elementos.add("Promedio");
        elementos.add (cb.getPromedio(identificacion)+"");
        tabla.agregarFilaTabla(elementos);
    }

    public void salir(View v){


        Intent homeIntent = new Intent(getApplicationContext(), CarbohidratosActivity.class);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(homeIntent);


    }
}