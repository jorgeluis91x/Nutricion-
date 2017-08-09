package center.innovus.nutriassist.Activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import center.innovus.nutriassist.R;

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


    }
}
