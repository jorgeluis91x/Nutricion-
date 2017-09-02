package center.innovus.nutriassistClient.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import center.innovus.nutriassistClient.DataBase.CarbohidratosDao;
import center.innovus.nutriassistClient.Models.Carbohidratos;
import center.innovus.nutriassistClient.R;

public class CarbohidratosActivity extends AppCompatActivity {

    private EditText etCarbohidratos;
    private EditText etIdentification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carbohidratos);

        etCarbohidratos = (EditText) findViewById(R.id.etCarbohidratos);
        etIdentification = (EditText) findViewById(R.id.etIdentificacion);
    }

    public void agregarCarbohidratos(View v){
        String identificacion = etIdentification.getText()+ "";
        Double carbohidratos = Double.parseDouble( etCarbohidratos.getText()+"");
        CarbohidratosDao carbohidratosDao = new CarbohidratosDao(this);
        carbohidratosDao.create(new Carbohidratos(identificacion,carbohidratos));


        Intent mealsInGramsIntent = new Intent(CarbohidratosActivity.this, ComidasTabs.class);
        int carbo = Integer.parseInt(etCarbohidratos.getText()+"");
        mealsInGramsIntent.putExtra("cantCarbohidratos",carbo);
        mealsInGramsIntent.putExtra("identificacion",etIdentification.getText()+"");
        startActivity(mealsInGramsIntent);


    }
}
